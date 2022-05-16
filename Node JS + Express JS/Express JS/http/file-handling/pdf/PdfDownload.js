const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const busboy = require('busboy');
const PDFDocument = require('pdfkit');

const app = express();

//app.use(bodyParser.json());
app.use(cors());

app.post('/api/users/file', (req, res)=> {
    const doc = new PDFDocument();
    const content = 'Sample PDF';
    doc.y = 300;
    doc.text(content, 50, 50);
    doc.pipe(res);
    doc.end();
});

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});