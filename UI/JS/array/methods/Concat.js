//const new_array = old_array.concat([value1[, value2[, ...[, valueN]]]])

/*
The concat() method is used to merge two or more arrays. This method does not change the 
existing arrays, but instead returns a new array.
*/

//--------------------------Concatenating two arrays----------------------------

const array1 = ['a', 'b', 'c'];
const array2 = ['d', 'e', 'f'];
const array3 = array1.concat(array2);

console.log(array3);


//--------------------------Concatenating three arrays---------------------------

const num1 = [1, 2, 3];
const num2 = [4, 5, 6];
const num3 = [7, 8, 9];

const numbers = num1.concat(num2, num3);

console.log(numbers); 
// results in [1, 2, 3, 4, 5, 6, 7, 8, 9]

//-----------------------Concatenating values to an array---------------------

const letters = ['a', 'b', 'c'];

const alphaNumeric = letters.concat(1, [2, 3]);

console.log(alphaNumeric); 
// results in ['a', 'b', 'c', 1, 2, 3]

//----------------------Concatenating nested arrays----------------------------

const num1 = [[1]];
const num2 = [2, [3]];

const numbers = num1.concat(num2);

console.log(numbers);
// results in [[1], 2, [3]]

// modify the first element of num1
num1[0].push(4);

console.log(numbers);
// results in [[1, 4], 2, [3]]

//-------------------------------------------------------------------