import { LoginType } from "../types/FormTypes";
import httpClient from "../util/HttpClient";

const authenticate = (values: LoginType)  => {
      return httpClient.post('/authenticate', values);
}

export {authenticate};