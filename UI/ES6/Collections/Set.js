/*
The Set object lets you store unique values of any type, whether primitive values or object references.

Set objects are collections of values. You can iterate through the elements of a set in insertion order. 
A value in the Set may only occur once; it is unique in the Set's collection.

Value equality
--------------

Because each value in the Set has to be unique, the value equality will be checked. 
In an earlier version of ECMAScript specification, this was not based on the same algorithm as the one
 used in the === operator. Specifically, for Sets, +0 (which is strictly equal to -0) and -0 were 
 different values. However, this was changed in the ECMAScript 2015 specification. See "Key equality 
 for -0 and 0" in the browser compatibility table for details.

NaN and undefined can also be stored in a Set. All NaN values are equated (i.e. NaN is considered 
the same as NaN, even though NaN !== NaN).
*/

//--------------------------size-----------------------------------------------------------

/*
The size accessor property returns the number of (unique) elements in a Set object.

*/
const set1 = new Set();
const object1 = new Object();

set1.add(42);
set1.add('forty two');
set1.add('forty two');
set1.add(object1);

console.log(set1.size);
// expected output: 3


//--------------------------clear---------------------------------------------------------

/*
The clear() method removes all elements from a Set object.
*/

const set1 = new Set();
set1.add(1);
set1.add('foo');

console.log(set1.size);
// expected output: 2

set1.clear();

console.log(set1.size);
// expected output: 0


//--------------------------delete---------------------------------------------------------

/*
The delete() method removes the specified element from a Set object.
*/

const set1 = new Set();
set1.add({x: 10, y: 20}).add({x: 20, y: 30});

// Delete any point with `x > 10`.
set1.forEach(function(point){
  if (point.x > 10) {
    set1.delete(point);
  }
});

console.log(set1.size);
// expected output: 1

//--------------------------entries---------------------------------------------------------

/*
The entries() method returns a new Iterator object that contains an array of [value, value] 
for each element in the Set object, in insertion order. For Set objects there is no key like
in Map objects. However, to keep the API similar to the Map object, each entry has the same 
value for its key and value here, so that an array [value, value] is returned.
*/

const set1 = new Set();
set1.add(42);
set1.add('forty two');

const iterator1 = set1.entries();

for (let entry of iterator1) {
  console.log(entry);
  // expected output: [42, 42]
  // expected output: ["forty two", "forty two"]
}

//--------------------------forEach---------------------------------------------------------

/*
The forEach() method executes a provided function once for each value in the 
Set object, in insertion order.

The forEach() method executes the provided callback once for each value which 
actually exists in the Set object. It is not invoked for values which have been
deleted. However, it is executed for values which are present but have the value undefined.

callback is invoked with three arguments:

the element value
the element key
the Set object being traversed

There are no keys in Set objects, however, so the first two arguments are both 
values contained in the Set. This is to make it consistent with other forEach() 
methods for Map and Array.

If a thisArg parameter is provided to forEach(), it will be passed to callback 
when invoked, for use as its this value.  Otherwise, the value undefined will be 
passed for use as its this value.  The this value ultimately observable by callback 
is determined according to the usual rules for determining the this seen by a function.

Each value is visited once, except in the case when it was deleted and re-added before 
forEach() has finished. callback is not invoked for values deleted before being visited. 
New values added before forEach() has finished will be visited.

forEach() executes the callback function once for each element in the Set object; it 
does not return a value.
*/

function logSetElements(value1, value2, set) {
  console.log('s[' + value1 + '] = ' + value2);
}

new Set(['foo', 'bar', undefined]).forEach(logSetElements);

// logs:
// "s[foo] = foo"
// "s[bar] = bar"
// "s[undefined] = undefined"

//--------------------------has---------------------------------------------------------

/*
The has() method returns a boolean indicating whether an element with the specified key exists or not.
*/

var mySet = new Set();
mySet.add('foo');

mySet.has('foo');  // returns true
mySet.has('bar');  // returns false

var set1 = new Set();
var obj1 = {'key1': 1};
set1.add(obj1);

set1.has(obj1);        // returns true
set1.has({'key1': 1}); // returns false because they are different object references
set1.add({'key1': 1}); // now set1 contains 2 entries

//--------------------------add---------------------------------------------------------

/*
The add() method appends a new element with a specified value to the end of a Set object.
*/

const set1 = new Set();

set1.add(42);
set1.add(42);
set1.add(13);

for (let item of set1) {
  console.log(item);
  // expected output: 42
  // expected output: 13
}

//--------------------------values---------------------------------------------------------

/*
The values() method returns a new Iterator object that contains the values for each element 
in the Set object in insertion order.

The keys() method is an alias for this method (for similarity with Map objects); it behaves 
exactly the same and returns values of Set elements.
*/

const set1 = new Set();
set1.add(42);
set1.add('forty two');

const iterator1 = set1.values();

console.log(iterator1.next().value);
// expected output: 42

console.log(iterator1.next().value);
// expected output: "forty two"

//--------------------------iterator---------------------------------------------------------

/*
The initial value of the @@iterator property is the same function object as the initial 
value of the values property.

*/

const set1 = new Set();

set1.add(42);
set1.add('forty two');

const iterator1 = set1[Symbol.iterator]();

console.log(iterator1.next().value);
// expected output: 42

console.log(iterator1.next().value);
// expected output: "forty two"


//--------------------------Remove duplicate elements from the array---------------------------------------------------------

// Use to remove duplicate elements from the array 

const numbers = [2,3,4,4,2,3,3,4,4,5,5,6,6,7,5,32,3,4,5]

console.log([...new Set(numbers)]) 

// [2, 3, 4, 5, 6, 7, 32]

//--------------------------Implementing basic set operations---------------------------------------------------------

function isSuperset(set, subset) {
  for (let elem of subset) {
      if (!set.has(elem)) {
          return false
      }
  }
  return true
}

function union(setA, setB) {
  let _union = new Set(setA)
  for (let elem of setB) {
      _union.add(elem)
  }
  return _union
}

function intersection(setA, setB) {
  let _intersection = new Set()
  for (let elem of setB) {
      if (setA.has(elem)) {
          _intersection.add(elem)
      }
  }
  return _intersection
}

function symmetricDifference(setA, setB) {
  let _difference = new Set(setA)
  for (let elem of setB) {
      if (_difference.has(elem)) {
          _difference.delete(elem)
      } else {
          _difference.add(elem)
      }
  }
  return _difference
}

function difference(setA, setB) {
  let _difference = new Set(setA)
  for (let elem of setB) {
      _difference.delete(elem)
  }
  return _difference
}

// Examples
let setA = new Set([1, 2, 3, 4])
let setB = new Set([2, 3])
let setC = new Set([3, 4, 5, 6])

isSuperset(setA, setB)          // => true
union(setA, setC)               // => Set [1, 2, 3, 4, 5, 6]
intersection(setA, setC)        // => Set [3, 4]
symmetricDifference(setA, setC) // => Set [1, 2, 5, 6]
difference(setA, setC)          // => Set [1, 2]

