export interface VendorDTO {
  vendorId: number;
  name: string;
  description: string;
  verified: boolean;
}

export interface VendorCreateDTO {
  name: string;
  description: string;
}
