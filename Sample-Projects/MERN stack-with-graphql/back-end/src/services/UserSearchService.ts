import { UserRes } from "../types/User";
import httpClient from "../util/HttpClient";

export class UserSearchService {
  static getSearchData = (params: URLSearchParams) => {
    return httpClient.get<UserRes>("/users/search", {
      params,
    });
  };
}
