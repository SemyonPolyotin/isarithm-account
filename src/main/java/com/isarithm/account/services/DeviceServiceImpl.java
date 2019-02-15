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
				.setModelId(deviceRequest.getModelId())
				.setOwner(owner)
				.setName(deviceRequest.getName())
				.setRegDate(new Date());
		return deviceRepository.save(device);
	}

	@Override
	public Device getDeviceById(Integer deviceId) {
		return deviceRepository.getOne(deviceId);
	}

	@Override
	public Device updateDeviceById(Integer deviceId, DeviceRequest deviceRequest) {
		Device device = this.getDeviceById(deviceId);
		if (deviceRequest.getName() != null) device.setName(deviceRequest.getName());
		return deviceRepository.save(device);
	}

	@Override
	public void deleteDeviceById(Integer deviceId) {
		deviceRepository.deleteById(deviceId);
	}
}
