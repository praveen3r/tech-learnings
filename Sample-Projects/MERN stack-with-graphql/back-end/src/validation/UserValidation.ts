import Joi from 'joi';

const authenticate = Joi.object({
    name: Joi.string().min(1).required().messages({'any.required':'name|CUSTOM003'}),
    age: Joi.number().min(1).required().messages({'any.required':'age|CUSTOM003'}),
    gender: Joi.string().min(1).required().messages({'any.required':'gender|CUSTOM003'}),
});

export default authenticate;