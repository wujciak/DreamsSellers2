import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {Router, RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  credentials = {
    username: '',
    password: '',
  };

  error: string | null = null;

  constructor(private authService: AuthService, private router: Router) {}

  async onSubmit(): Promise<void> {
    this.authService.login(this.credentials).subscribe({
      next: async (response) => {
        console.log('Logged in successfully:', response);
        localStorage.setItem('authId', String(response.authId));
        localStorage.setItem('username', response.username);
        await this.router.navigate(['/dashboard']);
      },
      error: (error) => {
        console.error('Login error:', error);
        this.error = 'Wrong login data!';
      }
    });
  }
}
