let promise = new Promise((resolve, reject) => {
    resolve();
})

promise.then(() => {
    console.log('promise resolved');
});

let promise = new Promise((resolve, reject) => {
    reject();
})

promise.catch(() => {
    console.log('promise rejected');
});


let promise = new Promise((resolve, reject) => {
    reject();
})

promise.then(() => {
    console.log('promise resolved');
}).then(() => {
    console.log('promise resolved second time');
}).catch(() => {
    console.log('promise rejected');
});