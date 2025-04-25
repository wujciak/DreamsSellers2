import { Component } from '@angular/core';
import { VendorService } from '../../services/vendor.service';
import { VendorCreateDTO } from '../../models/vendor.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-vendor',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create-vendor.component.html',
  styleUrls: ['./create-vendor.component.css']
})
export class CreateVendorComponent {
  vendor: VendorCreateDTO = {
    name: '',
    description: ''
  };

  success: string | null = null;
  error: string | null = null;
  submitted: boolean = false;

  constructor(private vendorService: VendorService) {}

  onSubmit(): void {
    this.vendorService.createVendor(this.vendor).subscribe({
      next: (data) => {
        this.success = `Vendor "${data.name}" created successfully!`;
        this.error = null;
        this.vendor = { name: '', description: '' };
        this.submitted = true;
      },
      error: (err) => {
        console.error('Vendor creation error:', err);
        this.success = null;
        this.error = 'Failed to create vendor.';
        this.submitted = false;
      }
    });
  }
}
