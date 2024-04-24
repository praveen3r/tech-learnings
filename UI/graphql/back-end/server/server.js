const express = require('express');
var { createHandler } = require("graphql-http/lib/use/express");
//const {schema,resolvers} = require('./schema/schema')
//const {schema,resolvers} = require('./schema/schema-type-relations')
//const {schema,resolvers} = require('./schema/schema-type-relations-two-way')
const {schema,resolvers} = require('./schema/schema-mongoose')
const { graphqlHTTP } = require('express-graphql');
const connectDB = require('./mongodb/config/dbConfig');
const cors = require("cors");


const port = 5005;

const app = express();
connectDB();

app.use(cors());

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