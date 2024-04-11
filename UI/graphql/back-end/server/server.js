const express = require('express');
var { createHandler } = require("graphql-http/lib/use/express");
//const {schema,resolvers} = require('./schema/schema')
//const {schema,resolvers} = require('./schema/schema-type-relations')
const {schema,resolvers} = require('./schema/schema-type-relations-two-way')
const { graphqlHTTP } = require('express-graphql');


const port = 5005;

const app = express();

// Construct a schema, using GraphQL schema language
/* var schema = buildSchema(`
  type Query {
    hello: String
  }
`)*/

// The root provides a resolver function for each API endpoint
var root = {
  id: () => {
    return "Hello world!"
  },
}

// Create and use the GraphQL handler.
/*app.all(
  "/graphql",
  createHandler({
    schema: schema,
    rootValue: root,
  })
)*/

/*app.all(
  "/graphql",
  createHandler({
    schema: schemas.schema,
    rootValue: root,
  }),
  
)*/

app.use(
  "/graphql",
  graphqlHTTP({
    schema: schema,
    rootValue: resolvers,
    graphiql: true, 

  }),
  
)

app.listen(port, () => {
    console.log(`server started in port ${port}`)
});