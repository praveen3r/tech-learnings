const { readFile, writeFile } = require('fs')

console.log("first task");
readFile('../TestFile/file1/test.txt', 'utf8', (err, data) => {
    if(err){
        console.log(`Error is ${err}`);
    }else{
        console.log(data);
    }
});

console.log("second task");

writeFile('../TestFile/file1/test-async.txt','New async file', (err, data) => {
    if(err){
        console.log(`Error is ${err}`);
    }else{
        console.log(data);
    }
});