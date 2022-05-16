const fs = require('fs');
const { format } = require('@fast-csv/format');

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

const csvFile = fs.createWriteStream("C:/Docs/Test/Output.csv");
const stream = format({ headers:true });
stream.pipe(csvFile);

for(i=0; i<someData.length; i++) {
  stream.write(someData[i]);
}

stream.end();