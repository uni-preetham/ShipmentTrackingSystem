import { Component, OnInit } from '@angular/core';
import { ShipmentService } from '../shipment-service';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { RouterModule } from '@angular/router';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';

@Component({
  imports: [FormsModule, DialogModule,TableModule, DropdownModule, ButtonModule,RouterModule],
  selector: 'app-shipment-list',
  templateUrl: './shipment-list.component.html',
  styleUrls: ['./shipment-list.component.scss'],
})
export class ShipmentListComponent implements OnInit {
  shipments: any[] = [];
  statuses = ['Pending', 'In Transit', 'Arrived', 'Cleared'];

  constructor(private shipmentService: ShipmentService) {}

  ngOnInit(): void {
    this.loadShipments();
  }

  async loadShipments() {
    this.shipments = await this.shipmentService.getShipments();
  }

  async updateStatus(id: number, newStatus: string) {
    await this.shipmentService.updateShipmentStatus(id, newStatus);
    this.loadShipments();
  }

  async deleteShipment(id: number) {
    if (confirm('Are you sure you want to delete this shipment?')) {
      await this.shipmentService.deleteShipment(id);
      this.loadShipments();
    }
  }
}
