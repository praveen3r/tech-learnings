import { Schema, model } from 'mongoose';
import { User } from './User';

export const UserSchema = new Schema({
    id: {
        type: Number,
        required: [true, 'Id is mandatory']
    },
    name: {
        type: String,
        minLength: [4, 'Name should be greater than 4 chars'],
        required: [true, 'Name is mandatory']
    },
    age: {
        type: Number,
        min: [18, 'Age should be greater than 18']
    },
    date: {
        type: Date,
        default: Date.now
    }
}, {
    timestamps: true
});

export default model<User>('User', UserSchema);