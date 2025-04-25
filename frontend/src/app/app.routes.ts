import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MainLayoutComponent } from './components/main-layout/main-layout.component';
import { CreateVendorComponent } from './components/create-vendor/create-vendor.component';
import {AddItemComponent} from './components/add-item/add-item.component';

export const routes: Routes = [
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/register', component: RegisterComponent },
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'vendor/create', component: CreateVendorComponent },
      { path: 'profile', component: DashboardComponent }, //do zmiany
      { path: 'orders', component: DashboardComponent }, // do zmiany
      { path: 'item/add', component: AddItemComponent },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
    ]
  },
  { path: '**', redirectTo: 'dashboard' }
];
