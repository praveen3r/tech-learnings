const authorize = (req, res, next) => {
    console.log(`authorize is ${req}`);
    const {user} = req.query;
    if(user){
        req.sessionInfo = user;
        next();
    }else{
        res.send('Not authorized');
    }
   
}

module.exports = authorize;