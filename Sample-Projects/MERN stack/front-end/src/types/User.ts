import { DropdownOptions } from "./FormTypes";

export type User = {
    _id?: string;
    sNo: number;
    name: string;
    age: number | undefined;
    gender: string;
    genderOptions?: DropdownOptions[]
}

export type UserRes = {
    users: User[];
}

export type GenderRes = {
    genders: DropdownOptions[];
}
