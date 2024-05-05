import { gql } from "@apollo/client";

export const FETCH_USERS = gql`
  query {
    users {
      sNo
      id
      name
      age
      gender
    }
  }
`;

export const ADD_USER = gql`
mutation AddUser($name: String!, $age: Int!, $gender: String!) {
  addUser(user: { name: $name, age: $age, gender: $gender }) {
    id
  }
}
`;

export const UPDATE_USER = gql`
mutation EditUser($id: ID!, $name: String!, $age: Int!, $gender: String!) {
  editUser(id:$id, user: { name: $name, age: $age, gender: $gender }) 
}
`;

export const DELETE_USER = gql`
mutation DeleteUser($id: ID!) {
  deleteUser(id:$id) 
}
`;