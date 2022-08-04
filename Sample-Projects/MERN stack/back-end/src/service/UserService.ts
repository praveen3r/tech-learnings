import { DeleteResult, ObjectId, UpdateResult } from "mongodb";
import { Query, UpdateWriteOpResult } from "mongoose";
import AuthModel from "../model/AuthModel";
import UserModel from "../model/UserModel";
import Auth from "../types/Auth";
import User from "../types/User";
import AuthError from "../utils/AuthError";

class UserService {

  private user = UserModel;

  getUsers = async () : Promise<User[]> => {
    try {
      let users: User[] = await this.user.find().lean();
      if (users) {
        users.forEach((user, index) => {
          user.sNo = index+1;
        })
      }
      
      return users;
    } catch (error) {
      throw error;
    }
  };

  addUser = async (user: User) : Promise<void> => {
    try {
      await this.user.create(user);
    } catch (error) {
      throw error;
    }
  };

  editUser = async (id:ObjectId, user: User) : Promise<void> => {
    try {
      const result: UpdateResult = await this.user.updateOne({"_id" : id}, user );
      if (result.modifiedCount !== 1) {
        throw new Error("No documents matched the query. Updated 0 documents");
      }
    } catch (error) {
      throw error;
    }
  };

  deleteUser = async (id: ObjectId) : Promise<void> => {
    try {
      const result: DeleteResult = await this.user.deleteOne({"_id" : id});
      if (result.deletedCount !== 1) {
        throw new Error("No documents matched the query. Deleted 0 documents");
      }
    } catch (error) {
      throw error;
    }
  };

}

export default UserService;
