package com.isarithm.account.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "users", schema = "account")
public class User {
	@Id
	@Column(name = "users_id")
//	@GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
//	@GenericGenerator(
//		name = "uuid2",
//		strategy = "org.hibernate.id.UUIDGenerator"
//	)
	private UUID id;

	@Column(name = "users_username", nullable = false, unique = true)
	private String username;

	@Column(name = "users_email", nullable = false, unique = true)
	private String email;

	@Column(name = "users_reg_date")
	private Date regDate;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Device> devices;
}
