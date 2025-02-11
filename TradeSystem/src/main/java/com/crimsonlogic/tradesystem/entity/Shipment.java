package com.crimsonlogic.tradesystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
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

    @Column(name = "last_modified_by")
    private String lastModifiedBy; // User who made the latest change

    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    public Shipment(Long id, String containerNumber, String blNumber, String originPort, String destinationPort, String shipperName, String consigneeName, String cargoType, double weight, double volume, int numberOfPackages, LocalDate expectedDepartureDate, LocalDate expectedArrivalDate, String status, String carrierName, String vesselName, String trackingNumber, String modeOfTransport, LocalDate eta, LocalDate etd, String hsCode, String customsDeclarationNumber, boolean dutiesPaid, String inspectionStatus, String notes, boolean deleted, String lastModifiedBy, LocalDateTime lastModifiedAt) {
        this.id = id;
        this.containerNumber = containerNumber;
        this.blNumber = blNumber;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.shipperName = shipperName;
        this.consigneeName = consigneeName;
        this.cargoType = cargoType;
        this.weight = weight;
        this.volume = volume;
        this.numberOfPackages = numberOfPackages;
        this.expectedDepartureDate = expectedDepartureDate;
        this.expectedArrivalDate = expectedArrivalDate;
        this.status = status;
        this.carrierName = carrierName;
        this.vesselName = vesselName;
        this.trackingNumber = trackingNumber;
        this.modeOfTransport = modeOfTransport;
        this.eta = eta;
        this.etd = etd;
        this.hsCode = hsCode;
        this.customsDeclarationNumber = customsDeclarationNumber;
        this.dutiesPaid = dutiesPaid;
        this.inspectionStatus = inspectionStatus;
        this.notes = notes;
        this.deleted = deleted;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedAt = lastModifiedAt;
    }

    public Shipment() {
    }



    public Long getId() {
        return this.id;
    }

    public String getContainerNumber() {
        return this.containerNumber;
    }

    public String getBlNumber() {
        return this.blNumber;
    }

    public String getOriginPort() {
        return this.originPort;
    }

    public String getDestinationPort() {
        return this.destinationPort;
    }

    public String getShipperName() {
        return this.shipperName;
    }

    public String getConsigneeName() {
        return this.consigneeName;
    }

    public String getCargoType() {
        return this.cargoType;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getVolume() {
        return this.volume;
    }

    public int getNumberOfPackages() {
        return this.numberOfPackages;
    }

    public LocalDate getExpectedDepartureDate() {
        return this.expectedDepartureDate;
    }

    public LocalDate getExpectedArrivalDate() {
        return this.expectedArrivalDate;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCarrierName() {
        return this.carrierName;
    }

    public String getVesselName() {
        return this.vesselName;
    }

    public String getTrackingNumber() {
        return this.trackingNumber;
    }

    public String getModeOfTransport() {
        return this.modeOfTransport;
    }

    public LocalDate getEta() {
        return this.eta;
    }

    public LocalDate getEtd() {
        return this.etd;
    }

    public String getHsCode() {
        return this.hsCode;
    }

    public String getCustomsDeclarationNumber() {
        return this.customsDeclarationNumber;
    }

    public boolean isDutiesPaid() {
        return this.dutiesPaid;
    }

    public String getInspectionStatus() {
        return this.inspectionStatus;
    }

    public String getNotes() {
        return this.notes;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public void setBlNumber(String blNumber) {
        this.blNumber = blNumber;
    }

    public void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setNumberOfPackages(int numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    public void setExpectedDepartureDate(LocalDate expectedDepartureDate) {
        this.expectedDepartureDate = expectedDepartureDate;
    }

    public void setExpectedArrivalDate(LocalDate expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public void setEta(LocalDate eta) {
        this.eta = eta;
    }

    public void setEtd(LocalDate etd) {
        this.etd = etd;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public void setCustomsDeclarationNumber(String customsDeclarationNumber) {
        this.customsDeclarationNumber = customsDeclarationNumber;
    }

    public void setDutiesPaid(boolean dutiesPaid) {
        this.dutiesPaid = dutiesPaid;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }


    public String toString() {
        return "Shipment(id=" + this.getId() + ", containerNumber=" + this.getContainerNumber() + ", blNumber=" + this.getBlNumber() + ", originPort=" + this.getOriginPort() + ", destinationPort=" + this.getDestinationPort() + ", shipperName=" + this.getShipperName() + ", consigneeName=" + this.getConsigneeName() + ", cargoType=" + this.getCargoType() + ", weight=" + this.getWeight() + ", volume=" + this.getVolume() + ", numberOfPackages=" + this.getNumberOfPackages() + ", expectedDepartureDate=" + this.getExpectedDepartureDate() + ", expectedArrivalDate=" + this.getExpectedArrivalDate() + ", status=" + this.getStatus() + ", carrierName=" + this.getCarrierName() + ", vesselName=" + this.getVesselName() + ", trackingNumber=" + this.getTrackingNumber() + ", modeOfTransport=" + this.getModeOfTransport() + ", eta=" + this.getEta() + ", etd=" + this.getEtd() + ", hsCode=" + this.getHsCode() + ", customsDeclarationNumber=" + this.getCustomsDeclarationNumber() + ", dutiesPaid=" + this.isDutiesPaid() + ", inspectionStatus=" + this.getInspectionStatus() + ", notes=" + this.getNotes() + ", deleted=" + this.isDeleted() + ")";
    }


}
