const { buildSchema } = require("graphql");

const books = [
  { id: '1', name: 'Book 1', genre: 'Crime' },
  { id: '2', name: 'Book 2', genre: 'Romance' },
];

const authors = [
  { id: '1', name: 'Author 1', age: 50 },
  { id: '2', name: 'Author 2', age: 60 },
];
const schema = buildSchema(`
  type BookType {
    id: ID
    name: String
    genre: String
  }
  
  type RootQuery {
    books: [BookType!]!             # Query to get a list of all books
    book(id: ID!): BookType          # Query to get a book by its ID
    authors: [AuthorType!]!             # Query to get a list of all authors
    author(id: ID!): AuthorType          # Query to get a author by its ID  

  }

  type AuthorType {
    id: ID
    age: Int
    name: String
  }

  schema {
    query: RootQuery
  }
 
  `);

  
  
  const resolvers = {
    books: () => books,
    book: ({ id }) => books.find(book => book.id === id),
    author: () => author,
    author: ({ id }) => authors.find(author => author.id === id),
  };

module.exports = {resolvers, schema};
