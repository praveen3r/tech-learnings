//arr.slice([begin[, end]])

/*
The slice() method returns a shallow copy of a portion of an array into a new array object selected 
from begin to end (end not included) where begin and end represent the index of items in that array.
 The original array will not be modified.

 slice does not alter the original array. It returns a shallow copy of elements from the original array. 
 Elements of the original array are copied into the returned array as follows:

For object references (and not the actual object), slice copies object references into the new array.
 Both the original and new array refer to the same object. If a referenced object changes, the changes
  are visible to both the new and original arrays.

For strings, numbers and booleans (not String, Number and Boolean objects), slice copies the values
 into the new array. Changes to the string, number, or boolean in one array do not affect the other 
 array.

If a new element is added to either array, the other array is not affected.

*/

//--------------------------Return a portion of an existing array----------------------------

let fruits = ['Banana', 'Orange', 'Lemon', 'Apple', 'Mango']
let citrus = fruits.slice(1, 3)

// fruits contains ['Banana', 'Orange', 'Lemon', 'Apple', 'Mango']
// citrus contains ['Orange','Lemon']

//------------------------Using slice-----------------------------------------------------

// Using slice, create newCar from myCar.
let myHonda = { color: 'red', wheels: 4, engine: { cylinders: 4, size: 2.2 } }
let myCar = [myHonda, 2, 'cherry condition', 'purchased 1997']
let newCar = myCar.slice(0, 2)

// Display the values of myCar, newCar, and the color of myHonda
//  referenced from both arrays.
console.log('myCar = ' + JSON.stringify(myCar))
console.log('newCar = ' + JSON.stringify(newCar))
console.log('myCar[0].color = ' + myCar[0].color)
console.log('newCar[0].color = ' + newCar[0].color)

// Change the color of myHonda.
myHonda.color = 'purple'
console.log('The new color of my Honda is ' + myHonda.color)

// Display the color of myHonda referenced from both arrays.
console.log('myCar[0].color = ' + myCar[0].color)
console.log('newCar[0].color = ' + newCar[0].color)

//------------------------Array-like objects-------------------------------------

function list() {
    return Array.prototype.slice.call(arguments)
  }
  
  let list1 = list(1, 2, 3) // [1, 2, 3]

let unboundSlice = Array.prototype.slice
let slice = Function.prototype.call.bind(unboundSlice)

function list() {
  return slice(arguments)
}

let list1 = list(1, 2, 3) // [1, 2, 3]