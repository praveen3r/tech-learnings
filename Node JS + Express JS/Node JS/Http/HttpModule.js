const http = require('http')

const server = http.createServer((req,res) => {
    if(req.url== '/'){
     res.end(`Welcome to home page`)   
    }else{
        res.end(`<h1>Error</h1>`)
    }
    // res.write("Http from node");
    // res.end();
})

server.listen(4500);