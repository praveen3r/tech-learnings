import { RequestHandler, Router } from "express";
import { ObjectId } from "mongodb";
import UserService from "../service/UserService";
import User from "../types/User";
import HttpUtil from "../utils/HttpUtil";

class UserController {
  private userService = new UserService();

  getUsers: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      
      const users = await this.userService.getUsers();
      HttpUtil.getResponse(res).json({ users: users });
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };

  addUser: RequestHandler = async (
    req,
    res,
    next
  ): Promise<void> => {
    try {
      const user = <User> req.body;
      await this.userService.addUser(user);
      HttpUtil.postResponse(res);
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };

  editUser: RequestHandler = async (
    req,
    res,
    next
  ): Promise<void> => {
    try {
      const id:ObjectId = new ObjectId(req.params.id);
      const user = <User> req.body;
      await this.userService.editUser(id, user);
      
      HttpUtil.putResponse(res);
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };

  deleteUser: RequestHandler = async (
    req,
    res,
    next
  ): Promise<void> => {
    try {
      const id:ObjectId = new ObjectId(req.params.id);
      await this.userService.deleteUser(id);
      
      HttpUtil.deleteResponse(res);
      
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };

  getUsersSearch: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const user = req.query as Object as User;
      const users = await this.userService.getUserSearch(user);
      HttpUtil.getResponse(res).json({ users: users });
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };

  download: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      await this.userService.download(res);
      HttpUtil.getResponse(res);
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };
}

export default UserController;
