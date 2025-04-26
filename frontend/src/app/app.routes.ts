import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MainLayoutComponent } from './components/main-layout/main-layout.component';
import { CreateVendorComponent } from './components/create-vendor/create-vendor.component';
import { AddItemComponent } from './components/add-item/add-item.component';
import { AuthGuard } from './guards/auth.guard';
import {StatisticComponent} from './components/statistic/statistic.component';

export const routes: Routes = [
  { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/register', component: RegisterComponent },
  {
    path: '',
    component: MainLayoutComponent,
    canActivateChild: [AuthGuard],
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'vendor/create', component: CreateVendorComponent },
      // { path: 'profile', component: DashboardComponent },
      // { path: 'orders', component: DashboardComponent },
      { path: 'item/add', component: AddItemComponent },
      { path: 'statistics', component: StatisticComponent },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
    ]
  },
  { path: '**', redirectTo: 'auth/login' }
];
