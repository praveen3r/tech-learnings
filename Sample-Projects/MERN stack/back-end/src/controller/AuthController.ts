import { RequestHandler, Router } from "express";
import AuthService from "../service/AuthService";
import Auth from "../types/Auth";
import AuthError from "../utils/AuthError";
import HttpException from "../utils/HttpException";

class AuthController {
  private authService = new AuthService();

  authenticate: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const auth: Auth = req.body;
      await this.authService.authenticate(auth);
      res.status(200).json({ success: "true" });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        if (error.name && error.name === AuthError.ERROR_NAME) {
          next(new HttpException(401, error.message));
        } else {
          next(new HttpException(400, error.message));
        }
      }
    }
  };
}

export default AuthController;