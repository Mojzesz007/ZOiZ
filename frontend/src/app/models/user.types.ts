export interface User {
    id: number;
    version: number;
    createdAt: Date;
    updatedAt?: any;
    draft: boolean;
    name: string;
    surname: string;
    initials?: any;
    login: string;
    password: string;
    email: string;
    phone: string;
    enabled: boolean;
}