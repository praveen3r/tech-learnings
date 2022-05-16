const fs = require('fs');
const { stringify } = require("csv-stringify");

var someData = [
  {
      "Country": "Nigeria",
      "Population": "200m",
      "Continent": "Africa",
      "Official Language(s)": "English"
  },
  {
      "Country": "India",
      "Population": "1b",
      "Continent": "Asia",
      "Official Language(s)": "Hindi, English"
  },
  {
      "Country": "United States of America",
      "Population": "328m",
      "Continent": "North America",
      "Official Language": "English"
  },
  {
      "Country": "United Kingdom",
      "Population": "66m",
      "Continent": "Europe",
      "Official Language": "English"
  },
  {
      "Country": "Brazil",
      "Population": "209m",
      "Continent": "South America",
      "Official Language": "Portugese"
  }
];

const columns = [
    "Country",
    "Population",
    "Continent"
  ];

const writableStream = fs.createWriteStream("C:/Docs/Test/Output.csv");
const stringifier = stringify({ header: true, columns: columns });
stringifier.pipe(writableStream);
for(i=0; i<someData.length; i++) {
    stringifier.write(someData[i]);
  }
  writableStream.end;
  stringifier.end;