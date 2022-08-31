import { Request, Response, NextFunction } from 'express';
import { StatusCodes } from 'http-status-codes';
import { Errors } from '../model/Errors';
import { ResponseData } from '../model/ResponseData';
import HttpException from '../utils/HttpException';
import { Utilities } from '../utils/Utilities';

const errorMiddleWare = ( error: HttpException, req:Request , res: Response, next: NextFunction): void => {
    const errorMsg = (error.message)?error.message:error.statusMsg;
    console.log(`error in middleware is ${errorMsg}`);
    const status = error.status || StatusCodes.INTERNAL_SERVER_ERROR;
    const responseData = new ResponseData<string>();
    responseData._statusCode = error.statusCode || Utilities.getErrorCode(Errors.CUSTOM503);
    responseData._statusMsg = error.statusMsg || Errors.CUSTOM503;
    responseData._success = false;
    const jsonData = Utilities.convertObjectToJson(responseData);
    res.status(status).send(jsonData);
};

export default errorMiddleWare;