import Joi from 'joi';

const authenticate = Joi.object({
    username: Joi.string().min(1).required().messages({'any.required':'username|CUSTOM003'}),
    keyword: Joi.string().min(1).required().messages({'any.required':'keyword|CUSTOM003'}),
});

export default authenticate;