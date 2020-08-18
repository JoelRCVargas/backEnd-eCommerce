package com.beecode.interfaces;

import java.util.List;
import java.util.Optional;

import com.beecode.entity.User;

public interface UserService {
	
	public User createUser(User user);
	public User updateUser(User user);
	public User getUserById(Long id);
	public void deleteUser(Long id);
	public Optional<User> getUserByEmail(String email);
	public List<User> getAllUser();
	public User login(String email, String password);
	
}
