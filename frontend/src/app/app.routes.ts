import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'auth/login', loadComponent: () => import('./pages/login/login.component').then(m => m.LoginComponent) },
  { path: 'auth/register', loadComponent: () => import('./pages/register/register.component').then(m => m.RegisterComponent) },
  { path: '', redirectTo: '/auth/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/auth/login' },
];
