package com.isarithm.account.web.model;

import com.isarithm.account.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserResponse {
	private UUID id;
	private String username;
	private String email;
	private Date regDate;

	public UserResponse(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.regDate = user.getRegDate();
	}
}
