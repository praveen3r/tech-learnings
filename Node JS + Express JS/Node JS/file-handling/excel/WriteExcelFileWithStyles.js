const writeXlsxFile = require("write-excel-file/node");

//const file = writer.readFile('C:/Docs/Test/output.xlsx');

const data = [
  // Row #1
  [
    // Column #1
    {
      value: "Name",
      fontWeight: "bold",
    },
    // Column #2
    {
      value: "Date of Birth",
      fontWeight: "bold",
    },
    // Column #3
    {
      value: "Cost",
      fontWeight: "bold",
    },
    // Column #4
    {
      value: "Paid",
      fontWeight: "bold",
    },
  ],
  // Row #2
  [
    // Column #1
    {
      // `type` is optional
      type: String,
      value: "John Smith",
    },
    // Column #2
    {
      // `type` is optional
      type: Date,
      value: new Date(),
      format: "mm/dd/yyyy",
    },
    // Column #3
    {
      // `type` is optional
      type: Number,
      value: 1800,
    },
    // Column #4
    {
      // `type` is optional
      type: Boolean,
      value: true,
    },
  ],
  // Row #3
  [
    // Column #1
    {
      // `type` is optional
      type: String,
      value: "Alice Brown",
    },
    // Column #2
    {
      // `type` is optional
      type: Date,
      value: new Date(),
      format: "mm/dd/yyyy",
    },
    // Column #3
    {
      // `type` is optional
      type: Number,
      value: 2600,
    },
    // Column #4
    {
      // `type` is optional
      type: Boolean,
      value: false,
    },
  ],
];

try {
  writeXlsxFile(data, {
    filePath: "C:/Docs/Test/output.xlsx",
    fontFamily: 'Arial',
    fontSize: 12,
    dateFormat: 'mm/dd/yyyy',
    sheet: 'Data'
  });
  console.log(`completed`);
} catch (error) {
  console.log(error);
}
