import { ObjectMapper } from "jackson-js";

export class Utilities {

    public static convertObjectToJson(object: Object ){
        const objectMapper = new ObjectMapper();
        const jsonData = objectMapper.stringify(object);
        return jsonData;
    }
}