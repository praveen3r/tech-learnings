import { DeleteResult, UpdateResult } from "mongodb";
import UserModel from "../../model/UserModel";
import UserInput from "../../types/UserInput";

// Define resolvers for your schema
export const userResolver = {
  users: async () => {
    const users = await UserModel.find({});
    if (!users) {
      return null;
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
  deleteUser: async ({id}: { id: string)  => {
    try {
      const result: DeleteResult = await UserModel.deleteOne({"_id" : id});
      if (result.deletedCount !== 1) {
        throw new Error("No documents matched the query. Deleted 0 documents");
      }
    } catch (error) {
      throw error;
    }
  };
};
