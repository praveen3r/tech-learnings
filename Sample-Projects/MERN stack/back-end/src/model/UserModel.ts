import { number } from 'joi';
import { Schema, model } from 'mongoose';
import Auth from '../types/Auth'

export const UserSchema = new Schema({
    name: {
        type: String,
        /*minLength: [1, 'name|CUSTOM003'],
        required: [true, 'name|CUSTOM003']*/
    },
    age : {
        type: Number,
        /*minLength: [1, 'name|CUSTOM003'],
        required: [true, 'name|CUSTOM003'],
        min: [15, 'name|CUSTOM003'],*/
    },
    gender : {
        type: String,
        /*minLength: [1, 'name|CUSTOM003'],
        required: [true, 'name|CUSTOM003']*/
    }
}, {
    timestamps: true
});

export default model<Auth>('User', UserSchema);