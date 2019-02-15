package com.isarithm.account.web.model;

import com.isarithm.account.domain.Device;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class DeviceResponse {
	private Integer id;
	private UUID modelId;
	private UUID ownerId;
	private Date regDate;
	private String name;

	public DeviceResponse(Device device) {
		this.id = device.getId();
		this.modelId = device.getModelId();
		this.ownerId = device.getOwner().getId();
		this.regDate = device.getRegDate();
		this.name = device.getName();
	}
}
