package com.isarithm.account.services;

import com.isarithm.account.domain.Device;
import com.isarithm.account.domain.User;
import com.isarithm.account.repository.DeviceRepository;
import com.isarithm.account.web.model.DeviceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
	private final DeviceRepository deviceRepository;

	@Autowired
	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	@Override
	public Page<Device> getDevices(Integer page, Integer size) {
		return deviceRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Device createDevice(User owner, DeviceRequest deviceRequest) {
		Device device = new Device()
				.setModel(deviceRequest.getModel())
				.setOwner(owner)
				.setRegDate(new Date());
		return deviceRepository.save(device);
	}

	@Override
	public Device getDeviceById(UUID deviceId) {
		return deviceRepository.getOne(deviceId);
	}

	@Override
	public Device updateDeviceById(UUID deviceId, DeviceRequest deviceRequest) {
		Device device = this.getDeviceById(deviceId);
		// TODO: update logic
		return deviceRepository.save(device);
	}

	@Override
	public void deleteDeviceById(UUID deviceId) {
		deviceRepository.deleteById(deviceId);
	}
}
