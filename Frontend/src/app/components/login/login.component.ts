import { Component } from '@angular/core';
import { AuthService } from '../auth-service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { FloatLabelModule } from 'primeng/floatlabel';
import { FormsModule } from '@angular/forms';
import { MessageModule } from 'primeng/message';
import { CommonModule } from '@angular/common';
import { InputTextModule } from 'primeng/inputtext';




@Component({
  imports: [ToastModule, FloatLabelModule, FormsModule, MessageModule, CommonModule, InputTextModule],
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [MessageService]
})
export class LoginComponent {
  username = '';
  password = '';
  submitted = false;

  constructor(
    private authService: AuthService,
    private router: Router,
    private messageService: MessageService
  ) {}

  async login() {
    this.submitted = true;

    if (!this.username || !this.password) {
      // this.messageService.add({ severity: 'error', summary: 'Error', detail: 'All fields are required' });
      return;
    }

    try {
      const user = await this.authService.login(this.username, this.password);
      this.authService.setUser(user);
      // this.router.navigate(['/shipments']);
      this.messageService.add({ severity: 'success', summary: 'Login Successful', detail: `Welcome, ${user.firstName} ${user.lastName}` });
      setTimeout(() => {
        this.router.navigate(['/dashboard']);
      }, 1000); // ✅ Delay navigation so toast is visible
      return;
    } catch (error: any) {
      this.messageService.add({ severity: 'error', summary: 'Login Failed', detail: error.message });
    }
  }
}
