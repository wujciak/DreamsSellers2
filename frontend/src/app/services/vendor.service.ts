import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VendorDTO, VendorCreateDTO } from '../models/vendor.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VendorService {
  private apiUrl = `${environment.apiUrl}/vendors`;

  constructor(private http: HttpClient) {}

  createVendor(vendor: VendorCreateDTO): Observable<VendorDTO> {
    return this.http.post<VendorDTO>(this.apiUrl, vendor);
  }

  getVendors(): Observable<VendorDTO[]> {
    return this.http.get<VendorDTO[]>(this.apiUrl);
  }

  getVendorById(vendorId: number): Observable<VendorDTO> {
    return this.http.get<VendorDTO>(`${this.apiUrl}/${vendorId}`);
  }

  deleteVendor(vendorId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${vendorId}`);
  }
}
