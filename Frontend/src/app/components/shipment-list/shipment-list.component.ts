import { Component, OnInit } from '@angular/core';
import { ShipmentService } from '../shipment-service';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { RouterModule } from '@angular/router';
import { SelectModule } from 'primeng/select';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {faTrashCan} from '@fortawesome/free-solid-svg-icons'



@Component({
  imports: [FormsModule, DialogModule, TableModule, SelectModule, ButtonModule, RouterModule, ToastModule, FontAwesomeModule],
  selector: 'app-shipment-list',
  templateUrl: './shipment-list.component.html',
  styleUrls: ['./shipment-list.component.scss'],
  providers: [MessageService],
})


export class ShipmentListComponent implements OnInit {
  faTrashCan = faTrashCan;
  deleteDialog: boolean = false; // Controls delete confirmation dialog
  selectedShipmentId: number | null = null; // Stores ID of shipment to delete
  shipments: any[] = [];
  statuses = ['Pending', 'In Transit', 'Arrived', 'Cleared'];

  constructor(private shipmentService: ShipmentService, private messageService: MessageService) {}

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

  openDeleteDialog(id: number) {
    this.selectedShipmentId = id; // Store the shipment ID
    this.deleteDialog = true; // Show the delete confirmation dialog
  }

  async confirmDelete() {
    if (this.selectedShipmentId !== null) {
      try {
        const response = await this.shipmentService.deleteShipment(this.selectedShipmentId);
        this.messageService.add({ severity: 'success', summary: 'Deleted', detail: response });
        this.loadShipments();
      } catch (error: any) {
        this.messageService.add({ severity: 'error', summary: 'Error', detail: error.response?.data || 'Failed to delete shipment.' });
      } finally {
        this.deleteDialog = false; // Close dialog after processing
        this.selectedShipmentId = null; // Reset selection
      }
    }
  }

  cancelDelete() {
    this.deleteDialog = false;
    this.selectedShipmentId = null;
  }
}
