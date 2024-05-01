import { NextFunction, Request, Response } from "express";
import { StatusCodes } from "http-status-codes";
import { Errors } from "../model/Errors";
import HttpException from "../utils/HttpException";
import HttpUtil from "../utils/HttpUtil";
import { JwtUtils } from "../utils/JwtUtils";

const authMiddleware = (req: Request, res: Response, next: NextFunction) => {
  try {
    const url = req.url;
    if (req.url != "/api/authenticate") {
      const authHeader = req.headers.authorization;
      const token = authHeader?.split(" ")[1];
      const decoded = JwtUtils.verifyToken(token);
      if (decoded) {
        next();
      } else {
        next(new HttpException(StatusCodes.UNAUTHORIZED, Errors.CUSTOM002));
      }
    } else {
      next();
    }
  } catch (error) {
    HttpUtil.handleError(<Error>error, next);
  }
};

export default authMiddleware;
