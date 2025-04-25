import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { ItemDTO } from '../../models/item.model';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule, NgOptimizedImage],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  items: ItemDTO[] = [];

  constructor(private itemService: ItemService) {}

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
}
