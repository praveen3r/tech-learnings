const express = require('express');
const myRouter = require('./TestRouter')

const app = express();

app.use('/api/test',myRouter);

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});