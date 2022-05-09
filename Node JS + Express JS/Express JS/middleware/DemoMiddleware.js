const loggerMiddleWare = (req, res, next) => {
    console.log(`request is ${req}`);
    next();
}

module.exports = loggerMiddleWare;