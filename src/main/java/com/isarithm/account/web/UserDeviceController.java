package com.isarithm.account.web;

import com.isarithm.account.services.UserService;
import com.isarithm.account.web.model.DeviceRequest;
import com.isarithm.account.web.model.DeviceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = UserDeviceController.baseUri)
public class UserDeviceController {
	static final String baseUri = "/users";

	private final UserService userService;

	@Autowired
	public UserDeviceController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/devices")
	public Page<DeviceResponse> getDevices(@PathVariable("userId") UUID userId,
										   @RequestParam(value = "page", defaultValue = "0") Integer page,
										   @RequestParam(value = "size", defaultValue = "25") Integer size) {
		return userService.getDevices(userId, page, size)
				.map(DeviceResponse::new);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}/devices")
	public DeviceResponse createDevice(@PathVariable("userId") UUID userId,
									   @RequestBody DeviceRequest deviceRequest) {
		return new DeviceResponse(userService.createDevice(userId, deviceRequest));
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/{userId}/devices/{deviceId}")
	public DeviceResponse updateDevice(@PathVariable("userId") UUID userId,
									   @PathVariable("deviceId") UUID deviceId,
									   @RequestBody DeviceRequest deviceRequest) {
		return new DeviceResponse(userService.updateDevice(userId, deviceId, deviceRequest));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{userId}/devices/{deviceId}")
	public void deleteDevice(@PathVariable("userId") UUID userId,
							 @PathVariable("deviceId") UUID deviceId) {
		userService.deleteDevice(userId, deviceId);
	}
}
