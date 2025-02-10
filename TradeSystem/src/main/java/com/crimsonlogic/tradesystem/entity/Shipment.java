package com.crimsonlogic.tradesystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Shipment(Long id, String containerNumber, String blNumber, String originPort, String destinationPort, String shipperName, String consigneeName, String cargoType, double weight, double volume, int numberOfPackages, LocalDate expectedDepartureDate, LocalDate expectedArrivalDate, String status, String carrierName, String vesselName, String trackingNumber, String modeOfTransport, LocalDate eta, LocalDate etd, String hsCode, String customsDeclarationNumber, boolean dutiesPaid, String inspectionStatus, String notes, boolean deleted) {
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
    }

    public Shipment() {
    }

    public static ShipmentBuilder builder() {
        return new ShipmentBuilder();
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Shipment)) return false;
        final Shipment other = (Shipment) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$containerNumber = this.getContainerNumber();
        final Object other$containerNumber = other.getContainerNumber();
        if (this$containerNumber == null ? other$containerNumber != null : !this$containerNumber.equals(other$containerNumber))
            return false;
        final Object this$blNumber = this.getBlNumber();
        final Object other$blNumber = other.getBlNumber();
        if (this$blNumber == null ? other$blNumber != null : !this$blNumber.equals(other$blNumber)) return false;
        final Object this$originPort = this.getOriginPort();
        final Object other$originPort = other.getOriginPort();
        if (this$originPort == null ? other$originPort != null : !this$originPort.equals(other$originPort))
            return false;
        final Object this$destinationPort = this.getDestinationPort();
        final Object other$destinationPort = other.getDestinationPort();
        if (this$destinationPort == null ? other$destinationPort != null : !this$destinationPort.equals(other$destinationPort))
            return false;
        final Object this$shipperName = this.getShipperName();
        final Object other$shipperName = other.getShipperName();
        if (this$shipperName == null ? other$shipperName != null : !this$shipperName.equals(other$shipperName))
            return false;
        final Object this$consigneeName = this.getConsigneeName();
        final Object other$consigneeName = other.getConsigneeName();
        if (this$consigneeName == null ? other$consigneeName != null : !this$consigneeName.equals(other$consigneeName))
            return false;
        final Object this$cargoType = this.getCargoType();
        final Object other$cargoType = other.getCargoType();
        if (this$cargoType == null ? other$cargoType != null : !this$cargoType.equals(other$cargoType)) return false;
        if (Double.compare(this.getWeight(), other.getWeight()) != 0) return false;
        if (Double.compare(this.getVolume(), other.getVolume()) != 0) return false;
        if (this.getNumberOfPackages() != other.getNumberOfPackages()) return false;
        final Object this$expectedDepartureDate = this.getExpectedDepartureDate();
        final Object other$expectedDepartureDate = other.getExpectedDepartureDate();
        if (this$expectedDepartureDate == null ? other$expectedDepartureDate != null : !this$expectedDepartureDate.equals(other$expectedDepartureDate))
            return false;
        final Object this$expectedArrivalDate = this.getExpectedArrivalDate();
        final Object other$expectedArrivalDate = other.getExpectedArrivalDate();
        if (this$expectedArrivalDate == null ? other$expectedArrivalDate != null : !this$expectedArrivalDate.equals(other$expectedArrivalDate))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$carrierName = this.getCarrierName();
        final Object other$carrierName = other.getCarrierName();
        if (this$carrierName == null ? other$carrierName != null : !this$carrierName.equals(other$carrierName))
            return false;
        final Object this$vesselName = this.getVesselName();
        final Object other$vesselName = other.getVesselName();
        if (this$vesselName == null ? other$vesselName != null : !this$vesselName.equals(other$vesselName))
            return false;
        final Object this$trackingNumber = this.getTrackingNumber();
        final Object other$trackingNumber = other.getTrackingNumber();
        if (this$trackingNumber == null ? other$trackingNumber != null : !this$trackingNumber.equals(other$trackingNumber))
            return false;
        final Object this$modeOfTransport = this.getModeOfTransport();
        final Object other$modeOfTransport = other.getModeOfTransport();
        if (this$modeOfTransport == null ? other$modeOfTransport != null : !this$modeOfTransport.equals(other$modeOfTransport))
            return false;
        final Object this$eta = this.getEta();
        final Object other$eta = other.getEta();
        if (this$eta == null ? other$eta != null : !this$eta.equals(other$eta)) return false;
        final Object this$etd = this.getEtd();
        final Object other$etd = other.getEtd();
        if (this$etd == null ? other$etd != null : !this$etd.equals(other$etd)) return false;
        final Object this$hsCode = this.getHsCode();
        final Object other$hsCode = other.getHsCode();
        if (this$hsCode == null ? other$hsCode != null : !this$hsCode.equals(other$hsCode)) return false;
        final Object this$customsDeclarationNumber = this.getCustomsDeclarationNumber();
        final Object other$customsDeclarationNumber = other.getCustomsDeclarationNumber();
        if (this$customsDeclarationNumber == null ? other$customsDeclarationNumber != null : !this$customsDeclarationNumber.equals(other$customsDeclarationNumber))
            return false;
        if (this.isDutiesPaid() != other.isDutiesPaid()) return false;
        final Object this$inspectionStatus = this.getInspectionStatus();
        final Object other$inspectionStatus = other.getInspectionStatus();
        if (this$inspectionStatus == null ? other$inspectionStatus != null : !this$inspectionStatus.equals(other$inspectionStatus))
            return false;
        final Object this$notes = this.getNotes();
        final Object other$notes = other.getNotes();
        if (this$notes == null ? other$notes != null : !this$notes.equals(other$notes)) return false;
        if (this.isDeleted() != other.isDeleted()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Shipment;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $containerNumber = this.getContainerNumber();
        result = result * PRIME + ($containerNumber == null ? 43 : $containerNumber.hashCode());
        final Object $blNumber = this.getBlNumber();
        result = result * PRIME + ($blNumber == null ? 43 : $blNumber.hashCode());
        final Object $originPort = this.getOriginPort();
        result = result * PRIME + ($originPort == null ? 43 : $originPort.hashCode());
        final Object $destinationPort = this.getDestinationPort();
        result = result * PRIME + ($destinationPort == null ? 43 : $destinationPort.hashCode());
        final Object $shipperName = this.getShipperName();
        result = result * PRIME + ($shipperName == null ? 43 : $shipperName.hashCode());
        final Object $consigneeName = this.getConsigneeName();
        result = result * PRIME + ($consigneeName == null ? 43 : $consigneeName.hashCode());
        final Object $cargoType = this.getCargoType();
        result = result * PRIME + ($cargoType == null ? 43 : $cargoType.hashCode());
        final long $weight = Double.doubleToLongBits(this.getWeight());
        result = result * PRIME + (int) ($weight >>> 32 ^ $weight);
        final long $volume = Double.doubleToLongBits(this.getVolume());
        result = result * PRIME + (int) ($volume >>> 32 ^ $volume);
        result = result * PRIME + this.getNumberOfPackages();
        final Object $expectedDepartureDate = this.getExpectedDepartureDate();
        result = result * PRIME + ($expectedDepartureDate == null ? 43 : $expectedDepartureDate.hashCode());
        final Object $expectedArrivalDate = this.getExpectedArrivalDate();
        result = result * PRIME + ($expectedArrivalDate == null ? 43 : $expectedArrivalDate.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $carrierName = this.getCarrierName();
        result = result * PRIME + ($carrierName == null ? 43 : $carrierName.hashCode());
        final Object $vesselName = this.getVesselName();
        result = result * PRIME + ($vesselName == null ? 43 : $vesselName.hashCode());
        final Object $trackingNumber = this.getTrackingNumber();
        result = result * PRIME + ($trackingNumber == null ? 43 : $trackingNumber.hashCode());
        final Object $modeOfTransport = this.getModeOfTransport();
        result = result * PRIME + ($modeOfTransport == null ? 43 : $modeOfTransport.hashCode());
        final Object $eta = this.getEta();
        result = result * PRIME + ($eta == null ? 43 : $eta.hashCode());
        final Object $etd = this.getEtd();
        result = result * PRIME + ($etd == null ? 43 : $etd.hashCode());
        final Object $hsCode = this.getHsCode();
        result = result * PRIME + ($hsCode == null ? 43 : $hsCode.hashCode());
        final Object $customsDeclarationNumber = this.getCustomsDeclarationNumber();
        result = result * PRIME + ($customsDeclarationNumber == null ? 43 : $customsDeclarationNumber.hashCode());
        result = result * PRIME + (this.isDutiesPaid() ? 79 : 97);
        final Object $inspectionStatus = this.getInspectionStatus();
        result = result * PRIME + ($inspectionStatus == null ? 43 : $inspectionStatus.hashCode());
        final Object $notes = this.getNotes();
        result = result * PRIME + ($notes == null ? 43 : $notes.hashCode());
        result = result * PRIME + (this.isDeleted() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Shipment(id=" + this.getId() + ", containerNumber=" + this.getContainerNumber() + ", blNumber=" + this.getBlNumber() + ", originPort=" + this.getOriginPort() + ", destinationPort=" + this.getDestinationPort() + ", shipperName=" + this.getShipperName() + ", consigneeName=" + this.getConsigneeName() + ", cargoType=" + this.getCargoType() + ", weight=" + this.getWeight() + ", volume=" + this.getVolume() + ", numberOfPackages=" + this.getNumberOfPackages() + ", expectedDepartureDate=" + this.getExpectedDepartureDate() + ", expectedArrivalDate=" + this.getExpectedArrivalDate() + ", status=" + this.getStatus() + ", carrierName=" + this.getCarrierName() + ", vesselName=" + this.getVesselName() + ", trackingNumber=" + this.getTrackingNumber() + ", modeOfTransport=" + this.getModeOfTransport() + ", eta=" + this.getEta() + ", etd=" + this.getEtd() + ", hsCode=" + this.getHsCode() + ", customsDeclarationNumber=" + this.getCustomsDeclarationNumber() + ", dutiesPaid=" + this.isDutiesPaid() + ", inspectionStatus=" + this.getInspectionStatus() + ", notes=" + this.getNotes() + ", deleted=" + this.isDeleted() + ")";
    }

    public static class ShipmentBuilder {
        private Long id;
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
        private boolean deleted;

        ShipmentBuilder() {
        }

        public ShipmentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ShipmentBuilder containerNumber(String containerNumber) {
            this.containerNumber = containerNumber;
            return this;
        }

        public ShipmentBuilder blNumber(String blNumber) {
            this.blNumber = blNumber;
            return this;
        }

        public ShipmentBuilder originPort(String originPort) {
            this.originPort = originPort;
            return this;
        }

        public ShipmentBuilder destinationPort(String destinationPort) {
            this.destinationPort = destinationPort;
            return this;
        }

        public ShipmentBuilder shipperName(String shipperName) {
            this.shipperName = shipperName;
            return this;
        }

        public ShipmentBuilder consigneeName(String consigneeName) {
            this.consigneeName = consigneeName;
            return this;
        }

        public ShipmentBuilder cargoType(String cargoType) {
            this.cargoType = cargoType;
            return this;
        }

        public ShipmentBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public ShipmentBuilder volume(double volume) {
            this.volume = volume;
            return this;
        }

        public ShipmentBuilder numberOfPackages(int numberOfPackages) {
            this.numberOfPackages = numberOfPackages;
            return this;
        }

        public ShipmentBuilder expectedDepartureDate(LocalDate expectedDepartureDate) {
            this.expectedDepartureDate = expectedDepartureDate;
            return this;
        }

        public ShipmentBuilder expectedArrivalDate(LocalDate expectedArrivalDate) {
            this.expectedArrivalDate = expectedArrivalDate;
            return this;
        }

        public ShipmentBuilder status(String status) {
            this.status = status;
            return this;
        }

        public ShipmentBuilder carrierName(String carrierName) {
            this.carrierName = carrierName;
            return this;
        }

        public ShipmentBuilder vesselName(String vesselName) {
            this.vesselName = vesselName;
            return this;
        }

        public ShipmentBuilder trackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public ShipmentBuilder modeOfTransport(String modeOfTransport) {
            this.modeOfTransport = modeOfTransport;
            return this;
        }

        public ShipmentBuilder eta(LocalDate eta) {
            this.eta = eta;
            return this;
        }

        public ShipmentBuilder etd(LocalDate etd) {
            this.etd = etd;
            return this;
        }

        public ShipmentBuilder hsCode(String hsCode) {
            this.hsCode = hsCode;
            return this;
        }

        public ShipmentBuilder customsDeclarationNumber(String customsDeclarationNumber) {
            this.customsDeclarationNumber = customsDeclarationNumber;
            return this;
        }

        public ShipmentBuilder dutiesPaid(boolean dutiesPaid) {
            this.dutiesPaid = dutiesPaid;
            return this;
        }

        public ShipmentBuilder inspectionStatus(String inspectionStatus) {
            this.inspectionStatus = inspectionStatus;
            return this;
        }

        public ShipmentBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public ShipmentBuilder deleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Shipment build() {
            return new Shipment(this.id, this.containerNumber, this.blNumber, this.originPort, this.destinationPort, this.shipperName, this.consigneeName, this.cargoType, this.weight, this.volume, this.numberOfPackages, this.expectedDepartureDate, this.expectedArrivalDate, this.status, this.carrierName, this.vesselName, this.trackingNumber, this.modeOfTransport, this.eta, this.etd, this.hsCode, this.customsDeclarationNumber, this.dutiesPaid, this.inspectionStatus, this.notes, this.deleted);
        }

        public String toString() {
            return "Shipment.ShipmentBuilder(id=" + this.id + ", containerNumber=" + this.containerNumber + ", blNumber=" + this.blNumber + ", originPort=" + this.originPort + ", destinationPort=" + this.destinationPort + ", shipperName=" + this.shipperName + ", consigneeName=" + this.consigneeName + ", cargoType=" + this.cargoType + ", weight=" + this.weight + ", volume=" + this.volume + ", numberOfPackages=" + this.numberOfPackages + ", expectedDepartureDate=" + this.expectedDepartureDate + ", expectedArrivalDate=" + this.expectedArrivalDate + ", status=" + this.status + ", carrierName=" + this.carrierName + ", vesselName=" + this.vesselName + ", trackingNumber=" + this.trackingNumber + ", modeOfTransport=" + this.modeOfTransport + ", eta=" + this.eta + ", etd=" + this.etd + ", hsCode=" + this.hsCode + ", customsDeclarationNumber=" + this.customsDeclarationNumber + ", dutiesPaid=" + this.dutiesPaid + ", inspectionStatus=" + this.inspectionStatus + ", notes=" + this.notes + ", deleted=" + this.deleted + ")";
        }
    }
}
