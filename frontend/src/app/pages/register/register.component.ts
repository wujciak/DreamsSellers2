import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule,
  ],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  newUser = {
    username: '',
    password: '',
    email: '',
  };

  success: string | null = null;
  error: string | null = null;

  constructor(private authService: AuthService) {}

  onSubmit(): void {
    this.authService.register(this.newUser).subscribe({
      next: (response) => {
        console.log('Successful registration:', response);
        this.success = 'Successful registration!';
        this.error = null;
        this.newUser = { username: '', password: '', email: '' };
      },
      error: (error) => {
        console.error('Registration error:', error);
        this.success = null;
        this.error = 'Did not register. Try again.';
      }
    });
  }
}
