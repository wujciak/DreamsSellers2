import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {RouterLink} from '@angular/router';
import {RegisterDTO} from '../../models/auth.model';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule,
    RouterLink,
  ],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  newUser: RegisterDTO = {
    username: '',
    password: '',
    name: '',
    role: ''
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
        this.newUser = { username: '', password: '', name: '', role: '' };
      },
      error: (error) => {
        console.error('Registration error:', error);
        this.success = null;
        this.error = 'Did not register. Try again.';
      }
    });
  }
}
