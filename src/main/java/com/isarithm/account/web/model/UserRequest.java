package com.isarithm.account.web.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserRequest {
	private UUID id;
	private String username;
	private String email;
	private Date regDate;
}
