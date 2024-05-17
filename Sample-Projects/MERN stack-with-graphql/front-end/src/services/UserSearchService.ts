import { apolloClient } from "../providers/CustomApolloProvider";
import { SEARCH_USERS } from "../queries/UserQueries";


export class UserSearchService {
  static getSearchData = async (name?: String, age?: Number) => {
   
    const { data } = await apolloClient.query({
      query: SEARCH_USERS,
      variables: { name, age },
    });
    return data;
  };
}
