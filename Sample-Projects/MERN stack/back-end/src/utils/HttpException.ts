import { JsonInclude, JsonIncludeType, JsonProperty } from "jackson-js";
import { Utilities } from "./Utilities";

@JsonInclude({value: JsonIncludeType.NON_NULL})
class HttpException extends Error {

    @JsonProperty()
    public status: number | null;

    @JsonProperty()
    public statusCode: string | null;

    @JsonProperty()
    public statusMsg: string | null;

    //public list: HttpException[] | null;

    constructor(status?: number, statusMsg?: string, message?: string, list?:HttpException[]) {
        const errorMsg = message?message:"";
        super(errorMsg);
        this.status = status?status:null;
        this.statusMsg = statusMsg?statusMsg:null;
        this.statusCode = statusMsg?Utilities.getErrorCode(statusMsg):null;
        //this.list = null
    }
}

export default HttpException;