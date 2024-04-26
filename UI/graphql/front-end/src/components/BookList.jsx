import React, { useState } from 'react'
import { useQuery } from '@apollo/client';
import { FETCH_BOOKS } from '../queries/BookQuery';
import BookDetails from './BookDetails';



const BookList = () => {

  const { error, data } = useQuery(FETCH_BOOKS);

  const [bookId, setBookId] = useState(null);

  if (error) return <p>Error :(</p>;
  return (
    <div>
        <ul id="book-list">
        {data && data.books.map(book => (
          <li key={book.id} onClick={() => setBookId(book.id)}>
            <p>Book Name: {book.name}</p>
          </li>
        ))}
        </ul>
        <div id="book-details">
        <BookDetails bookId={bookId}/>
        </div>
    </div>
  )
}

export default BookList