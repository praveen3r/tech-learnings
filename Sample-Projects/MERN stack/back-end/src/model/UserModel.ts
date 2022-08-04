import { number } from 'joi';
import { Schema, model } from 'mongoose';
import Auth from '../types/Auth'

export const UserSchema = new Schema({
    name: {
        type: String,
        minLength: [1, 'Name should be greater than 1 chars'],
        required: [true, 'Name is mandatory']
    },
    age : {
        type: Number,
        minLength: [2, 'age should be greater than 2 chars'],
        required: [true, 'age is mandatory'],
        min: [15, 'Min age should be 15'],
    },
    gender : {
        type: String,
        minLength: [1, 'gender should be greater than 1 chars'],
        required: [true, 'gender is mandatory']
    }
}, {
    timestamps: true
});

export default model<Auth>('User', UserSchema);