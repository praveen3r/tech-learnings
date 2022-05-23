const http = require("http");
const NodeCache = require("node-cache");

const myCache = new NodeCache({ stdTTL: 10 });

const server = http.createServer((req, res) => {
  if (req.url == "/") {
    if (myCache.has("data")) {
      res.end(myCache.get("data"));
    } else {
      myCache.set("data", "Hello caching");
    }
  } else {
    res.end(`<h1>Error</h1>`);
  }
  // res.write("Http from node");
  // res.end();
});

server.listen(4500);
