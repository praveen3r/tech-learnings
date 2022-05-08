const { readFile, writeFile } = require('fs')

const getFileData = (path) => {
    return new Promise((resolve, reject) => {
        readFile(path, 'utf8', (err, data) => {
            if (err) {
                reject(err);
            } else {
                resolve(data);
            }
        });
    });
}

const start = async () => {
    try {
        const first = await getFileData('../TestFile/file1/test.txt');
        const second = await getFileData('../TestFile/file1/test-async.txt');
        console.log(first);
        console.log(second);
    }
    catch (error) {
        console.error(error);
    }
}

start();
