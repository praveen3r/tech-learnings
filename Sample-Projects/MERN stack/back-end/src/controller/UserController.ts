import { RequestHandler, Router } from "express";
import { ObjectId } from "mongodb";
import AuthService from "../service/AuthService";
import UserService from "../service/UserService";
import Auth from "../types/Auth";
import User from "../types/User";
import AuthError from "../utils/AuthError";
import HttpException from "../utils/HttpException";
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
      
      HttpUtil.getResponse(res).json({success: true});
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
      
      HttpUtil.getResponse(res).json({success: true});
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
      
      HttpUtil.getResponse(res).json({success: true});
      
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };
}

export default UserController;
