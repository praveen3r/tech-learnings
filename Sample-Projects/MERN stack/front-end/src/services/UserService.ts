import { ResponseData } from "../types/ResponseData";
import { User, UserRes } from "../types/User";
import httpClient from "../util/HttpClient";

export class UserService {
  static getUsers = () => {
    return httpClient.get<UserRes>("/users");
  };

  static addUser = (user: User) => {
    return httpClient.post<ResponseData<string>>("/users/user", user);
  };

  static editUser = (user: User, id: string) => {
    return httpClient.put<ResponseData<string>>(`/users/user/${id}`, user);
  };

  static deleteUser = (id: string) => {
    return httpClient.delete(`/users/user/${id}`);
  };
}
