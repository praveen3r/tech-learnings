const express = require('express');
const {employee} = require('./Employee');

const app = express();

app.get('/', (req, res)=> {
    //res.json({id:1,name:"test"});
    //res.json([{id:1,name:"test"}]);
    res.json(employee);
})

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
})