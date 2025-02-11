import { Routes } from "@angular/router";
import { ShipmentListComponent } from "./components/shipment-list/shipment-list.component";
import { ShipmentFormComponent } from "./components/shipment-form/shipment-form.component";
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";
import { RegisterComponent } from "./components/register/register.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { AuthGuard } from "./auth.guard";

export const routes: Routes = [

    {
        path: 'dashboard',
        component: DashboardComponent, // ✅ Dashboard is the main wrapper
        canActivate: [AuthGuard],
        children: [
            { path: '', redirectTo: 'home', pathMatch: 'full' },
          { path: 'shipments', component: ShipmentListComponent }, // ✅ Loads inside Dashboard
          { path: 'add-shipment', component: ShipmentFormComponent }, // ✅ Example for other components
          { path: 'home', component: HomeComponent }
        ]
      },
    // { path: 'shipments', component: ShipmentListComponent },
    // { path: 'add-shipment', component: ShipmentFormComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: '', redirectTo: '/login', pathMatch: 'full' }
];

