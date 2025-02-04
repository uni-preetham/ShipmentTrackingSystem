import { Component } from '@angular/core';
import { ShipmentService } from '../shipment-service';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { RouterModule } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';

@Component({
  imports: [FormsModule, DialogModule, DropdownModule, ButtonModule, TableModule, RouterModule],
  selector: 'app-shipment-form',
  templateUrl: './shipment-form.component.html',
  styleUrls: ['./shipment-form.component.scss'],
})
export class ShipmentFormComponent {
  shipmentDialog: boolean = false; // Controls the visibility of the dialog

  shipment = {
    containerNumber: '',
    originPort: '',
    destinationPort: '',
    shipperName: '',
    consigneeName: '',
    cargoType: '',
    weight: 0,
    expectedDepartureDate: '',
    expectedArrivalDate: '',
    status: 'Pending'
  };

  constructor(private shipmentService: ShipmentService) {}

  async addShipment() {
    await this.shipmentService.createShipment(this.shipment);
    alert('Shipment Added Successfully');
    this.shipmentDialog = false; // Close dialog after adding shipment
  }

  openDialog() {
    this.shipmentDialog = true; // Open dialog when needed
  }
}
