package com.crimsonlogic.tradesystem.controller;

import com.crimsonlogic.tradesystem.DTO.ShipmentDTO;
import com.crimsonlogic.tradesystem.entity.Shipment;
import com.crimsonlogic.tradesystem.exception.ShipmentNotFoundException;
import com.crimsonlogic.tradesystem.repository.ShipmentRepository;
import com.crimsonlogic.tradesystem.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    @Autowired
    public ShipmentRepository shipmentRepository;

    private final ShipmentService shipmentService;

    @PostMapping
    public Shipment createShipment(@RequestBody ShipmentDTO shipmentDTO) {
        return shipmentService.createShipment(shipmentDTO);
    }

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @PutMapping("/{id}/status")
    public Shipment updateShipmentStatus(@PathVariable Long id, @RequestParam String status) {
        return shipmentService.updateShipmentStatus(id, status);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateShipment(@PathVariable Long id, @RequestBody ShipmentDTO shipmentDTO) {
//        try {
//            Shipment updatedShipment = shipmentService.updateShipment(id, shipmentDTO);
//            return ResponseEntity.ok(updatedShipment);
//        } catch (ShipmentNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id, @RequestBody ShipmentDTO dto) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found"));

        shipment.setOriginPort(dto.getOriginPort());
        shipment.setDestinationPort(dto.getDestinationPort());
        shipment.setStatus(dto.getStatus());
        shipment.setNotes(dto.getNotes());
        shipment.setHsCode(dto.getHsCode());
        shipment.setCustomsDeclarationNumber(dto.getCustomsDeclarationNumber());
        shipment.setDutiesPaid(dto.isDutiesPaid());
        shipment.setInspectionStatus(dto.getInspectionStatus());
        shipment.setWeight(dto.getWeight());
        shipment.setVolume(dto.getVolume());
        return shipmentRepository.save(shipment);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long id) {
        try {
            shipmentService.deleteShipment(id);
            return ResponseEntity.ok("Shipment deleted successfully!");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
}
