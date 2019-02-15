package com.isarithm.account.domain;

import lombok.Data;
import lombok.experimental.Accessors;

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
	@GeneratedValue
	private Integer id;

	@Column(name = "devices_model_id", nullable = false)
	private UUID modelId;

	@Column(name = "devices_reg_date", nullable = false)
	private Date regDate;

	@Column(name = "devices_name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "devices_owner_id", nullable = false)
	private User owner;
}