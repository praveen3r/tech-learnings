import { StatusCodes } from "http-status-codes";
import AuthModel from "../model/AuthModel";
import { Errors } from "../model/Errors";
import Auth from "../types/Auth";
import HttpException from "../utils/HttpException";
import { JwtUtils } from "../utils/JwtUtils";

class AuthService {
  private auth = AuthModel;

  authenticate = async (auth: Auth): Promise<string> => {
    try {
      const username: string = auth.username;
      const authNew: Auth | null = await this.auth.findOne({ username });
      if (!authNew) {
        throw new HttpException(StatusCodes.UNAUTHORIZED, Errors.CUSTOM001);
      } else if (authNew.keyword !== auth.keyword) {
        throw new HttpException(StatusCodes.UNAUTHORIZED, Errors.CUSTOM001);
      }
      const token = JwtUtils.generateToken({ id: authNew.id });
      return token;
    } catch (error) {
      throw error;
    }
  };
}

export default AuthService;
