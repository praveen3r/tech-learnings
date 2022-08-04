import { NextFunction, Response } from "express";
import HttpException from "./HttpException";

class HttpUtil {
  public static handleError(error: Error, next: NextFunction) {
    if (typeof error === "string") {
      next(new HttpException(400, (<string>error).toUpperCase()));
    } else if (error instanceof Error) {
      next(new HttpException(400, error.message));
    }
  }

  public static getResponse(res: Response): Response{
    return res.status(200);
  }
}

export default HttpUtil;
