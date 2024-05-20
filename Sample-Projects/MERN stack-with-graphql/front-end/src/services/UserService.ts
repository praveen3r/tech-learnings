import { apolloClient } from "../providers/CustomApolloProvider";
import { ADD_USER, DELETE_USER, FETCH_USERS, UPDATE_USER } from "../queries/UserQueries";
import { User } from "../types/User";
import httpClient from "../util/HttpClient";

export class UserService {
  static getUsers = async () => {
    try {
      const { data, errors } = await apolloClient.query({
        query: FETCH_USERS,
      });
      if(errors){
        throw errors;
      }
      return data;
    }catch (networkError) {
      throw networkError;
    }
  };
  

  static addUser = async (user: User) => {
    const ageToSend = Number(user.age!);
    
    const { data } = await apolloClient.mutate({
      mutation: ADD_USER,
      variables: {
        name: user.name,
        age: ageToSend,
        gender: user.gender
      },
      update: (cache) => {
        const data: any = cache.readQuery({ query: FETCH_USERS });
        
        const updatedArray = {...data, user}
        cache.writeQuery({ query: FETCH_USERS , data:{users: updatedArray } } );
      }
    });
    return data;
  };

  static editUser = async (user: User, id: string) => {
    const ageToSend = Number(user.age!);
    
    await apolloClient.mutate({
      mutation: UPDATE_USER,
      variables: {
        id,
        name: user.name,
        age: ageToSend,
        gender: user.gender
      },
      update: (cache) => {
        const data: any = cache.readQuery({ query: FETCH_USERS });
        
        const updatedArray = data!.users.map((item: { id: string; }) => {
          if (item.id === id) {
            return user;
          }
          return item;
        });
        cache.writeQuery({ query: FETCH_USERS , data:{users: updatedArray } } );
      }
    });
  }

  static deleteUser = async (id: string) => {
    const { data } = await apolloClient.mutate({
      mutation: DELETE_USER,
      variables: {
        id,
      },
      update: (cache) => {
        const data: any = cache.readQuery({ query: FETCH_USERS });
        
        let newArray = data!.users.filter((item: { id: string; }) => item.id !== id);
        cache.writeQuery({ query: FETCH_USERS , data:{users: newArray } } );
      }
    });
    return data;
  };

  static download = () => {
    return httpClient.get<BlobPart>(`/users/download`,{responseType: "arraybuffer"});
  };
}
