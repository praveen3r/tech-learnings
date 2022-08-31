import jwt from "jsonwebtoken";
import "dotenv/config";
import { JSONType } from "../model/JSONType";

export class JwtUtils {
  static generateToken(payload: JSONType) {
    return jwt.sign(payload, process.env.JWT_SECRET!.toString(), {
      expiresIn: "30d",
    });
  }

  static verifyToken(token: string | undefined) {
    if (token) {
      return jwt.verify(token, process.env.JWT_SECRET!.toString());
    }
  }
}
