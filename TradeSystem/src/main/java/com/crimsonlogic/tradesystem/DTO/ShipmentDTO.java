package com.crimsonlogic.tradesystem.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentDTO {
    private String containerNumber;
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
    private String status;
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
}
