import { DeleteResult, UpdateResult } from "mongodb";
import { Query, UpdateWriteOpResult } from "mongoose";
import { User } from "../model/User";
import UserModal from "../model/UserModel";

class UserService {
  private user = UserModal;

  getUsers = async (): Promise<Array<User>> => {
    try {
      const users: Array<User> = await this.user.find();
      if (!users || users.length <= 0) {
        throw new Error("Unable to find users");
      }
      return users;
    } catch (error) {
      throw error;
    }
  };

  getUserById = async (id: number): Promise<User> => {
    try {
      const user: User | null = await this.user.findOne({id});
      if (!user) {
        throw new Error("Unable to find user");
      }
      return user;
    } catch (error) {
      throw error;
    }
  };

  getUserByParams = async (params: User): Promise<Array<User>> => {
    try {
      //const user: Array<User> = await this.user.find(params);
      //const user: Array<User> = await this.user.find(params).sort({name: 1});
      //const user: Array<User> = await this.user.find(params).select({ "name": 1});
      //const user: Array<User> = await this.user.find(params).select('name');
      //const user: Array<User> = await this.user.find({"id": { $gte: params.id}}).select({ "name": 1});
      /*const documentCount = await this.user.countDocuments({"id": { $gte: params.id}}).select({ "name": 1});
      console.log( "Number of users:", documentCount );*/
      const user: Array<User> = await this.user.find({"name": { $regex : '.*'+ params.name + '.*' , $options: 'i'} }).select({ "name": 1});
      if (!user) {
        throw new Error("Unable to find user");
      }
      return user;
    } catch (error) {
      throw error;
    }
  };

  createUser = async (params: User): Promise<User> => {
    try {
      const user: User = await this.user.create(params);
      if (!user) {
        throw new Error("Unable to create user");
      }
      return user;
    } catch (error) {
      throw error;
    }
  };

  createUsers = async (params: User[]): Promise<User[]> => {
    try {
      //const user: User = await this.user.create(params);
      //const user: User[] = await this.user.create(params);
      const user: User[] = await this.user.insertMany(params);
      if (!user || user.length<=0) {
        throw new Error("Unable to create user");
      }
      return user;
    } catch (error) {
      throw error;
    }
  };

  updateUser = async (id:number, params: User): Promise<UpdateResult> => {
    try {
      const result: UpdateResult = await this.user.updateOne({"id" : id}, params );
      if (result.modifiedCount !== 1) {
        throw new Error("No documents matched the query. Updated 0 documents");
      }
      return result;
    } catch (error) {
      throw error;
    }
  };

  deleteUser = async (id:number): Promise<DeleteResult> => {
    try {
      const result: DeleteResult = await this.user.deleteOne({"id" : id});
      if (result.deletedCount !== 1) {
        throw new Error("No documents matched the query. Deleted 0 documents");
      }
      return result;
    } catch (error) {
      throw error;
    }
  };
}

export default UserService;
