import { Request, Response, NextFunction } from 'express';
import { StatusCodes } from 'http-status-codes';
import { Errors } from '../model/Errors';
import { HTTPErrors } from '../model/HTTPErrors';
import { ResponseData } from '../model/ResponseData';
import HttpException from '../utils/HttpException';
import HttpUtil from '../utils/HttpUtil';
import { Utilities } from '../utils/Utilities';

const methodNotAllowedMiddleWare = ( req:Request , res: Response, next: NextFunction) => {
    res.status(StatusCodes.METHOD_NOT_ALLOWED).send(HTTPErrors.NOT_ALLOWED);
};

export default methodNotAllowedMiddleWare;