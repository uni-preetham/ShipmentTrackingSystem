import { Component } from '@angular/core';
import { AuthService } from '../auth-service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { FloatLabelModule } from 'primeng/floatlabel';
import { FormsModule } from '@angular/forms';
@Component({
  imports: [ToastModule, FloatLabelModule, FormsModule],
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [MessageService]
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private messageService: MessageService
  ) {}

  login() {
    if (!this.username || !this.password) {
      this.messageService.add({ severity: 'error', summary: 'Error', detail: 'All fields are required' });
      return;
    }

    this.authService.login(this.username, this.password).subscribe({
      next: (user) => {
        this.authService.setUser(user);
        this.messageService.add({ severity: 'success', summary: 'Login Successful', detail: `Welcome, ${user.username}` });
        this.router.navigate(['/shipments']);
      },
      error: (err) => {
        this.messageService.add({ severity: 'error', summary: 'Login Failed', detail: err.error });
      }
    });
  }
}
