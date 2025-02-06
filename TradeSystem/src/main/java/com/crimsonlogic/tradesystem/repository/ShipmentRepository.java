package com.crimsonlogic.tradesystem.repository;

import com.crimsonlogic.tradesystem.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Optional<Shipment> findByContainerNumber(String containerNumber);

    // Check if a shipment with the given container number exists
    boolean existsByContainerNumber(String containerNumber);

    // Check if a shipment with the given BL number exists
    boolean existsByBlNumber(String blNumber);
}
