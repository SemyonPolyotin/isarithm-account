package com.isarithm.account.services;

import com.isarithm.account.domain.Device;
import com.isarithm.account.domain.User;
import com.isarithm.account.web.model.DeviceRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface DeviceService {
	Page<Device> getDevices(Integer page, Integer size);
	Device createDevice(User owner, DeviceRequest deviceRequest);
	Device getDeviceById(UUID deviceId);
	Device updateDeviceById(UUID deviceId, DeviceRequest deviceRequest);
	void deleteDeviceById(UUID deviceId);
}
