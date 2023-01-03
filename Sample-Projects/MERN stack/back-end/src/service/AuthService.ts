import { StatusCodes } from "http-status-codes";
import AuthModel from "../model/AuthModel";
import { Errors } from "../model/Errors";
import Auth from "../types/Auth";
import HttpException from "../utils/HttpException";
import { JwtUtils } from "../utils/JwtUtils";
import bcrypt from "bcryptjs";
import CryptoJS from "crypto-js";


class AuthService {
  private auth = AuthModel;

  authenticate = async (auth: Auth): Promise<string> => {
    try {
      const username: string = auth.username;
      const bytes = CryptoJS.AES.decrypt(auth.keyword, 'my-secret-key@123');
      const keyword = bytes.toString(CryptoJS.enc.Utf8);
      const authNew: Auth | null = await this.auth.findOne({ username });
      if (!authNew) {
        throw new HttpException(StatusCodes.UNAUTHORIZED, Errors.CUSTOM001);
      } else if (!bcrypt.compareSync(keyword, authNew.keyword)) {
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
