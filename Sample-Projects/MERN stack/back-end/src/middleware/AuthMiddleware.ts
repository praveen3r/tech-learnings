import { Request, Response, NextFunction, RequestHandler } from "express";
import HttpException from "../utils/HttpException";
import { JwtUtils } from "../utils/JwtUtils";

const authMiddleware = (req: Request, res: Response, next: NextFunction) => {
  try {
    const url = req.url;
    if (req.url != "/api/authenticate") {
      const authHeader = req.headers.authorization;
      const token = authHeader?.split(" ")[1];
      const decoded = JwtUtils.verifyToken(token);
      if (decoded) {
        next();
      }else{
        next(new HttpException(401, "Unauthorized access", "CUSTOM002"));
      }
    } else {
      next();
    }
  } catch (error) {
    next(new HttpException(401, "Unauthorized access", "CUSTOM002"));
  }
};

export default authMiddleware;
