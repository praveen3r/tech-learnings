const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const busboy = require('busboy');

const app = express();

//app.use(bodyParser.json());
app.use(cors());

app.post('/api/users/file', (req, res)=> {
  /*res.download('/file/to/be/downloaded.ext');
  res.status(200);*/
  var text = 'Hello world11!';
  res.send(text);
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});