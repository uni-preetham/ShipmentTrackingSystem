package com.crimsonlogic.tradesystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String containerNumber;

    @Column(unique = true)
    private String blNumber;

    private String originPort;
    private String destinationPort;
    private String shipperName;
    private String consigneeName;
    private String cargoType;
    private double weight;
    private double volume;
    private int numberOfPackages;

    private LocalDate expectedDepartureDate;
    private LocalDate expectedArrivalDate;
    private String status; // Pending, In Transit, Arrived, Cleared

    private String carrierName;
    private String vesselName;
    private String trackingNumber;
    private String modeOfTransport;
    private LocalDate eta;
    private LocalDate etd;

    private String hsCode;
    private String customsDeclarationNumber;
    private boolean dutiesPaid;
    private String inspectionStatus;

    private String notes;
    
    @Column(nullable = false)
    private boolean deleted = false; // Soft delete
}
