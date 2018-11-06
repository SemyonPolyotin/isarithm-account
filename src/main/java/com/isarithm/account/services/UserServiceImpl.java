package com.isarithm.account.services;

import com.isarithm.account.domain.User;
import com.isarithm.account.repository.UserRepository;
import com.isarithm.account.web.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> getUsers(Integer page, Integer size) {
		return null;
	}

	@Override
	public Page<User> getUsersWithUsername(String username, Integer page, Integer size) {
		return userRepository.getUsersByUsernameContainingIgnoreCase(username, PageRequest.of(page, size));
	}

	@Override
	public User createUser(UserRequest userRequest) {
		User user = new User()
				.setId(userRequest.getId())
				.setUsername(userRequest.getUsername())
				.setEmail(userRequest.getEmail())
				.setRegDate(userRequest.getRegDate());
		return userRepository.save(user);
	}

	@Override
	public User getUserById(UUID userId) {
		return userRepository.getUserById(userId)
				.orElseThrow(() -> new EntityNotFoundException("User with id {" + userId + "} not found"));
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsernameIgnoreCase(username);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmailIgnoreCase(email);
	}

	@Override
	public User updateUserById(UUID userId, UserRequest userRequest) {
		User user = this.getUserById(userId);
		if (userRequest.getUsername() != null) user.setUsername(userRequest.getUsername());
		if (userRequest.getEmail() != null) user.setEmail(userRequest.getEmail());
		if (userRequest.getRegDate() != null) user.setRegDate(userRequest.getRegDate());
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(UUID userId) {
		userRepository.deleteUserById(userId);
	}
}
