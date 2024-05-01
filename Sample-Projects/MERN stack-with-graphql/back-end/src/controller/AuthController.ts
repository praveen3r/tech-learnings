import { RequestHandler, Router } from "express";
import AuthService from "../service/AuthService";
import Auth from "../types/Auth";
import HttpException from "../utils/HttpException";
import { StatusCodes } from "http-status-codes";
import HttpUtil from "../utils/HttpUtil";

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
       if(error instanceof HttpException){
        HttpUtil.handleHttpException(<HttpException>error, next);
       }else{
        HttpUtil.handleError(<Error>error, next);
       }
    }
  };
}

export default AuthController;
