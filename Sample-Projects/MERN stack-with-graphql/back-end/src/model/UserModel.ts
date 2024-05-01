import { Schema, model } from 'mongoose';
import User from '../types/User';

export const UserSchema = new Schema({
    name: {
        type: String,
    },
    age : {
        type: Number,
        
    },
    gender : {
        type: String,
        
    }
}, {
    timestamps: true
});

export default model<User>('User', UserSchema);