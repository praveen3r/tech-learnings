const { readFile, writeFile } = require('fs');

const getFileData = (path) => {
    return new Promise((resolve, reject) => {
        readFile(path, 'utf8', (err, data) => {
            if(err){
                reject(err);
            }else{
                resolve(data);
            }
        });
    });
}

getFileData('../TestFile/file1/test.txt').then(result => console.log(result)).catch(err => console.log(err));