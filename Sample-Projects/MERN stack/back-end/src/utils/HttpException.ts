import { Utilities } from "./Utilities";

class HttpException extends Error {
    public status: number;
    public statusCode: string;
    public statusMsg: string;

    constructor(status: number, statusMsg: string, message?: string) {
        const errorMsg = message?message:"";
        super(errorMsg);
        this.status = status;
        this.statusMsg = statusMsg;
        this.statusCode = Utilities.getErrorCode(statusMsg);
    }
}

export default HttpException;