import { DeleteResult, UpdateResult } from "mongodb";
import { Query, UpdateWriteOpResult } from "mongoose";
import AuthModel from "../model/AuthModel";
import Auth from "../types/Auth";
import AuthError from "../utils/AuthError";

class AuthService {

  private auth = AuthModel;

  authenticate = async (auth: Auth) : Promise<void> => {
    try {
      const username: string = auth.username;
      const authNew: Auth | null = await this.auth.findOne({username});
      if (!authNew) {
        throw new AuthError("Unsuccessful authentication");
      }else if(authNew.keyword !== auth.keyword){
        throw new AuthError("Unsuccessful authentication");
      }
    } catch (error) {
      throw error;
    }
    
    
  };

}

export default AuthService;
