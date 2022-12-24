import { ObjectMapper } from "jackson-js";
import { Errors } from "../model/Errors";
import * as _ from "lodash"

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

    public static getErrorMsg(key: string, field: string) {
        const value = Errors[key as keyof typeof Errors]
        const compiled = _.template(value);
        return compiled({ 'field': field });
    }

}