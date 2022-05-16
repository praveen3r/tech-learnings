const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const CsvParser = require("json2csv").Parser;
var Readable = require('stream').Readable; 

const app = express();

//app.use(bodyParser.json());
app.use(cors());

app.post("/api/users/file", (req, res) => {
  const data = [{"id":1, "title": "test1", "desc": "test1"},{"id":2, "title": "test2", "desc": "test2"}];
  const csvFields = ["Id", "Title", "Description"];
    //const csvParser = new CsvParser({ csvFields });
    const csvParser = new CsvParser({header:false});
    const csvData = csvParser.parse(data);
    res.status(200).end(csvData);

});

app.listen(5000, () => {
  console.log(`server started in port 5000`);
});
