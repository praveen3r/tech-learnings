import { apolloClient } from "../providers/CustomApolloProvider";
import { SEARCH_USERS } from "../queries/UserQueries";
import { UserRes } from "../types/User";
import httpClient from "../util/HttpClient";

export class UserSearchService {
  static getSearchData = async (name?: String) => {
   
    const { data } = await apolloClient.query({
      query: SEARCH_USERS,
      variables: { name },
    });
    return data;
  };
}
