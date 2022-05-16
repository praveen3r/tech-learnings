const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const busboy = require("busboy");
const readXlsxFile = require("read-excel-file/node");
const XLSX = require("xlsx");

const app = express();

//app.use(bodyParser.json());
app.use(cors());

app.post("/api/users/file", (req, res) => {
  console.log(`coming here`);
  try {
    const bb = busboy({
      headers: req.headers,
    });
    let workbook;
    bb.on("file", (name, file, info) => {
      //file.setEncoding('utf8');
      const buffers = [];
      const { filename, encoding, mimeType } = info;
      console.log(
        `File [${name}]: filename: %j, encoding: %j, mimeType: %j`,
        filename,
        encoding,
        mimeType
      );
      file
        .on("data", (data) => {
          buffers.push(data);
        })
        .on("close", () => {
          console.log(`File [${name}] done`);
        });
   
    file.on("end", () => {
      buffer = Buffer.concat(buffers);

      workbook = XLSX.read(buffer, {
        type: "buffer",
      });
      console.log(`end of file`);
    });
  });
  bb.on("finish", () => {
      try {
        const excelProducts = XLSX.utils.sheet_to_json(
          workbook.Sheets[workbook.SheetNames[0]],
          {
            raw: false,
            header: 1,
            dateNF: "yyyy-mm-dd",
            blankrows: false,
          }
        );
        console.log(`finish`);
        console.log(excelProducts);
      } catch (err) {
        console.log(err);
      }
    });
    bb.on("field", (name, val, info) => {
      console.log(`Field [${name}]: value: %j`, val);
    });
    bb.on("close", () => {
      console.log("Done parsing form!");
      // res.writeHead(303, { Connection: 'close', Location: '/' });
      res.end();
    });
    req.pipe(bb);
  } catch (err) {
    console.log(err);
  }
});

app.listen(5000, () => {
  console.log(`server started in port 5000`);
});
