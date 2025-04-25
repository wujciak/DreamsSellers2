import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ItemCreateDTO } from '../../models/item.model';
import { ItemService } from '../../services/item.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-item',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent {
  item: ItemCreateDTO = {
    name: '',
    description: '',
    price: 0,
    stock: 0,
    imageUrl: '',
    vendorId: 0
  };

  success: string | null = null;
  error: string | null = null;

  constructor(private itemService: ItemService, private router: Router) {}

  onSubmit(): void {
    const authId = localStorage.getItem('authId');
    if (!authId) {
      this.error = 'You must be logged in to add an item.';
      return;
    }

    this.item.vendorId = +authId;

    this.itemService.createItem(this.item).subscribe({
      next: (data) => {
        this.success = `Item "${data.name}" added successfully!`;
        this.error = null;
        this.item = { name: '', description: '', price: 0, stock: 0, imageUrl: '', vendorId: +authId };
      },
      error: (err) => {
        console.error('Item creation error:', err);
        this.success = null;
        this.error = 'Failed to add item.';
      }
    });
  }
}
