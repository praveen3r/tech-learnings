import { Request, Response, NextFunction } from 'express';
import { StatusCodes } from 'http-status-codes';
import { Errors } from '../model/Errors';
import { ResponseData } from '../model/ResponseData';
import HttpException from '../utils/HttpException';
import HttpUtil from '../utils/HttpUtil';
import { Utilities } from '../utils/Utilities';

const errorMiddleWare = ( error: HttpException, req:Request , res: Response, next: NextFunction): void => {
    const errorMsg = (error.message)?error.message:error.statusMsg;
    
    console.log(`error in the application is ${errorMsg}`);
    const status = error.status || StatusCodes.INTERNAL_SERVER_ERROR;
    const jsonData = HttpUtil.getErrorJson(error);
    res.status(status).send(jsonData);
};

export default errorMiddleWare;