const http = require('http')

const server = http.createServer();

server.on('request', (req,res) => {
    if(req.url== '/'){
     res.end(`Welcome to home page`)   
    }else{
        res.end(`<h1>Error</h1>`)
    }
})

server.listen(4500);