const express = require('express');
const bodyParser = require('body-parser');

const app = express();

app.delete('/test/:testId', (req, res)=> {
    res.json({success: true})
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});