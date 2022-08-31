import { NextFunction, Response } from "express";
import { StatusCodes } from "http-status-codes";
import { ObjectMapper } from "jackson-js";
import { Errors } from "../model/Errors";
import { ResponseData } from "../model/ResponseData";
import HttpException from "./HttpException";
import { Utilities } from "./Utilities";

class HttpUtil {
  public static handleError(error: Error, next: NextFunction) {
    if (typeof error === "string") {
      next(new HttpException(StatusCodes.INTERNAL_SERVER_ERROR, Errors.CUSTOM503, (<string>error).toUpperCase()));
    } else if (error instanceof Error) {
      next(new HttpException(StatusCodes.INTERNAL_SERVER_ERROR, Errors.CUSTOM503, error.message));
    }
  }

  public static handleHttpException(httpException: HttpException, next: NextFunction) {
    next(new HttpException(httpException.status, httpException.statusMsg));
  }
  

  public static getResponse(res: Response): Response {
    const responseData = new ResponseData<string>();
    return res.status(StatusCodes.OK);
  }

  public static postResponse(res: Response): Response {
    const responseData = new ResponseData<string>();
    const jsonData = Utilities.convertObjectToJson(responseData);
    return res.status(StatusCodes.CREATED).json(jsonData);
  }

  public static putResponse(res: Response): Response {
    const responseData = new ResponseData<string>();
    const jsonData = Utilities.convertObjectToJson(responseData);
    return res.status(StatusCodes.OK).json(jsonData);
  }

  public static deleteResponse(res: Response): Response {
    return res.status(StatusCodes.NO_CONTENT);
  }
}

export default HttpUtil;
