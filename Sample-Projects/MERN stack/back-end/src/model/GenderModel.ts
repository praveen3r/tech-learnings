import { Schema, model } from 'mongoose';
import Gender from '../types/Gender';

export const GenderSchema = new Schema({
    key: {
        type: String,
    },
    value : {
        type: Number,
    }
});

export default model<Gender>('Gender', GenderSchema);