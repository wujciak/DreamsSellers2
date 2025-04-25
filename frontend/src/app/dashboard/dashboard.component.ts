import { Component, OnInit } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import { ItemService } from '../services/item.service';
import { ItemDTO } from '../models/item.model';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  items: ItemDTO[] = [];

  constructor(private itemService: ItemService, private router: Router) {}

  ngOnInit(): void {
    this.itemService.getAllItems().subscribe({
      next: (data) => this.items = data,
      error: (err) => console.error('Failed to fetch items', err)
    });
  }


  deleteItem(itemId: number): void {
    this.itemService.deleteItem(itemId).subscribe({
      next: () => {
        this.items = this.items.filter(item => item.itemId !== itemId);
      },
      error: (err) => console.error('Error deleting item', err)
    });
  }

  logout(): void {
    localStorage.removeItem('authId');
    localStorage.removeItem('username');
    this.router.navigate(['/auth/login']);
  }
}
