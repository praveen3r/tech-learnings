function checkValueExists(value){
    return value !== null && value !== void 0;
}

console.log(checkValueExists(""));
console.log(checkValueExists(null));
console.log(checkValueExists(undefined));
console.log(checkValueExists("12"));

//Check if String value is present
function convertStringToNumber(){
//const myVar1 = "123"; 
//const myVar1 = undefined; 
//const myVar1 = null; 
//const myVar1 = ""; 
//const myVar1 = "123abg"; 
//const myVar1 = ""; 
const myInt2 = +myVar1; 
const myInt3 = parseInt(myVar1, 10); 
const myInt4 = Number(myVar1)
const myInt5 = Number.parseInt(myVar1, 10); 

console.log(myInt2);
console.log(myInt3);
console.log(myInt4);
console.log(myInt5);
//console.log(Number.isNaN(myInt2));
//console.log(Number.isInteger(k1));
}
