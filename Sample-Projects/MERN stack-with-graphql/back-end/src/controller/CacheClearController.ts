import { RequestHandler, Router } from "express";
import CacheClearService from "../service/CacheClearService";
import HttpUtil from "../utils/HttpUtil";

class CacheClearController {
  private cacheClearService = new CacheClearService();

  clearCache: RequestHandler = async (
    req,
    res,
    next
  ): Promise<Response | void> => {
    try {
      let response: string;
      const cacheName: string = req.params.name;

      if (cacheName) {
        response = await this.cacheClearService.clearCache(cacheName);
      } else {
        response = await this.cacheClearService.clearAllCache();
      }
      HttpUtil.getResponse(res).json({ msg: response });
    } catch (error) {
      HttpUtil.handleError(<Error>error, next);
    }
  };
}

export default CacheClearController;
