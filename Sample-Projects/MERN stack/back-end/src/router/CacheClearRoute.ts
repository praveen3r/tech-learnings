
import { Router } from "express";
import AppRouter from "./AppRouter";
import CacheClearController from "../controller/CacheClearController";

class CacheClearRoute implements AppRouter {
  public path = "/cache/clear";
  public router = Router();
  private cacheClearController = new CacheClearController();

  constructor() {
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.get(`${this.path}`, this.cacheClearController.clearCache);
    this.router.get(`${this.path}/:name`, this.cacheClearController.clearCache);
  }
}

export default CacheClearRoute;
