import BookList from "./components/BookList";
import { ApolloClient, InMemoryCache } from '@apollo/client';
import { ApolloProvider } from '@apollo/client';
import AddBook from "./components/AddBook";

const client = new ApolloClient({
  uri: 'http://localhost:5005/graphql',
  cache: new InMemoryCache()
});

function App() {
  return (
    <ApolloProvider client={client}>
    <div className="App">
      <BookList/>
      <AddBook/>
    </div>
    </ApolloProvider>
  );
}

export default App;
