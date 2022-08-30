import { RequestHandler, Router } from "express";
import AuthService from "../service/AuthService";
import Auth from "../types/Auth";
import AuthError from "../utils/AuthError";
import HttpException from "../utils/HttpException";
import { StatusCodes } from "http-status-codes";

class AuthController {
  private authService = new AuthService();

  authenticate: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const auth: Auth = req.body;
      const token = await this.authService.authenticate(auth);
      //res.cookie('token', token, { httpOnly: true });
      res.status(StatusCodes.OK).json({ token});
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
