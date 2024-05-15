import { DeleteResult, UpdateResult } from "mongodb";
import UserModel from "../../model/UserModel";
import UserInput from "../../types/UserInput";
import User from "../../types/User";

// Define resolvers for your schema
export const userResolver = {
  users: async () => {
    let users: User[] = await UserModel.find({});
    if (!users) {
      return null;
    }else{
      users.forEach((user, index) => {
        user.sNo = index+1;
      })
    }
    return users;
  },

  addUser: async ({ user }: { user: UserInput }) => {
    try {
      return await UserModel.create(user);
    } catch (err) {
      console.log(`Error occured ${err}`);
    }
  },
  editUser: async ({ id, user }: { id: string; user: UserInput }) => {
    try {
      const result: UpdateResult = await UserModel.updateOne({ _id: id }, user);
      if (result.modifiedCount !== 1) {
        throw new Error("No documents matched the query. Updated 0 documents");
      }
    } catch (error) {
      throw error;
    }
  },
  deleteUser: async ({id}: { id: string})  => {
    try {
      const result: DeleteResult = await UserModel.deleteOne({"_id" : id});
      if (result.deletedCount !== 1) {
        throw new Error("No documents matched the query. Deleted 0 documents");
      }
    } catch (error) {
      throw error;
    }
  },
  searchUsers: async ({name}: { name: string}) => {
    try {
      const users: Array<User> = await UserModel.find({"name": { $regex : '.*'+ name + '.*' , $options: 'i'} })
      if (!users) {
        return null;
      }else{
        users.forEach((user, index) => {
          user.sNo = index+1;
        })
      }
      
      return users;
    } catch (error) {
      throw error;
    }
  },
};
