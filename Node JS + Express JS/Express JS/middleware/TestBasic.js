const express = require('express');

const app = express();

const loggerMiddleWare = (req, res, next) => {
    console.log(`request is ${req}`);
    //res.send(`sending from middleware`);
    next();
}

app.get('/home', loggerMiddleWare, (req, res)=> {
    res.status(200).send('hello response');
});

app.get('/about', loggerMiddleWare, (req, res)=> {
    res.status(200).send('hello response');
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});