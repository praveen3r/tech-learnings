import { RequestHandler, Router } from "express";
import { User } from "../model/User";
import UserService from "../service/UserService";
import HttpException from "../utils/HttpException";

// export const getUsers: RequestHandler = ( req , res, next): void => {
//   const user:User = new User(123,'test');
//   res.status(200).json({"user-info":user});
// }

/*class UserController implements Controller {
  public path = "/users";
  public router = Router();

  constructor() {
    this.path;
    this.initialiseRoutes();
  }

  private initialiseRoutes(): void {
    this.router.get(`${this.path}`, this.getUsers);
  }

  getUsers: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const user: User = new User(123, "test");
      res.status(200).json({ "user-info": user });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
    } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };
}*/

class UserController {
  private userService = new UserService();
  
  public getUsers: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const users = await this.userService.getUsers();
      res.status(200).json({ "user-info": users });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };

  public getUserById: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const id:number = Number(req.params.id);
      const users = await this.userService.getUserById(id);
      res.status(200).json({ "user-info": users });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };

  public getUserByParams: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const user = req.query as Object as User;
      const users = await this.userService.getUserByParams(user);
      res.status(200).json({ "user-info": users });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };

  public createUser: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const user = <User> req.body;
      await this.userService.createUser(user);
      res.status(200).json({ "user-info": "created successfully" });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };

  public createUsers: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const user = <User[]> req.body;
      await this.userService.createUsers(user);
      res.status(200).json({ "user-info": "created successfully" });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };

  public updateUser: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const id:number = Number(req.params.id);
      const user = <User> req.body;
      await this.userService.updateUser(id, user);
      res.status(200).json({ "user-info": "updated successfully" });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };

  public deleteUser: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const id:number = Number(req.params.id);
      await this.userService.deleteUser(id);
      res.status(200).json({ "user-info": "deleted successfully" });
    } catch (error) {
      if (typeof error === "string") {
        next(new HttpException(400, error.toUpperCase()));
      } else if (error instanceof Error) {
        next(new HttpException(400, error.message));
      }
    }
  };
}


export default UserController;