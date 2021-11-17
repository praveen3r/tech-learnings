function display(){
    const year = new Date().getFullYear();
    const month = new Date().getMonth(); 

    //return `The year is ${year}`;
    //return `The year is ${year * 2}`;
    //return `The year is ${new Date().getFullYear()}`;
    return `The year is ${year} and month is ${month}`;
}

console.log(display());
