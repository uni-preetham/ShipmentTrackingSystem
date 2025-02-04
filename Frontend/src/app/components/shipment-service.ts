import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root',
})
export class ShipmentService {
  private apiUrl = 'http://localhost:8080/api/shipments';

  async getShipments(): Promise<any> {
    const response = await axios.get(this.apiUrl);
    return response.data;
  }

  async createShipment(shipment: any): Promise<any> {
    const response = await axios.post(this.apiUrl, shipment, {
      headers : {'Content-Type' : 'application/json'}
    });
    return response.data;
  }

  async updateShipmentStatus(id: number, status: string): Promise<any> {
    const response = await axios.put(`${this.apiUrl}/${id}/status?status=${status}`);
    return response.data;
  }

  async deleteShipment(id: number): Promise<any> {
    const response = await axios.delete(`${this.apiUrl}/${id}`);
    return response.data;
  }
}
