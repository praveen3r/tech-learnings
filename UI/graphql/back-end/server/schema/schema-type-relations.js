const { buildSchema } = require("graphql");

const books = [
  { id: '1', name: 'Book 1', genre: 'Crime', authorId: '1' },
  { id: '2', name: 'Book 2', genre: 'Romance' , authorId: '2'  },
];

const authors = [
  { id: '1', name: 'Author 1', age: 50 },
  { id: '2', name: 'Author 2', age: 60 },
];
const schema = buildSchema(`

type AuthorType {
  id: ID
  age: Int
  name: String
}

  type BookType {
    id: ID
    name: String
    genre: String
    author: AuthorType   # The author of this book
  }
  
  type RootQuery {
    books: [BookType!]!             # Query to get a list of all books
    book(id: ID!): BookType          # Query to get a book by its ID
    authors: [AuthorType!]!             # Query to get a list of all authors
    author(id: ID!): AuthorType          # Query to get a author by its ID  

  }

  

  schema {
    query: RootQuery
  }
 
  `);

  
  
  const resolvers = {
    books: () => books,
    book: ({ id }) => {
      const book = books.find(book => book.id === id);
      if (!book) {
        return null;
      }
      return {
        ...book,
        author: authors.find(author => author.id === book.authorId)
      };
    },
    author: () => authors,
    author: ({ id }) => authors.find(author => author.id === id) || null,
    
    
  };

module.exports = {resolvers, schema};
