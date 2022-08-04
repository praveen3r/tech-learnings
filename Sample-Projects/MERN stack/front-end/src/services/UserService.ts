import {User, UserRes} from "../types/User";
import httpClient from "../util/HttpClient";

const getUsers = ()  => {
      return httpClient.get<UserRes>('/users');
}

const addUser = (user: User)  => {
      return httpClient.post('/users/user', user);
}

const editUser = (user: User, id: string)  => {
      return httpClient.put(`/users/user/${id}`, user);
}

const deleteUser = (id: string)  => {
      return httpClient.delete(`/users/user/${id}`);
}

export {getUsers, addUser, editUser, deleteUser};