import { ApolloClient, ApolloProvider, InMemoryCache } from '@apollo/client';
import React from 'react'
import { ChildrenType } from '../types/ComponentType';

export const apolloClient = new ApolloClient({
    uri: 'http://localhost:5000/api/graphql',
    cache: new InMemoryCache()
  });

const CustomApolloProvider = ({ children }: ChildrenType) => {
  return (
    <ApolloProvider client={apolloClient}>{children}</ApolloProvider>
  )
}

export default CustomApolloProvider