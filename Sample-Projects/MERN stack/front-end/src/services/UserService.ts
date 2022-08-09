import { AddRes, DeleteRes, EditRes } from "../types/HttpResType";
import {User, UserRes} from "../types/User";
import httpClient from "../util/HttpClient";

const getUsers = ()  => {
      return httpClient.get<UserRes>('/users');
}

const addUser = (user: User)  => {
      return httpClient.post<AddRes>('/users/user', user);
}

const editUser = (user: User, id: string)  => {
      return httpClient.put<EditRes>(`/users/user/${id}`, user);
}

const deleteUser = (id: string)  => {
      return httpClient.delete<DeleteRes>(`/users/user/${id}`);
}

export {getUsers, addUser, editUser, deleteUser};