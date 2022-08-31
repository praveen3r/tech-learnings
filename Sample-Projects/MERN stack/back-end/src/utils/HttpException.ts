class HttpException extends Error {
    public status: number;
    public statusCode: string | undefined;
    public message: string;

    constructor(status: number, message: string, statusCode?: string) {
        super(message);
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }
}

export default HttpException;