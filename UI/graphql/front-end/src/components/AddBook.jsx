import { useMutation, useQuery } from '@apollo/client';
import React, { useState } from 'react';
import { ADD_BOOK, FETCH_AUTHORS, FETCH_BOOKS } from '../queries/BookQuery';



const AddBook = () => {

  const [formData, setFormData] = useState({
    bookName: '',
    genre: '',
    author: ''
  });

  const [addBook] = useMutation(ADD_BOOK, {
    refetchQueries: [{ query: FETCH_BOOKS }],
    onCompleted: () => {
      // Logic to handle mutation completion
      alert('User added successfully!');
      setFormData({
        bookName: '',
        genre: '',
        author: ''
      })
    },
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
    
  };

  const handleSubmit = (event) => {
    event.preventDefault(); 
    console.log('Form submitted:', formData);
    addBook({ variables: { name: formData.bookName, genre: formData.genre, authorId: formData.author } });
  };


    const { data } = useQuery(FETCH_AUTHORS);

     return (
    <form id="add-book" onSubmit={handleSubmit}>
    <div className="field">
        <label>Book name:</label>
        <input type="text" name="bookName" value={formData.bookName}
          onChange={handleInputChange}/>
    </div>
    <div className="field">
        <label>Genre:</label>
        <input type="text" name="genre" value={formData.genre}
          onChange={handleInputChange}/>
    </div>
    <div className="field">
        <label>Author:</label>
        <select value={formData.author} name="author"
          onChange={handleInputChange}>
            <option>Select author</option>
            {data && data.authors.map(author => {
                return( <option key={ author.id } value={author.id}>{ author.name }</option> );
            })
        }
        </select>
    </div>
    <button>Add</button>

</form>
  )
}

export default AddBook