import { Request, Response, NextFunction } from 'express';
import HttpException from '../utils/HttpException';

const errorMiddleWare = ( error: HttpException, req:Request , res: Response, next: NextFunction): void => {
    console.log(`request in error middleware is ${req}`);
    const status = error.status || 500;
    const message = error.message || 'Something went wrong';
    res.status(status).send({
        status,
        message,
    });
};

export default errorMiddleWare;