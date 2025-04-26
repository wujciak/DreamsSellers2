import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Statistic } from '../models/statistic.model';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StatisticService {
  private apiUrl = `${environment.apiUrl}/statistics`;

  constructor(private http: HttpClient) {}

  getFullStatistics(): Observable<Statistic> {
    return this.http.get<Statistic>(`${this.apiUrl}/all`);
  }
}
