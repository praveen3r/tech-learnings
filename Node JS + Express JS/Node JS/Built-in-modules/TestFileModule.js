const { readFileSync, writeFileSync } = require('fs')

const fileData = readFileSync('../TestFile/file1/test.txt', {encoding: 'utf8'});
console.log(fileData);

//writeFileSync('../TestFile/file1/test-write.txt',  `Writing from Node`);
writeFileSync('../TestFile/file1/test-write.txt',  `Appending from Node`, {flag: 'a'}); //appending with existing contents