package com.crimsonlogic.tradesystem.controller;

import com.crimsonlogic.tradesystem.DTO.ShipmentDTO;
import com.crimsonlogic.tradesystem.entity.Shipment;
import com.crimsonlogic.tradesystem.exception.ShipmentNotFoundException;
import com.crimsonlogic.tradesystem.repository.ShipmentRepository;
import com.crimsonlogic.tradesystem.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    @Autowired
    public ShipmentRepository shipmentRepository;

    @Autowired
    private ShipmentService shipmentService;

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

        shipment.setLastModifiedBy(dto.getLastModifiedBy());
        shipment.setLastModifiedAt(LocalDateTime.now());

        return shipmentRepository.save(shipment);
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteShipment(@PathVariable Long id) {
//        try {
//            shipmentService.deleteShipment(id);
//            return ResponseEntity.ok("Shipment deleted successfully!");
//        } catch (IllegalStateException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long id, @RequestBody(required = false) ShipmentDTO dto) {
        if (dto == null || dto.getLastModifiedBy() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing lastModifiedBy in request.");
        }

        try {
            shipmentService.deleteShipment(id, dto);
            return ResponseEntity.ok("Shipment deleted successfully!");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
}
