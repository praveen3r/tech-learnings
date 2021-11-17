//array.entries()

/*
The entries() method returns a new Array Iterator object that contains the key/value pairs 
for each index in the array.
*/

//----------------------Iterating with index and element------------------------

const a = ['a', 'b', 'c'];

for (const [index, element] of a.entries())
  console.log(index, element);

// 0 'a' 
// 1 'b' 
// 2 'c'

//------------------------Using a for…of loop------------------------------------

var a = ['a', 'b', 'c'];
var iterator = a.entries();

for (let e of iterator) {
  console.log(e);
}
// [0, 'a']
// [1, 'b']
// [2, 'c']

//-------------------------------------------------------------------

//Concatenating values to an array
const letters = ['a', 'b', 'c'];

const alphaNumeric = letters.concat(1, [2, 3]);

console.log(alphaNumeric); 
// results in ['a', 'b', 'c', 1, 2, 3]

//-------------------------------------------------------------------

//Concatenating nested arrays
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