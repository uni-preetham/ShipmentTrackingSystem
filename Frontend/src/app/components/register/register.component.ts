import { Component } from '@angular/core';
import { AuthService } from '../auth-service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [ToastModule, FloatLabelModule, DropdownModule, FormsModule],
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  providers: [MessageService]
})
export class RegisterComponent {
  username = '';
  password = '';
  role = 'USER';

  constructor(
    private authService: AuthService,
    private router: Router,
    private messageService: MessageService
  ) {}

  register() {
    if (!this.username || !this.password) {
      this.messageService.add({ severity: 'error', summary: 'Error', detail: 'All fields are required' });
      return;
    }

    this.authService.register(this.username, this.password, this.role).subscribe({
      next: () => {
        this.messageService.add({ severity: 'success', summary: 'Registration Successful', detail: 'You can now log in' });
        this.router.navigate(['/login']);
      },
      error: (err) => {
        this.messageService.add({ severity: 'error', summary: 'Registration Failed', detail: err.error });
      }
    });
  }
}
