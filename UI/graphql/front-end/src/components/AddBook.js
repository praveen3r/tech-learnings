import { useQuery } from '@apollo/client';
import { gql } from 'apollo-boost';
import React from 'react'

const FETCH_AUTHORS = gql`
  query {
    authors {
      id
      name
    }
  }
`;

const AddBook = () => {

    const { data } = useQuery(FETCH_AUTHORS);

     return (
    <form id="add-book">
    <div className="field">
        <label>Book name:</label>
        <input type="text" />
    </div>
    <div className="field">
        <label>Genre:</label>
        <input type="text" />
    </div>
    <div className="field">
        <label>Author:</label>
        <select>
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