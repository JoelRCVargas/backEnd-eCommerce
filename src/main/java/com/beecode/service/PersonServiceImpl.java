package com.beecode.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beecode.entity.Email;
import com.beecode.entity.Person;
import com.beecode.entity.Role;
import com.beecode.entity.User;
import com.beecode.entity.VerificationToken;
import com.beecode.interfaces.PersonService;
import com.beecode.repository.IPersonRepository;
import com.beecode.repository.IRoleRepository;
import com.beecode.repository.IUserRepository;
import com.beecode.repository.IVerificationTokenRepository;
import com.beecode.util.PasswordEncoder;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	private IPersonRepository personRepo;
	private SendingMailService sendingMailService;
	private IVerificationTokenRepository verficationTokenRepo;
	private IRoleRepository roleRepo;


	@Autowired
	public PersonServiceImpl(IPersonRepository personRepo, IUserRepository userRepo,
			SendingMailService sendingMailService, IVerificationTokenRepository verficationTokenRepo, IRoleRepository roleRepo) {
		this.personRepo = personRepo;
		this.sendingMailService = sendingMailService;
		this.verficationTokenRepo = verficationTokenRepo;
		this.roleRepo = roleRepo;
	}

	@Override
	public Person createPerson(Person person) {
		try {
			Set<Role> roles = roleRepo.findByRoleName(Role.ROLE_USER);
			String email = person.getEmail();
			User user = new User();
			user.setEmail(new Email(email));
			user.setPassword(new PasswordEncoder(person.getPassword()));
			user.setStatus(true);
			user.setEnabled(false);
			user.setRoles(roles);

			List<VerificationToken> verificationTokens = verficationTokenRepo.findByUserEmailValue(email);
			VerificationToken verificationToken;
			if (verificationTokens.isEmpty()) {
				verificationToken = new VerificationToken();
				verificationToken.setUser(user);
				user.setVerificationToken(verificationToken);
			} else {
				verificationToken = verificationTokens.get(0);
			}
			person.setUser(user);
			sendingMailService.sendVerificationMail(email, verificationToken.getToken());

		} catch (RuntimeException re) {
			re.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personRepo.save(person);
	}

	public ResponseEntity<String> verifyEmail(String token) {
		List<VerificationToken> verificationTokens = verficationTokenRepo.findByToken(token);
		if (verificationTokens.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid token.");
		}

		VerificationToken verificationToken = verificationTokens.get(0);
		if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
			return ResponseEntity.unprocessableEntity().body("Expired token.");
		}

		verificationToken.setConfirmedDateTime(LocalDateTime.now());
		verificationToken.setStatus(VerificationToken.STATUS_VERIFIED);
		verificationToken.getUser().setEnabled(true);
		verficationTokenRepo.save(verificationToken);

		return ResponseEntity.ok("You have successfully verified your email address.");
	}

	@Override
	public Person updatePerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Person getPerson(Long personId) {
		Optional<Person> optionalPerson = personRepo.findById(personId);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		return null;
	}

	@Override
	public void deletePerson(Long personId) {
		personRepo.deleteById(personId);
	}

	@Override
	public List<Person> getAllPerson() {
		return personRepo.findAll();
	}

}
