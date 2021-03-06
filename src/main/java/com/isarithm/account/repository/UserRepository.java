package com.isarithm.account.repository;

import com.isarithm.account.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository
		extends JpaRepository<User, UUID> {
	Optional<User> getUserById(UUID uuid);

	void deleteUserById(UUID uuid);

	User getUserByUsernameIgnoreCase(String username);

	User getUserByEmailIgnoreCase(String regEmail);

	Page<User> getUsersByUsernameContainingIgnoreCase(String username, Pageable pageable);
}
