const fs = require('fs');
const fastCsv = require("fast-csv");

const options = {
  objectMode: true,
  delimiter: ",",
  quote: null,
  headers: false,
  renameHeaders: false,
};

const data = [];

fs.createReadStream("C:/Docs/Test/test.csv")
  .pipe(fastCsv.parse(options))
  .on("error", (error) => {
    console.log(error);
  })
  .on("data", (row) => {
    data.push(row);
  })
  .on("end", (rowCount) => {
    console.log(rowCount);
    console.log(data);
  });