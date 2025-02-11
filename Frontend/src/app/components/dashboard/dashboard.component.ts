
import { Component } from '@angular/core';
import { TopbarComponent } from "../topbar/topbar.component";
import { NavbarComponent } from "../navbar/navbar.component";
import { RouterModule } from '@angular/router';



@Component({
  selector: 'app-dashboard',
  imports: [TopbarComponent, NavbarComponent, RouterModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

}
