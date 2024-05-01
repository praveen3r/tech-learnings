import { NextFunction, Response } from "express";
import { StatusCodes } from "http-status-codes";
import { ObjectMapper } from "jackson-js";
//import { Error } from "mongoose";
import { Errors } from "../model/Errors";
import { ResponseData } from "../model/ResponseData";
import HttpException from "./HttpException";
import { Utilities } from "./Utilities";

class HttpUtil {
  public static handleError(error: Error, next: NextFunction) {
    if (typeof error === "string") {
      next(
        new HttpException(
          StatusCodes.INTERNAL_SERVER_ERROR,
          Errors.CUSTOM503,
          (<string>error).toUpperCase()
        )
      );
    } else if (error instanceof Error) {
      next(
        new HttpException(
          StatusCodes.INTERNAL_SERVER_ERROR,
          Errors.CUSTOM503,
          error.message
        )
      );
    }
  }

  /*public static handleErrorMongoose(error: any, next: NextFunction) {
    if (error.name === "ValidationError") {
      let exception: HttpException = new HttpException();
      exception.status = StatusCodes.BAD_REQUEST;
      let errArr: HttpException[] = [];
      let errNew = <Error.ValidationError>error;
      Object.keys(errNew.errors).forEach((key) => {
        const err: HttpException = this.getMongooseException(errNew, key);
        errArr.push(err);
      });
      exception.list = errArr;
      next(exception);
    } else {
      if (typeof error === "string") {
        next(
          new HttpException(
            StatusCodes.INTERNAL_SERVER_ERROR,
            Errors.CUSTOM503,
            (<string>error).toUpperCase()
          )
        );
      } else if (error instanceof Error) {
        next(
          new HttpException(
            StatusCodes.INTERNAL_SERVER_ERROR,
            Errors.CUSTOM503,
            error.message
          )
        );
      }
    }
  }*/

  public static handleHttpException(
    httpException: HttpException,
    next: NextFunction
  ) {
    next(new HttpException(httpException.status!, httpException.statusMsg!));
  }

  /*public static getMongooseException(
    error: Error.ValidationError,
    key: string
  ) {
    let httpException = new HttpException();
    const message = error.errors[key].message;
    const errorMsg = message.split("|");
    const field = errorMsg[0];
    const errorCode = errorMsg[1];
    httpException.statusCode = errorCode;
    const statusMsg = Utilities.getErrorMsg(errorCode, field);
    httpException.statusMsg = statusMsg;
    return httpException;
  }*/

  public static getException(message: string) {
    let httpException = new HttpException();
    const errorMsg = message.split("|");
    const field = errorMsg[0];
    const errorCode = errorMsg[1];
    httpException.statusCode = errorCode;
    const statusMsg = Utilities.getErrorMsg(errorCode, field);
    httpException.statusMsg = statusMsg;
    return httpException;
  }

  public static getErrorJson(error: HttpException) {
    const responseData = new ResponseData<HttpException>();
    responseData._statusCode =
      error.statusCode || Utilities.getErrorCode(Errors.CUSTOM503);
    responseData._statusMsg = error.statusMsg || Errors.CUSTOM503;
    responseData._success = false;
    //responseData._list = error.list;
    const jsonData = Utilities.convertObjectToJson(responseData);
    return jsonData;
  }

  public static getErrorJsonList(errors: HttpException[]) {
    const responseData = new ResponseData<HttpException>();
    responseData._success = false;
    responseData._list = errors;
    const jsonData = Utilities.convertObjectToJson(responseData);
    return jsonData;
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

  public static getEmptyResponse(res: Response): Response {
    const responseData = new ResponseData<string>();
    return res.status(StatusCodes.OK).json({success:true});
  }
}

export default HttpUtil;
