//arr.join([separator])

/*
The join() method creates and returns a new string by concatenating all of the elements in an 
array (or an array-like object), separated by commas or a specified separator string. If the array 
has only one item, then that item will be returned without using the separator.
*/

//------------------------Joining an array four different ways---------------------------

var a = ['Wind', 'Water', 'Fire'];
a.join();      // 'Wind,Water,Fire'
a.join(', ');  // 'Wind, Water, Fire'
a.join(' + '); // 'Wind + Water + Fire'
a.join('');    // 'WindWaterFire'


//---------------------Joining an array-like object----------------------------------------

function f(a, b, c) {
    var s = Array.prototype.join.call(arguments);
    console.log(s); // '1,a,true'
  }
  f(1, 'a', true);
  //expected output: "1,a,true"

//-----------------------Computed index is less than 0---------------------------------------------

/*
If fromIndex is negative, the computed index is calculated to be used as a position in the array 
at which to begin searching for valueToFind. If the computed index is less or equal than -1 * arr.length
, the entire array will be searched.
*/

// array length is 3
// fromIndex is -100
// computed index is 3 + (-100) = -97

let arr = ['a', 'b', 'c']

arr.includes('a', -100) // true
arr.includes('b', -100) // true
arr.includes('c', -100) // true
arr.includes('a', -2)   // false

//-----------------------includes() used as a generic method------------------------------------------

/*
includes() method is intentionally generic. It does not require this value to be an Array object, so it 
can be applied to other kinds of objects (e.g. array-like objects).

The example below illustrates includes() method called on the function's arguments object.
*/

(function() {
     console.log([].includes.call(arguments, 'a'))  // true
     console.log([].includes.call(arguments, 'd'))  // false
   })('a','b','c') 
