package com.isarithm.account.services;

import com.isarithm.account.domain.Device;
import com.isarithm.account.domain.User;
import com.isarithm.account.web.model.DeviceRequest;
import org.springframework.data.domain.Page;

public interface DeviceService {
	Page<Device> getDevices(Integer page, Integer size);
	Device createDevice(User owner, DeviceRequest deviceRequest);
	Device getDeviceById(Integer deviceId);
	Device updateDeviceById(Integer deviceId, DeviceRequest deviceRequest);
	void deleteDeviceById(Integer deviceId);
}
