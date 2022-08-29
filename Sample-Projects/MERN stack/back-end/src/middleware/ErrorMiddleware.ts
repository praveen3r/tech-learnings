import { Request, Response, NextFunction } from 'express';
import { StatusCodes } from 'http-status-codes';
import HttpException from '../utils/HttpException';

const errorMiddleWare = ( error: HttpException, req:Request , res: Response, next: NextFunction): void => {
    console.log(`error in middleware is ${error.message}`);
    const status = error.status || StatusCodes.INTERNAL_SERVER_ERROR;
    const message = error.message || 'Something went wrong';
    res.status(status).send({
        status,
        message,
    });
};

export default errorMiddleWare;