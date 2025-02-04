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


@Component({
  imports: [
    FormsModule, DialogModule, SelectModule, ButtonModule, FloatLabelModule,
    TableModule, CalendarModule, CheckboxModule, InputTextModule, DropdownModule, ToastModule
  ],
  selector: 'app-shipment-form',
  templateUrl: './shipment-form.component.html',
  styleUrls: ['./shipment-form.component.scss'],
  providers: [MessageService]
})
export class ShipmentFormComponent {
  shipmentDialog: boolean = false;

  statuses = ['Pending', 'In Transit', 'Arrived', 'Cleared'];
  cargoTypes = ['General Cargo', 'Liquid', 'Dangerous Goods'];
  modesOfTransport = ['Sea', 'Air', 'Land', 'Rail'];

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
    status: 'Pending',
    carrierName: '',
    vesselName: '',
    trackingNumber: '',
    modeOfTransport: '',
    dutiesPaid: false,
    notes: ''
  };

  constructor(private shipmentService: ShipmentService, private messageService: MessageService) {}

  async addShipment() {
    console.log(this.shipment);
    await this.shipmentService.createShipment(this.shipment);
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Shipment Added Successfully!' });
    this.shipmentDialog = false;
  }

  openDialog() {
    this.shipmentDialog = true;
  }
}
