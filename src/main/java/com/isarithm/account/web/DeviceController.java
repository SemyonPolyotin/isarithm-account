package com.isarithm.account.web;

import com.isarithm.account.services.DeviceService;
import com.isarithm.account.web.model.DeviceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DeviceController.baseUri)
public class DeviceController {
	public static final String baseUri = "/devices";

	private final DeviceService deviceService;

	@Autowired
	public DeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<DeviceResponse> getDevices(@RequestParam(value = "page", defaultValue = "0") Integer page,
										   @RequestParam(value = "size", defaultValue = "25") Integer size) {
		return deviceService.getDevices(page, size)
				.map(DeviceResponse::new);
	}
}
