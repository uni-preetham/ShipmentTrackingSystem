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

  async createShipment(shipment: any){
    try {
      const response = await axios.post(`${this.apiUrl}`, shipment, { headers: { 'Content-Type': 'application/json' } });
      return response.data;
  } catch (error: any) {
      if (error.response?.status === 409) {
          throw new Error(error.response.data || "A shipment with this Container Number or BL Number already exists.");
      }
      throw new Error("Failed to create shipment.");
  }
  }

  async updateShipmentStatus(id: number, status: string): Promise<any> {
    const response = await axios.put(`${this.apiUrl}/${id}/status?status=${status}`);
    return response.data;
  }

  async updateShipment(shipment: any): Promise<any> {
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    shipment.lastModifiedBy = user.firstName+" "+user.lastName; 

    const response = await axios.put(`${this.apiUrl}/${shipment.id}`, shipment,{headers : {'Content-Type' : 'application/json'}});
    return response.data;
  }

  // async deleteShipment(id: number): Promise<any> {
  //   const response = await axios.delete(`${this.apiUrl}/${id}`);
  //   return response.data;
  // }

  async deleteShipment(shipment:any){
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    shipment.lastModifiedBy = user.firstName+" "+user.lastName; 

    const response = await axios.request({
      method: 'DELETE',
      url: `${this.apiUrl}/${shipment.id}`,
      data: shipment, // Send the shipment as the request body
      headers: { 'Content-Type': 'application/json' }
  });

    return response.data;
  }
}
