export interface ItemDTO {
  itemId: number;
  name: string;
  description: string;
  price: number;
  stock: number;
  imageUrl: string;
  vendorId: number;
}

export interface ItemCreateDTO {
  name: string;
  description: string;
  price: number;
  stock: number;
  imageUrl: string;
  vendorId: number;
}
