package com.isarithm.account.web.model;

import lombok.Data;

import java.util.UUID;

@Data
public class DeviceRequest {
	private UUID modelId;
	private String name;
}
