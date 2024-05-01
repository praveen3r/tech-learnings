
import { RequestHandler, Router } from "express";
import AppRouter from "./AppRouter";
import GenderController from './../controller/GenderController';

class GenderRoute implements AppRouter {
  public path = "/genders";
  public router = Router();
  private genderController = new GenderController();

  constructor() {
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.get(`${this.path}`, this.genderController.getGenders);
  }
}

export default GenderRoute;
