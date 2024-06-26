import { Router } from "express";
import UserController from "../controller/UserController";
import validationMiddleware from "../middleware/ValidationMiddleware";
import validate from "../validation/UserValidation";
import AppRouter from "./AppRouter";

class UserRoute implements AppRouter {
  public path = "/users";
  public router = Router();
  private userController = new UserController();

  constructor() {
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.get(`${this.path}`, this.userController.getUsers);
    this.router.post(
      `${this.path}/user`,
      validationMiddleware(validate),
      this.userController.addUser
    );
    this.router.put(
      `${this.path}/user/:id`,
      validationMiddleware(validate),
      this.userController.editUser
    );
    this.router.delete(`${this.path}/user/:id`, this.userController.deleteUser);
    this.router.get(`${this.path}/search`, this.userController.getUsersSearch);
    this.router.get(`${this.path}/download`, this.userController.download);
  }
}

export default UserRoute;
