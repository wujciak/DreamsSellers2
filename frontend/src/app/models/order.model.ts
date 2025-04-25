import {ItemDTO} from './item.model';

export interface OrderDTO {
  orderId: number;
  userId: number;
  items: ItemDTO[];
  totalPrice: number;
  status: string;
}

export interface OrderCreateDTO {
  userId: number;
  items: ItemDTO[];
}
