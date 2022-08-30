import { Request, Response, NextFunction } from 'express';
import { StatusCodes } from 'http-status-codes';
import { ResponseData } from '../model/ResponseData';
import HttpException from '../utils/HttpException';
import { Utilities } from '../utils/Utilities';

const errorMiddleWare = ( error: HttpException, req:Request , res: Response, next: NextFunction): void => {
    console.log(`error in middleware is ${error.message}`);
    const status = error.status || StatusCodes.INTERNAL_SERVER_ERROR;
    const responseData = new ResponseData<string>();
    responseData._statusCode = "CUSTOM001";
    responseData._statusMsg = error.message || 'Something went wrong';
    responseData._success = false;
    const jsonData = Utilities.convertObjectToJson(responseData);
    res.status(status).send(jsonData);
};

export default errorMiddleWare;