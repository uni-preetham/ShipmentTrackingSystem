package com.crimsonlogic.tradesystem.service;

import com.crimsonlogic.tradesystem.DTO.ShipmentDTO;
import com.crimsonlogic.tradesystem.entity.Shipment;
import com.crimsonlogic.tradesystem.exception.ShipmentAlreadyExistsException;
import com.crimsonlogic.tradesystem.exception.ShipmentNotFoundException;
import com.crimsonlogic.tradesystem.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment createShipment(ShipmentDTO dto) {
        if (shipmentRepository.existsByContainerNumber(dto.getContainerNumber()) ||
                (dto.getBlNumber() != null && shipmentRepository.existsByBlNumber(dto.getBlNumber()))) {
            throw new ShipmentAlreadyExistsException("A shipment with this Container Number or BL Number already exists.");
        }
        Shipment shipment = new Shipment(
                null, // id is auto-generated, so we pass null here
                dto.getContainerNumber(),
                dto.getBlNumber(),
                dto.getOriginPort(),
                dto.getDestinationPort(),
                dto.getShipperName(),
                dto.getConsigneeName(),
                dto.getCargoType(),
                dto.getWeight(),
                dto.getVolume(),
                dto.getNumberOfPackages(),
                dto.getExpectedDepartureDate(),
                dto.getExpectedArrivalDate(),
                "Pending", // status is hardcoded as "Pending"
                dto.getCarrierName(),
                dto.getVesselName(),
                dto.getTrackingNumber(),
                dto.getModeOfTransport(),
                dto.getEta(),
                dto.getEtd(),
                dto.getHsCode(),
                dto.getCustomsDeclarationNumber(),
                dto.isDutiesPaid(),
                dto.getInspectionStatus(),
                dto.getNotes(),
                false, // deleted is false
                null, // lastModifiedBy is null initially
                null  // lastModifiedAt is null initially
        );

// Save the shipment to the repository
        return shipmentRepository.save(shipment);

    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll().stream()
                .filter(shipment -> !shipment.isDeleted())
                .toList();
    }

    public Shipment updateShipmentStatus(Long id, String status) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found"));

        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }

    public void deleteShipment(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found"));

        if ("Cleared".equals(shipment.getStatus())) {
            throw new IllegalStateException("Cleared shipments cannot be deleted.");
        }

        shipment.setDeleted(true);
        shipmentRepository.save(shipment);
    }
}
