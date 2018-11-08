package com.isarithm.account.repository;

import com.isarithm.account.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository
		extends JpaRepository<Device, UUID> {
}
