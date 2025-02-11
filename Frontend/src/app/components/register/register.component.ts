import { Component } from '@angular/core';
import { AuthService } from '../auth-service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MessageModule } from 'primeng/message';
import { InputTextModule } from 'primeng/inputtext';

@Component({
  imports: [ToastModule, FloatLabelModule, DropdownModule, FormsModule, CommonModule, MessageModule, InputTextModule],
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  providers: [MessageService]
})
export class RegisterComponent {
  username = '';
  password = '';
  firstName = '';
  lastName = '';
  role = 'USER';
  roles = ['USER', 'ADMIN'];
  submitted = false;
  confirmPassword='';
  constructor(
    private authService: AuthService,
    private router: Router,
    private messageService: MessageService
  ) {}

  async register() {
    this.submitted = true;
    if (!this.username || !this.password) {
      this.messageService.add({ severity: 'error', summary: 'Error', detail: 'All fields are required' });
      return;
    }

    if( this.confirmPassword!=this.password){
      this.messageService.add({ severity: 'error', summary: 'Error', detail: `Passwords don't match` });
      return;
    }

    try {
      await this.authService.register(this.username, this.password, this.role, this.firstName, this.lastName);
      this.messageService.add({ severity: 'success', summary: 'Registration Successful', detail: 'You can now log in' });
      this.router.navigate(['/login']);
    } catch (error: any) {
      this.messageService.add({ severity: 'error', summary: 'Registration Failed', detail: error.message });
    }
  }
}
