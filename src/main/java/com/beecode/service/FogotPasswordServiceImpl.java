package com.beecode.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beecode.entity.ForgotPassword;
import com.beecode.entity.User;
import com.beecode.interfaces.ForgotPasswordService;
import com.beecode.repository.IForgotPasswordRepository;
import com.beecode.repository.IUserRepository;
import com.beecode.util.PasswordEncoder;

@Service
public class FogotPasswordServiceImpl implements ForgotPasswordService {
	
	private IForgotPasswordRepository forgotPasswordRepo;
	private IUserRepository userRepo;
	private SendingMailService sendingMailService;

	@Autowired
	public FogotPasswordServiceImpl(IForgotPasswordRepository forgotPasswordRepo, IUserRepository userRepo,
			SendingMailService sendingMailService) {
		this.forgotPasswordRepo = forgotPasswordRepo;
		this.userRepo = userRepo;
		this.sendingMailService = sendingMailService;
	}

	@Override
	public ResponseEntity<String> sendEmailForgotPassword(String email) {
		Optional<ForgotPassword> getForgotPassword;
		Optional<User> getUserByEmail = userRepo.findByEmailValue(email);
		ForgotPassword forgotPassword;
		User user = null;
		if(getUserByEmail.isPresent()) {
			getForgotPassword = forgotPasswordRepo.findByUserEmailValue(email);
			if(!getForgotPassword.isPresent()) {
				forgotPassword = new ForgotPassword();
				user = getUserByEmail.get();
				forgotPassword.setUser(user);
			}else {
				forgotPassword = getForgotPassword.get();
				if(forgotPassword.getExpiredDateTime().isBefore(LocalDateTime.now()) ||
						forgotPassword.getStatus().equals(ForgotPassword.STATUS_USED)) {
					//Update forgotPassword +1 Hour
					forgotPassword.setExpiredDateTime(LocalDateTime.now().plusHours(1));
					forgotPassword.setStatus(ForgotPassword.STATUS_NO_USED);
				}
			}
			forgotPasswordRepo.save(forgotPassword);
			sendingMailService.sendForgotPasswordMail(email, getForgotPassword.get().getToken(),ForgotPassword.LINK_DEVELOPERS
					, getForgotPassword.get().getUser().getPerson().getFirstName() + " " + getForgotPassword.get().getUser().getPerson().getLastName());
			return ResponseEntity.ok().body(ForgotPassword.SUCCESSFULLY);
		}else {
			return ResponseEntity.ok().body(ForgotPassword.UNKNOWN_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> verificationTokenForgotPassword(String token) {
		Optional<ForgotPassword> findBytoken = forgotPasswordRepo.findByToken(token);
		if(findBytoken.isPresent()) {
			if(findBytoken.get().getExpiredDateTime().isBefore(LocalDateTime.now()) ||
					findBytoken.get().getStatus().equals(ForgotPassword.STATUS_USED)) {
				return ResponseEntity.ok().body(ForgotPassword.UNKNOWN_ERROR);
			}else {
				return ResponseEntity.ok().body(ForgotPassword.SUCCESSFULLY);
			}
		}else {
			return ResponseEntity.ok().body(ForgotPassword.UNKNOWN_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> forgotPassword(String token, String password) {
		Optional<ForgotPassword> findByToken = forgotPasswordRepo.findByToken(token);
		ForgotPassword forgotPassword;
		User user;
		try {
			if(findByToken.get().getExpiredDateTime().isBefore(LocalDateTime.now()) ||
					findByToken.get().getStatus().equals(ForgotPassword.STATUS_USED)) {
			}else {
				user  = findByToken.get().getUser();
				user.setPassword(new PasswordEncoder(password));
				
				forgotPassword = findByToken.get();
				forgotPassword.setStatus(ForgotPassword.STATUS_USED);
				forgotPassword.setUser(user);
				
				forgotPasswordRepo.save(forgotPassword);
				
				return ResponseEntity.ok().body("Se cambio exitosamente la contraseña.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().body(ForgotPassword.UNKNOWN_ERROR);
	}
	
	
	
}
