import React from 'react'
import { FETCH_BOOK } from '../queries/BookQuery';
import { useQuery } from '@apollo/client';

const BookDetails = ({bookId}) => {
   // const { loading, error, data } = useQuery(FETCH_BOOK, {
    const { data } = useQuery(FETCH_BOOK, {
        variables: { id: bookId },
      });

  return (
    <>
    <div>BookDetails for the book is</div>
    {
        data && 
        <div>
        <h2>BookName - {data.book.name}</h2>
        <p>BookGenre - {data.book.genre}</p>
        <p>AuthorName - {data.book.author.name}</p>
        </div>
    } 
    </>
  )
}

export default BookDetails