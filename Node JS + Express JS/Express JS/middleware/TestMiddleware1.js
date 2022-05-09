const express = require('express');
const loggerMiddleWare = require('./DemoMiddleware')
const authorize = require('./Authorize')

const app = express();

//multiple middleware
app.use([loggerMiddleWare, authorize]);

//applicable for specific about API
//app.use('/about',loggerMiddleWare);

app.get('/home', (req, res)=> {
    res.status(200).send('hello response');
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});