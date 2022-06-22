/*import { Router, Request, Response } from 'express';
import { getUsers } from '../controller/UserController';

const router = Router();

router.get("/", getUsers);

export default router;*/

import { RequestHandler, Router } from "express";
import UserController  from "../controller/UserController";
import HttpException from "../utils/HttpException";
import { User } from "./../model/User";
import AppRouter from "./AppRouter";
import Controller from "./AppRouter";
import validate from '../validation/UserValidation'
import validationMiddleware from '../middleware/ValidationMiddleware';

// export const getUsers: RequestHandler = ( req , res, next): void => {
//   const user:User = new User(123,'test');
//   res.status(200).json({"user-info":user});
// }

class UserRoute implements AppRouter {
  public path = "/users";
  public router = Router();
  private userController = new UserController();

  constructor() {
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.get(`${this.path}`, this.userController.getUsers);
    this.router.get(`${this.path}/user/:id`, this.userController.getUserById);
    this.router.get(`${this.path}/user`, this.userController.getUserByParams);
    this.router.post(`${this.path}/user`, validationMiddleware(validate), this.userController.createUser);
    this.router.post(`${this.path}`, this.userController.createUsers);
    this.router.put(`${this.path}/user/:id`, this.userController.updateUser);
    this.router.delete(`${this.path}/user/:id`, this.userController.deleteUser);
  }

  
}

export default UserRoute;
