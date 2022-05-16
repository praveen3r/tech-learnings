const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const XLSX = require("xlsx");
var Readable = require('stream').Readable; 

const app = express();

//app.use(bodyParser.json());
app.use(cors());

function bufferToStream(buffer) { 
  var stream = new Readable();
  stream.push(buffer);
  stream.push(null);

  return stream;
}

app.post("/api/users/file", (req, res) => {
  const workbook = XLSX.utils.book_new();
  // Sample data set
  let test_data = [{
     id: 1,
     name:'Nikhil',
     Age:22
  },
  {
     id: 2,
     name:'Shree',
     Age:21,
  }]
  
  const ws = XLSX.utils.json_to_sheet(test_data);
   
  XLSX.utils.book_append_sheet(workbook, ws,"sheet1");

  const wbOpts = { bookType: "xlsx", type: "buffer" };
  const wbOut = XLSX.write(workbook, wbOpts);

  const stream = bufferToStream(wbOut);                // convert buffer to stream
  stream.pipe(res);  


});

app.listen(5000, () => {
  console.log(`server started in port 5000`);
});
