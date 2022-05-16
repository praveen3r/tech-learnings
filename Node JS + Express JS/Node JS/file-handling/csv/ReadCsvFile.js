const csv = require('csv-parser');
const fs = require('fs');

fs.createReadStream("C:/Docs/Test/test.csv")
  .pipe(csv({ delimiter: ",", from_line: 2 }))
  .on("data", function (row) {
    console.log(row);
  })
  .on("end", function () {
    console.log("finished");
  })
  .on("error", function (error) {
    console.log(error.message);
  });