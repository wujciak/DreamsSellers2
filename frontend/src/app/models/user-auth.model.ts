export interface UserAuth {
  username: string;
  password: string;
}

export interface UserRegister extends UserAuth {
  email: string;
}

export interface LoginResponse {
  token: string;
  userId: number;
  role: string;
}
