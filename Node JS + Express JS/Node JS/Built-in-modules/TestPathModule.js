const path = require('path')

console.log(path.sep)

const filePath = path.join('../TestFile','file1','test.txt');
console.log(filePath);

console.log(path.basename(filePath));

const absolutePath = path.resolve(__dirname, 'test','test1','test.txt');
console.log(absolutePath);
