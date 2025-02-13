import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth'; // Adjust if needed

  constructor() {}

  // async register(username: string, password: string, role: string, firstName:string, lastName: string): Promise<any> {
  async register(username: string, password: string, role: string, firstName:string, lastName: string): Promise<any> {
    try {
      const response = await axios.post(`${this.apiUrl}/register`, { username, password, role: "USER", firstName, lastName });
      return response.data;
    } catch (error: any) {
      console.error('Registration Error:', error.response?.data || error.message);
      throw new Error(error.response?.data || 'Registration failed');
    }
  }

  async login(username: string, password: string): Promise<any> {
    try {
      console.log("Sending Login Request:", { username, password });
      const response = await axios.post(`${this.apiUrl}/login`, { username, password });
      const user = response.data;
      this.setUser(user);
      return user;
    } catch (error: any) {
      console.error('Login Error:', error.response?.data || error.message);
      throw new Error(error.response?.data || 'Login failed');
    }
  }

  logout(): void {
    localStorage.removeItem('user');  // ✅ Ensure item is removed
    setTimeout(() => {
      window.location.href = '/login';  // ✅ Force reload after clearing storage
    }, 100); // Delay allows time for localStorage to update
  }
  

  setUser(user: any): void {
    localStorage.setItem('user', JSON.stringify(user));
  }

  getUser(): any {
    return JSON.parse(localStorage.getItem('user') || 'null');
  }

  isLoggedIn(): boolean {
    try {
      return !!localStorage.getItem('user');
    } catch (e) {
      return false;
    }
  }
  
}
