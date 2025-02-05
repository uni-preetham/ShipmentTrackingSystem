package com.crimsonlogic.tradesystem.controller;

import com.crimsonlogic.tradesystem.DTO.ShipmentDTO;
import com.crimsonlogic.tradesystem.entity.Shipment;
import com.crimsonlogic.tradesystem.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

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
