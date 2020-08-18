package com.beecode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beecode.entity.User;
import com.beecode.interfaces.UserService;
import com.beecode.repository.IUserRepository;
import com.beecode.util.BCryptPasswordDecode;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	IUserRepository userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepo.findByEmailValue(email);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User login(String email, String password) {
		Optional<User> userVerification = userRepo.findByEmailValue(email);
		BCryptPasswordDecode bCryptPasswordDecode = new BCryptPasswordDecode();
		if (userVerification.isPresent()) {
			if (bCryptPasswordDecode.decode(password, userVerification.get().getPassword())) {
				User user = userVerification.get();
				userRepo.save(user);
				return userVerification.get();
			}
		}
		return null;
	}
}
