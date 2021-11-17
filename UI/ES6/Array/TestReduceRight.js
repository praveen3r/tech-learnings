//arr.reduceRight(callback(accumulator, currentValue[, index[, array]])[, initialValue])

/*
The reduceRight() method applies a function against an accumulator and each value of the array 
(from right-to-left) to reduce it to a single value.

reduceRight executes the callback function once for each element present in the array, excluding holes in the array, receiving four arguments: the initial value (or value from the previous callback call), the value of the current element, the current index, and the array over which iteration is occurring.

The call to the reduceRight callback would look something like this:

array.reduceRight(function(accumulator, currentValue, index, array) {
  // ...
});
The first time the function is called, the accumulator and currentValue can be one of two values. If an initialValue was provided in the call to reduceRight, then accumulator will be equal to initialValue and currentValue will be equal to the last value in the array. If no initialValue was provided, then accumulator will be equal to the last value in the array and currentValue will be equal to the second-to-last value.

If the array is empty and no initialValue was provided, TypeError would be thrown. If the array has only one element (regardless of position) and no initialValue was provided, or if initialValue is provided but the array is empty, the solo value would be returned without calling callback.

Some example run-throughs of the function would look like this:

[0, 1, 2, 3, 4].reduceRight(function(accumulator, currentValue, index, array) {
  return accumulator + currentValue;
});
The callback would be invoked four times, with the arguments and return values in each call being as follows:

callback	accumulator	currentValue	index	array	          return value
first call	    4	        3	          3	   [0, 1, 2, 3, 4]	       7
second call	    7	        2	          2	   [0, 1, 2, 3, 4]	       9
third call	    9	        1	          1	   [0, 1, 2, 3, 4]	       10
fourth call	    10	        0	          0	   [0, 1, 2, 3, 4]	       10

The value returned by reduceRight would be that of the last callback invocation (10).

And if you were to provide an initialValue, the result would look like this:

[0, 1, 2, 3, 4].reduceRight(function(accumulator, currentValue, index, array) {
  return accumulator + currentValue;
}, 10);
callback	accumulator	currentValue	index	array	           return value
first call	   10	        4	          4	   [0, 1, 2, 3, 4]	      14
second call	   14	        3	          3	   [0, 1, 2, 3, 4]	      17
third call	   17	        2	          2	   [0, 1, 2, 3, 4]	      19
fourth call	   19	        1	          1	   [0, 1, 2, 3, 4]	      20
fifth call	   20	        0	          0	   [0, 1, 2, 3, 4]	      20

The value returned by reduceRight this time would be, of course, 20.

*/

//--------------------------Sum up all values within an array----------------------------

var sum = [0, 1, 2, 3].reduceRight(function(a, b) {
    return a + b;
  });
  // sum is 6


//---------------------Flatten an array of arrays-----------------------------------------

var flattened = [[0, 1], [2, 3], [4, 5]].reduceRight(function(a, b) {
    return a.concat(b);
}, []);
// flattened is [4, 5, 2, 3, 0, 1]

//---Run a list of asynchronous functions with callbacks in series each passing their results to the next

const waterfall = (...functions) => (callback, ...args) =>
  functions.reduceRight(
    (composition, fn) => (...results) => fn(composition, ...results),
    callback
  )(...args);

const randInt = max => Math.floor(Math.random() * max)

const add5 = (callback, x) => {
  setTimeout(callback, randInt(1000), x + 5);
};
const mult3 = (callback, x) => {
  setTimeout(callback, randInt(1000), x * 3);
};
const sub2 = (callback, x) => {
  setTimeout(callback, randInt(1000), x - 2);
};
const split = (callback, x) => {
  setTimeout(callback, randInt(1000), x, x);
};
const add = (callback, x, y) => {
  setTimeout(callback, randInt(1000), x + y);
};
const div4 = (callback, x) => {
  setTimeout(callback, randInt(1000), x / 4);
};

const computation = waterfall(add5, mult3, sub2, split, add, div4);
computation(console.log, 5) // -> 14

// same as:

const computation2 = (input, callback) => {
  const f6 = x=> div4(callback, x);
  const f5 = (x, y) => add(f6, x, y);
  const f4 = x => split(f5, x);
  const f3 = x => sub2(f4, x);
  const f2 = x => mult3(f3, x);
  add5(f2, input);
}

//----------------------Difference between reduce and reduceRight----------------------------

var a = ['1', '2', '3', '4', '5']; 
var left  = a.reduce(function(prev, cur)      { return prev + cur; }); 
var right = a.reduceRight(function(prev, cur) { return prev + cur; }); 

console.log(left);  // "12345"
console.log(right); // "54321"

//----------------------Defining Composible Function----------------------------

/**
 * Function Composition is way in which result of one function can
 * be passed to another and so on.
 *
 * h(x) = f(g(x))
 *
 * Function execution happens right to left
 *
 * https://en.wikipedia.org/wiki/Function_composition
 */

const compose = (...args) => (value) => args.reduceRight((acc, fn) => fn(acc), value)

// Increment passed number
const inc = (n) => n + 1

// Doubles the passed value
const double = (n) => n * 2

// using composition function
console.log(compose(double, inc)(2)); // 6

// using composition function
console.log(compose(inc, double)(2)); // 5



