const express = require('express');

const app = express();

app.get('/', (req, res)=> {
    res.status(200).send('hello response');
})

app.get('/home', (req, res)=> {
    res.send('hello home');
})

app.all('/*', (req, res)=> {
    res.send('Serving all requests');
})

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
})