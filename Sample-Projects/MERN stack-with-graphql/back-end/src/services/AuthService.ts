import { LoginType } from "../types/FormTypes";
import httpClient from "../util/HttpClient";

export class AuthService {
  static authenticate = (values: LoginType) => {
    return httpClient.post("/authenticate", values);
  };
}
