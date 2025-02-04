package com.crimsonlogic.tradesystem.service;

import com.crimsonlogic.tradesystem.DTO.ShipmentDTO;
import com.crimsonlogic.tradesystem.entity.Shipment;
import com.crimsonlogic.tradesystem.exception.ShipmentNotFoundException;
import com.crimsonlogic.tradesystem.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public Shipment createShipment(ShipmentDTO dto) {
        Shipment shipment = Shipment.builder()
                .containerNumber(dto.getContainerNumber())
                .blNumber(dto.getBlNumber())
                .originPort(dto.getOriginPort())
                .destinationPort(dto.getDestinationPort())
                .shipperName(dto.getShipperName())
                .consigneeName(dto.getConsigneeName())
                .cargoType(dto.getCargoType())
                .weight(dto.getWeight())
                .volume(dto.getVolume())
                .numberOfPackages(dto.getNumberOfPackages())
                .expectedDepartureDate(dto.getExpectedDepartureDate())
                .expectedArrivalDate(dto.getExpectedArrivalDate())
                .status("Pending")
                .carrierName(dto.getCarrierName())
                .vesselName(dto.getVesselName())
                .trackingNumber(dto.getTrackingNumber())
                .modeOfTransport(dto.getModeOfTransport())
                .eta(dto.getEta())
                .etd(dto.getEtd())
                .hsCode(dto.getHsCode())
                .customsDeclarationNumber(dto.getCustomsDeclarationNumber())
                .dutiesPaid(dto.isDutiesPaid())
                .inspectionStatus(dto.getInspectionStatus())
                .notes(dto.getNotes())
                .deleted(false)
                .build();

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
