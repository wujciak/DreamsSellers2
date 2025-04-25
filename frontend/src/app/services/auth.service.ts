import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {LoginResponse, UserAuth, UserRegister} from '../models/user-auth.model';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = `${environment.apiUrl}/auth`;

  constructor(private http: HttpClient) {}

  // Login
  login(credentials: UserAuth): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, credentials);
  }

  // Register
  register(user: UserRegister): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, user);
  }

}
