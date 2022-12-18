import { RequestHandler, Router } from "express";
import GenderService from "../service/GenderService";
import HttpUtil from "../utils/HttpUtil";

class GenderController {
  private genderService = new GenderService();

  getGenders: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      const genders = await this.genderService.getGenders();
      HttpUtil.getResponse(res).json({ genders: genders });
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };
}

export default GenderController;
