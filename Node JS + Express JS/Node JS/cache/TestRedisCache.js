const http = require("http");
const NodeCache = require("node-cache");

const { createClient } = require("redis");

const app = express();
const client = createClient();

client.on("connect", function () {
  console.log("Connected!");
});

client.on("error", (err) => console.log("Redis Client Error", err));

client.connect();

const server = asynchttp.createServer(async (req, res) => {
  if (req.url == "/") {
    let cachedData = await client.get("data");
    console.log(`cachedData ${cachedData}`);
    if(cachedData != null){
        console.log(`coming here`);
        cachedData = "Hello caching";
        client.set("data", cachedData);
    }
    res.send(cachedData);
  } else {
    res.end(`<h1>Error</h1>`);
  }
  // res.write("Http from node");
  // res.end();
});

server.listen(4500);
