import { Component } from '@angular/core';
import {Router, RouterLink, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-main-layout',
  templateUrl: './main-layout.component.html',
  imports: [
    RouterLink,
    RouterOutlet
  ],
  styleUrls: ['./main-layout.component.css']
})
export class MainLayoutComponent {
  constructor(private router: Router) {}

  logout(): void {
    localStorage.removeItem('authId');
    localStorage.removeItem('username');
    this.router.navigate(['/login']);
  }
}
