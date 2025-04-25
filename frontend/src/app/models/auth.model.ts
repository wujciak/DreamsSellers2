export interface RegisterDTO {
  username: string;
  password: string;
  name: string;
  role: string;
}

export interface LoginDTO {
  username: string;
  password: string;
}

export interface LoginResponseDTO {
  authId: number;
  username: string;
}

export interface AuthResponseDTO {
  userId: number;
  username: string;
  name: string;
  role: string;
}
