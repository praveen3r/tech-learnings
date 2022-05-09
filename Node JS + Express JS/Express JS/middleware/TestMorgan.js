const express = require('express');
const morgan = require('morgan');

const app = express();

app.use(morgan('tiny'));

app.get('/home', (req, res)=> {
    res.status(200).send('hello response');
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});