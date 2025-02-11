import { Component } from '@angular/core';
import { ShipmentService } from '../shipment-service';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { SelectModule } from 'primeng/select';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { CalendarModule } from 'primeng/calendar';
import { CheckboxModule } from 'primeng/checkbox';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { FloatLabelModule } from 'primeng/floatlabel';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { CardModule } from 'primeng/card';
import { CommonModule } from '@angular/common';
import { MessageModule } from 'primeng/message';

@Component({
  imports: [CommonModule,
    FormsModule,
    DialogModule,
    SelectModule,
    ButtonModule,
    FloatLabelModule,
    TableModule,
    CalendarModule,
    CheckboxModule,
    InputTextModule,
    DropdownModule,
    ToastModule,
    CardModule,
    MessageModule,
  ],
  selector: 'app-shipment-form',
  templateUrl: './shipment-form.component.html',
  styleUrls: ['./shipment-form.component.scss'],
  providers: [MessageService],
})
export class ShipmentFormComponent {
  shipmentDialog: boolean = false;

  statuses = ['Pending', 'In Transit', 'Arrived', 'Cleared'];
  cargoTypes = ['General Cargo', 'Liquid', 'Dangerous Goods'];
  modesOfTransport = ['Sea', 'Air', 'Land', 'Rail'];
  inspectionStatuses = ['Pending', 'Cleared', 'Held for Inspection'];
  submitted = false;

  shipment = {
    containerNumber: '',
    blNumber: '',
    originPort: '',
    destinationPort: '',
    shipperName: '',
    consigneeName: '',
    cargoType: '',
    weight: 0,
    volume: 0,
    numberOfPackages: 0,
    expectedDepartureDate: '',
    expectedArrivalDate: '',
    // status: 'Pending',
    carrierName: '',
    vesselName: '',
    trackingNumber: '',
    modeOfTransport: '',
    dutiesPaid: false,
    notes: '',
    hsCode: '',
    customsDeclarationNumber: '',
    inspectionStatus: '',
  };

  constructor(
    private shipmentService: ShipmentService,
    private messageService: MessageService
  ) {}

  async addShipment() {
    this.submitted = true;
    if (!this.shipment.containerNumber || !this.shipment.carrierName || !this.shipment.modeOfTransport || !this.shipment.hsCode) {
      this.messageService.add({ severity: 'error', summary: 'Validation Error', detail: 'Please fill in all required fields' });
      return;
    }
    try {
      await this.shipmentService.createShipment(this.shipment);
      this.messageService.add({
        severity: 'success',
        summary: 'Success',
        detail: 'Shipment Added Successfully!',
      });
      this.shipmentDialog = false;
    } catch (error: any) {
      this.messageService.add({
        severity: 'error',
        summary: 'Error',
        detail: error.message,
      });
    }
  }

  openDialog() {
    this.shipmentDialog = true;
  }

  isFormValid(): boolean {
    return !!(
      this.shipment.containerNumber &&
      // this.shipment.originPort &&
      // this.shipment.destinationPort &&
      // this.shipment.shipperName &&
      // this.shipment.consigneeName &&
      // this.shipment.cargoType &&
      // this.shipment.weight !== null &&
      // this.shipment.expectedDepartureDate &&
      // this.shipment.expectedArrivalDate &&
      this.shipment.carrierName &&
      this.shipment.modeOfTransport &&
      // this.shipment.inspectionStatus &&
      this.shipment.hsCode
    );
  }
}
