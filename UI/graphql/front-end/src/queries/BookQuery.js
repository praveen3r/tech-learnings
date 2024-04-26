import { gql } from "@apollo/client";

export const ADD_BOOK = gql`
  mutation CreateBook($name: String!, $genre: String!, $authorId: String) {
    createBook(input: { name: $name, genre: $genre, authorId: $authorId }) {
      id
      
      
    }
  }
`;

export const FETCH_AUTHORS = gql`
  query {
    authors {
      id
      name
    }
  }
`;

export const FETCH_BOOKS = gql`
  query {
    books {
      id
      name
    }
  }
`;

export const FETCH_BOOK = gql`
    query GetBook($id: ID!){
        book(id: $id) {
            id
            name
            genre
            author {
                id
                name
                               
            }
        }
    }
`;

