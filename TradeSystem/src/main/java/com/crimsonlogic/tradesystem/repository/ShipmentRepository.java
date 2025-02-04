package com.crimsonlogic.tradesystem.repository;

import com.crimsonlogic.tradesystem.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Optional<Shipment> findByContainerNumber(String containerNumber);
}
