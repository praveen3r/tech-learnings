const express = require('express');
const NodeCache = require('node-cache');

const app = express();
const myCache = new NodeCache({stdTTL: 10});

app.get('/', (req, res)=> {
    if(myCache.has("data")){
        res.status(200).send(myCache.get("data"));
    }else{
        console.log(`coming here`);
        myCache.set("data", "Hello caching");
        res.status(200).send(myCache.get("data"));
    }
});

app.get('/stats', (req, res)=> {
    res.send(myCache.getStats());
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});