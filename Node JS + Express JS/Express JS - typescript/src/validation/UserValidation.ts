import Joi from 'joi';

const create = Joi.object({
    id: Joi.number().required(),
    name: Joi.string().min(1).max(40).required(),
    age: Joi.number().required()
});

export default create;