const express = require("express");
const { createClient } = require("redis");

const app = express();
const client = createClient();

client.on("connect", function () {
  console.log("Connected!");
});

client.on("error", (err) => console.log("Redis Client Error", err));

client.connect();


async function getFunc(req, res) {
    let cachedData = await client.get("data");
    console.log(`cachedData ${cachedData}`);
    if(cachedData != null){
        console.log(`coming here`);
        cachedData = "Hello caching";
        client.set("data", cachedData);
    }
    res.send(cachedData);
}

app.get("/", getFunc);

app.listen(5000, () => {
  console.log(`server started in port 5000`);
});
