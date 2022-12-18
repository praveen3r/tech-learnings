import GenderModel from "../model/GenderModel";
import Gender from "../types/Gender";


class GenderService {

  private gender = GenderModel;

  getGenders = async () : Promise<Gender[]> => {
    try {
      return await this.gender.find().lean();
    } catch (error) {
      throw error;
    }
  };

}

export default GenderService;
