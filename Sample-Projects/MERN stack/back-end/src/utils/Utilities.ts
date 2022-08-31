import { ObjectMapper } from "jackson-js";
import { Errors } from "../model/Errors";

export class Utilities {

    public static convertObjectToJson(object: Object ){
        const objectMapper = new ObjectMapper();
        const jsonData = objectMapper.stringify(object);
        return jsonData;
    }

    public static getErrorCode(value: string) {
        for (const key in Errors) {
            if(Errors[key as keyof typeof Errors] === value){
                return key;
            }
        }
        return "";
    }
}