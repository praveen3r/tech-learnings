const express = require('express');
const bodyParser = require('body-parser');

const app = express();

app.use(bodyParser.json());

app.put('/test', (req, res)=> {
    console.log(req.body);
    res.json({success: true})
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});