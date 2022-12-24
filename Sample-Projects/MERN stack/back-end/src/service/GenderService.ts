import CacheManager from "../cache/CacheManager";
import GenderModel from "../model/GenderModel";
import Gender from "../types/Gender";



class GenderService {
  
  private gender = GenderModel;
  private cacheManager = CacheManager.getInstance();

  getGenders = async (): Promise<Gender[]> => {
    try {
      const cachedGenders = this.cacheManager.get<Gender[]>("genders");
      if (cachedGenders) {
        console.log(`coming from cache`);
        
        return cachedGenders;
      }
      console.log(`not cached, running query`);
      const genders = await this.gender.find().lean();
      this.cacheManager.set("genders", genders);

      return genders;
    } catch (error) {
      throw error;
    }
  };
}

export default GenderService;
