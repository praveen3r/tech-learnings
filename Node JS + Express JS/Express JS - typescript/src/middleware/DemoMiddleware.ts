//import { Request, Response, NextFunction } from 'express';
import { RequestHandler } from 'express';

//const loggerMiddleWare = ( req:Request , res: Response, next: NextFunction): void => {
    const loggerMiddleWare: RequestHandler = ( req , res, next): void => {
    console.log(`request is ${req}`);
    next();
}

export default loggerMiddleWare;