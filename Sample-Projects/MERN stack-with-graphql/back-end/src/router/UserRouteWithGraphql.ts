import { Router } from "express";
import { graphqlHTTP } from "express-graphql";
import { buildSchema } from "graphql";
import { userResolver } from "../graphql/resolvers/UserResolver";
import { userType } from "../graphql/types/UserType";
import AppRouter from "./AppRouter";

class UserRouteWithGraphQl implements AppRouter {
  public path = "/graphql";
  public router = Router();

  constructor() {
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.all(
      `${this.path}`,
      graphqlHTTP({
        schema: buildSchema(userType),
        rootValue: userResolver,
        graphiql: true,
      })
    );
  }
}

export default UserRouteWithGraphQl;
