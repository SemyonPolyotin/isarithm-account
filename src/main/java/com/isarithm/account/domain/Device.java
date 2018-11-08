package com.isarithm.account.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "devices", schema = "account")
public class Device {
	@Id
	@Column(name = "devices_id")
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
	@GenericGenerator(
			name = "uuid2",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;

	@Column(name = "devices_model", nullable = false)
	private String model;

	@Column(name = "devices_reg_date")
	private Date regDate;

	@ManyToOne
	@JoinColumn(name = "devices_owner_id", nullable = false)
	private User owner;
}