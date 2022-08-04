import Joi from 'joi';

const authenticate = Joi.object({
    username: Joi.string().min(1).required(),
    keyword: Joi.string().min(1).required(),
});

export default authenticate;