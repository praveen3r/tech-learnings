import CacheManager from "../cache/CacheManager";
import GenderModel from "../model/GenderModel";
import Gender from "../types/Gender";
import LogManager from "./../log/LogManager";

class GenderService {
  
  private gender = GenderModel;
  private cacheManager = CacheManager.getInstance();
  private log = LogManager.getInstance();

  getGenders = async (): Promise<Gender[]> => {
    try {
      const cachedGenders = this.cacheManager.get<Gender[]>("genders");
      if (cachedGenders) {
        this.log.debug(`coming from cache`);
        
        return cachedGenders;
      }
      this.log.debug(`not cached, running query`);
      const genders = await this.gender.find().lean();
      this.cacheManager.set("genders", genders);

      return genders;
    } catch (error) {
      throw error;
    }
  };
}

export default GenderService;
