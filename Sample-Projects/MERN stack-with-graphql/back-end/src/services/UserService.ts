import { apolloClient } from "../providers/CustomApolloProvider";
import { ADD_USER, DELETE_USER, FETCH_USERS, UPDATE_USER } from "../queries/UserQueries";
import { User } from "../types/User";
import httpClient from "../util/HttpClient";

export class UserService {
  static getUsers = async () => {
    const { data } = await apolloClient.query({
      query: FETCH_USERS,
    });
    return data;
  };
  

  static addUser = async (user: User) => {
    const ageToSend = Number(user.age!);
    
    const { data } = await apolloClient.mutate({
      mutation: ADD_USER,
      variables: {
        name: user.name,
        age: ageToSend,
        gender: user.gender
      }
    });
    return data;
  };

  static editUser = async (user: User, id: string) => {
    const ageToSend = Number(user.age!);
    
    const { data } = await apolloClient.mutate({
      mutation: UPDATE_USER,
      variables: {
        id,
        name: user.name,
        age: ageToSend,
        gender: user.gender
      }
    });
    return data;
  };

  static deleteUser = async (id: string) => {
    const { data } = await apolloClient.mutate({
      mutation: DELETE_USER,
      variables: {
        id,
      }
    });
    return data;
  };

  static download = () => {
    return httpClient.get<BlobPart>(`/users/download`,{responseType: "arraybuffer"});
  };
}
