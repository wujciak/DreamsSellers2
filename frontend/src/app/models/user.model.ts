export interface UserDTO {
    userId: number;
    username: string;
    name: string;
    email: string;
    role: string;
}

export interface UserCreateDTO {
    username: string;
    name: string;
    email: string;
    role: string;
}
