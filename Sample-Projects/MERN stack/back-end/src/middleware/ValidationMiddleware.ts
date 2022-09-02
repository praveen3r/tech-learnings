import { Request, Response, NextFunction, RequestHandler } from 'express';
import { StatusCodes } from 'http-status-codes';
import Joi from 'joi';
import { ResponseData } from '../model/ResponseData';
import HttpException from '../utils/HttpException';
import HttpUtil from '../utils/HttpUtil';
import { Utilities } from '../utils/Utilities';

const validationMiddleware = (schema: Joi.Schema): RequestHandler => {
    return async (
        req: Request,
        res: Response,
        next: NextFunction
    ): Promise<void> => {
        const validationOptions = {
            abortEarly: false,
            allowUnknown: true,
            stripUnknown: true,
        };

        try {
            const value = await schema.validateAsync(
                req.body,
                validationOptions
            );
            req.body = value;
            next();
        } catch (e: any) {
            const errors: HttpException[] = [];
            e.details.forEach((error: Joi.ValidationErrorItem) => {
                
                //console.log(`error is ${error.type}`);
                const errorMsg = error.message;
                const httpException = HttpUtil.getException(errorMsg);
                errors.push(httpException);
            });
            
            const jsonData = HttpUtil.getErrorJsonList(errors);
            console.log(`error in validation is ${jsonData}`);
            
            res.status(StatusCodes.BAD_REQUEST).send(jsonData);
        }
    };
};

export default validationMiddleware;