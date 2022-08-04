export type User = {
    _id?: string;
    sNo: number;
    name: string;
    age: number | undefined;
    gender: string;
}

export type UserRes = {
    users: User[];
}
