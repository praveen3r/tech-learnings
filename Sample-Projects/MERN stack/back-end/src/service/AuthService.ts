import { DeleteResult, UpdateResult } from "mongodb";
import { Query, UpdateWriteOpResult } from "mongoose";
import AuthModel from "../model/AuthModel";
import Auth from "../types/Auth";
import AuthError from "../utils/AuthError";
import { JwtUtils } from "../utils/JwtUtils";

class AuthService {

  private auth = AuthModel;

  authenticate = async (auth: Auth) : Promise<string> => {
    try {
      const username: string = auth.username;
      const authNew: Auth | null = await this.auth.findOne({username});
      if (!authNew) {
        throw new AuthError("Unsuccessful authentication");
      }else if(authNew.keyword !== auth.keyword){
        throw new AuthError("Unsuccessful authentication");
      }
      
      const token = JwtUtils.generateToken({username});
      return token;
    } catch (error) {
      throw error;
    }
    
    
  };

}

export default AuthService;
