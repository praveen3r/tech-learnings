import { Schema, model } from 'mongoose';
import Auth from '../types/Auth'

export const AuthSchema = new Schema({
    username: {
        type: String,
        minLength: [1, 'Username should be greater than 1 chars'],
        required: [true, 'Username is mandatory']
    },
    keyword : {
        type: String,
        minLength: [1, 'keyword should be greater than 1 chars'],
        required: [true, 'Name is mandatory']
    }
}, {
    timestamps: true
});

export default model<Auth>('Auth', AuthSchema, 'auth');