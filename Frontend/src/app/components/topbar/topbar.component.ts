import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faRightFromBracket, faUser } from '@fortawesome/free-solid-svg-icons';
import { AuthService } from '../auth-service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-topbar',
  imports: [FontAwesomeModule, CommonModule],
  templateUrl: './topbar.component.html',
  styleUrl: './topbar.component.css',
})
export class TopbarComponent {
  faUser = faUser;
  faRightFromBracket = faRightFromBracket;

  constructor(public authService: AuthService, private router: Router) {}

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']); // ✅ Ensure navigation to login page
  }
}
