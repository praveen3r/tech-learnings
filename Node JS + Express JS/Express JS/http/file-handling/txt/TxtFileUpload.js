const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const busboy = require('busboy');

const app = express();

//app.use(bodyParser.json());
app.use(cors());

app.post('/api/users/file', (req, res)=> {
        console.log(`coming here`);
        try {
          const bb = busboy({
            headers: req.headers
          });
          bb.on('file', (name, file, info) => {
            file.setEncoding('utf8');
              const { filename, encoding, mimeType } = info;
              console.log(
                `File [${name}]: filename: %j, encoding: %j, mimeType: %j`,
                filename,
                encoding,
                mimeType
              );
              file.on('data', (data) => {
                console.log(`data is`);
                console.log(data);
                console.log(`File [${name}] got ${data.length} bytes`);
              }).on('close', () => {
                console.log(`File [${name}] done`);
              });
            });
            bb.on('field', (name, val, info) => {
              console.log(`Field [${name}]: value: %j`, val);
            });
            bb.on('close', () => {
              console.log('Done parsing form!');
             // res.writeHead(303, { Connection: 'close', Location: '/' });
              res.end();
            });
            req.pipe(bb);
        } catch (err) {
          console.log(err);
        }
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});