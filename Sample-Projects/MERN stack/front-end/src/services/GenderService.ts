import { GenderRes } from "../types/User";
import httpClient from "../util/HttpClient";

export class GenderService {
  static getGenders = () => {
    return httpClient.get<GenderRes>("/genders");
  };
}
