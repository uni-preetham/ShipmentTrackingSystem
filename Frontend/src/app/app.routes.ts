import { Routes } from "@angular/router";
import { ShipmentListComponent } from "./components/shipment-list/shipment-list.component";
import { ShipmentFormComponent } from "./components/shipment-form/shipment-form.component";
import { HomeComponent } from "./components/home/home.component";

export const routes: Routes = [
    { path: 'shipments', component: ShipmentListComponent },
    { path: 'add-shipment', component: ShipmentFormComponent },
    { path: 'home', component: HomeComponent },
    { path: '', redirectTo: '/home', pathMatch: 'full' }
];

