var arr = [];
arr[0] = "test";
arr[1] = true;
arr[2] = 0;
arr[10] = 10;

//Array.from(arrayLike [, mapFn [, thisArg]])

/* 
The Array.from() method creates a new, shallow-copied Array instance from an array-like or 
iterable object.

Array.from() lets you create Arrays from:

array-like objects (objects with a length property and indexed elements); or
iterable objects (objects such as Map and Set).
Array.from() has an optional parameter mapFn, which allows you to execute a map() function on each element of the array being created.

More clearly, Array.from(obj, mapFn, thisArg)
has the same result as Array.from(obj).map(mapFn, thisArg),
except that it does not create an intermediate array.

*/

//--------------------Array from a String-----------------------------------------------

Array.from('foo'); 

// [ "f", "o", "o" ]

//--------------------Array from a Set-----------------------------------------------

const set = new Set(['foo', 'bar', 'baz', 'foo']);
Array.from(set);
// [ "foo", "bar", "baz" ]

//--------------------Array from a Map-----------------------------------------------

const map = new Map([[1, 2], [2, 4], [4, 8]]);
Array.from(map);
// [[1, 2], [2, 4], [4, 8]]

const mapper = new Map([['1', 'a'], ['2', 'b']]);
Array.from(mapper.values());
// ['a', 'b'];

Array.from(mapper.keys());
// ['1', '2'];

//--------------------Array from an Array-like object (arguments)------------------------

function f() {
    return Array.from(arguments);
  }
  
  f(1, 2, 3);
  
  // [ 1, 2, 3 ]

//--------------------Using arrow functions and Array.from()------------------------

// Using an arrow function as the map function to
// manipulate the elements
Array.from([1, 2, 3], x => x + x);      
// [2, 4, 6]


// Generate a sequence of numbers
// Since the array is initialized with `undefined` on each position,
// the value of `v` below will be `undefined`
Array.from({length: 5}, (v, i) => i);
// [0, 1, 2, 3, 4]

//--------------------Using arrow functions and Array.from()------------------------

// Sequence generator function (commonly referred to as "range", e.g. Clojure, PHP etc)
const range = (start, stop, step) => Array.from({ length: (stop - start) / step + 1}, (_, i) => start + (i * step));

// Generate numbers range 0..4
range(0, 4, 1);
// [0, 1, 2, 3, 4] 

// Generate numbers range 1..10 with step of 2 
range(1, 10, 2); 
// [1, 3, 5, 7, 9]

// Generate the alphabet using Array.from making use of it being ordered as a sequence
range('A'.charCodeAt(0), 'Z'.charCodeAt(0), 1).map(x => String.fromCharCode(x));
// ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]


