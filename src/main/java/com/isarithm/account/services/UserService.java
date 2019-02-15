package com.isarithm.account.services;

import com.isarithm.account.domain.Device;
import com.isarithm.account.domain.User;
import com.isarithm.account.web.model.DeviceRequest;
import com.isarithm.account.web.model.UserRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {
	Page<User> getUsers(Integer page, Integer size);
	Page<User> getUsersWithUsername(String username, Integer page, Integer size);
	User createUser(UserRequest userRequest);
	User getUserById(UUID userId);
	User getUserByUsername(String username);
	User getUserByEmail(String email);
	User updateUserById(UUID userId, UserRequest userRequest);
	void deleteUserById(UUID userId);

	Page<Device> getDevices(UUID userId, Integer page, Integer size);
	Device createDevice(UUID userId, DeviceRequest deviceRequest);
	Device updateDevice(UUID userId, Integer deviceId, DeviceRequest deviceRequest);
	void deleteDevice(UUID userId, Integer deviceId);
}
