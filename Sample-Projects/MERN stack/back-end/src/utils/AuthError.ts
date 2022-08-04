class AuthError extends Error {
    public message: string;
    public static ERROR_NAME = 'AuthError';

    constructor(message: string) {
        super(message);
        this.name = AuthError.ERROR_NAME;
        this.message = message;
    }
}

export default AuthError;