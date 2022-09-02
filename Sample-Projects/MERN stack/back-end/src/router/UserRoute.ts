
import { RequestHandler, Router } from "express";
import AppRouter from "./AppRouter";
import AuthController from "../controller/AuthController";
import validationMiddleware from '../middleware/ValidationMiddleware';
import validate from '../validation/UserValidation'
import UserController from "../controller/UserController";

class UserRoute implements AppRouter {
  public path = "/users";
  public router = Router();
  private userController = new UserController();

  constructor() {
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.get(`${this.path}`, this.userController.getUsers);
    this.router.post(`${this.path}/user`, validationMiddleware(validate), this.userController.addUser);
    this.router.put(`${this.path}/user/:id`, validationMiddleware(validate), this.userController.editUser);
    this.router.delete(`${this.path}/user/:id`, this.userController.deleteUser);
  }

  
}

export default UserRoute;
