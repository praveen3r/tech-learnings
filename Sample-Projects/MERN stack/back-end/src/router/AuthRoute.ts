
import { RequestHandler, Router } from "express";
import AppRouter from "./AppRouter";
import AuthController from "../controller/AuthController";
import validationMiddleware from '../middleware/ValidationMiddleware';
import validate from '../validation/AuthValidation'

class AuthRoute implements AppRouter {
  public path = "/authenticate";
  public router = Router();
  private authController = new AuthController();

  constructor() {
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.post(`${this.path}`, validationMiddleware(validate), this.authController.authenticate);
  }

  
}

export default AuthRoute;
