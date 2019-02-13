package com.isarithm.account.web.model;

import com.isarithm.account.domain.Device;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class DeviceResponse {
	private UUID id;
	private String model;
	private UUID ownerId;
	private Date regDate;

	public DeviceResponse(Device device) {
		this.id = device.getId();
		this.model = device.getModel();
		this.ownerId = device.getOwner().getId();
		this.regDate = device.getRegDate();
	}
}
