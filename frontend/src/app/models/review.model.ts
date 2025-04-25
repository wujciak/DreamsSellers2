export interface ReviewDTO {
  reviewId: number;
  itemId: number;
  userId: number;
  username: string;
  rating: number;
  comment: string;
}

export interface ReviewCreateDTO {
  itemId: number;
  userId: number;
  username: string;
  rating: number;
  comment: string;
}
