import React from 'react'
import { useQuery } from '@apollo/client';
import { gql } from 'apollo-boost';

const FETCH_BOOKS = gql`
  query {
    books {
      id
      name
    }
  }
`;

const BookList = () => {

  const { error, data } = useQuery(FETCH_BOOKS);

  if (error) return <p>Error :(</p>;
  return (
    <div>
        <ul id="book-list">
        {data && data.books.map(book => (
          <li key={book.id}>
            <p>Book Name: {book.name}</p>
          </li>
        ))}
        </ul>
    </div>
  )
}

export default BookList