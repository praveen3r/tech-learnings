const express = require('express');

const app = express();

//path params
app.get('/test/:test1', (req, res)=> {
    console.log(req.params);
    console.log(`value is ${req.params.test1}`);
    const {test1} = req.params;
    res.status(200).send('hello response');
});

//query params
app.get('/test1', (req, res)=> {
    console.log(req.query);
    console.log(`value is ${req.query.test1}`);
    const {test1} = req.query;
    res.status(200).send('hello response');
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});