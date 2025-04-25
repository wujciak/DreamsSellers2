import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ItemDTO, ItemCreateDTO } from '../models/item.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private apiUrl = `${environment.apiUrl}/items`;

  constructor(private http: HttpClient) {}

  // Get all items
  getAllItems(): Observable<ItemDTO[]> {
    return this.http.get<ItemDTO[]>(this.apiUrl);
  }

  // Create new item
  createItem(item: ItemCreateDTO): Observable<ItemDTO> {
    return this.http.post<ItemDTO>(this.apiUrl, item);
  }

  // Get item by ID
  getItemById(itemId: number): Observable<ItemDTO> {
    return this.http.get<ItemDTO>(`${this.apiUrl}/${itemId}`);
  }

  // Delete item by ID
  deleteItem(itemId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${itemId}`);
  }
}
