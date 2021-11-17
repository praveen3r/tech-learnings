/*
The Map object holds key-value pairs and remembers the original insertion order of the keys. 
Any value (both objects and primitive values) may be used as either a key or a value.

A Map object iterates its elements in insertion order — a for...of loop returns an array of 
[key, value] for each iteration.

*/

//--------------------------size----------------------------------------------

/*
Returns the number of key/value pairs in the Map object.

The value of size is an integer representing how many entries the Map object has. 
A set accessor function for size is undefined; you can not change this property.

*/
var myMap = new Map();
myMap.set('a', 'alpha');
myMap.set('b', 'beta');
myMap.set('g', 'gamma');

myMap.size // 3


//--------------------------clear---------------------------------------------------------

/*
The clear() method removes all elements from a Map object.
*/

var myMap = new Map();
myMap.set('bar', 'baz');
myMap.set(1, 'foo');

myMap.size;       // 2
myMap.has('bar'); // true

myMap.clear();

myMap.size;       // 0
myMap.has('bar')  // false

//--------------------------delete---------------------------------------------------------

/*
The delete() method removes the specified element from a Map object by key.
*/

var myMap = new Map();
myMap.set('bar', 'foo');

myMap.delete('bar'); // Returns true. Successfully removed.
myMap.has('bar');    // Returns false. The "bar" element is no longer present.

//--------------------------entries---------------------------------------------------------

/*
The entries() method returns a new Iterator object that contains the [key, value] pairs for 
each element in the Map object in insertion order.
*/

let myMap = new Map()
myMap.set('0', 'foo')
myMap.set(1, 'bar')
myMap.set({}, 'baz')

let mapIter = myMap.entries()

console.log(mapIter.next().value)  // ["0", "foo"]
console.log(mapIter.next().value)  // [1, "bar"]
console.log(mapIter.next().value)  // [Object, "baz"]

//--------------------------forEach---------------------------------------------------------

/*
The forEach() method executes a provided function once per each key/value pair in the Map object, 
in insertion order.

The forEach method executes the provided callback once for each key of the map which actually exist.
It is not invoked for keys which have been deleted. However, it is executed for values which are 
present but have the value undefined.

callback is invoked with three arguments:

the element's value
the element key
the Map object being traversed

If a thisArg parameter is provided to forEach, it will be passed to callback when invoked,
 for use as its this value.  Otherwise, the value undefined will be passed for use as its this value.
 The this value ultimately observable by callback is determined according to the usual rules for 
 determining the this seen by a function.

Each value is visited once, except in the case when it was deleted and re-added before forEach has 
finished. callback is not invoked for values deleted before being visited. New values added before 
forEach has finished will be visited.

forEach executes the callback function once for each element in the Map object. It does not return 
a value.
*/

function logMapElements(value, key, map) {
    console.log(`m[${key}] = ${value}`);
  }
  
  new Map([['foo', 3], ['bar', {}], ['baz', undefined]])
    .forEach(logMapElements);
  
  // expected output: "m[foo] = 3"
  // expected output: "m[bar] = [object Object]"
  // expected output: "m[baz] = undefined"

//--------------------------get---------------------------------------------------------

/*
The get() method returns a specified element from a Map object.
*/

let myMap = new Map()
myMap.set('bar', 'foo')

myMap.get('bar')   // Returns "foo"
myMap.get('baz')   // Returns undefined

//--------------------------has---------------------------------------------------------

/*
The has() method returns a boolean indicating whether an element with the specified key exists or not.
*/

let myMap = new Map()
myMap.set('bar', "foo")

myMap.has('bar')   // returns true
myMap.has('baz')   // returns false

//--------------------------keys---------------------------------------------------------

/*
The keys() method returns a new Iterator object that contains the keys for each element
in the Map object in insertion order.
*/

var myMap = new Map();
myMap.set('0', 'foo');
myMap.set(1, 'bar');
myMap.set({}, 'baz');

var mapIter = myMap.keys();

console.log(mapIter.next().value); // "0"
console.log(mapIter.next().value); // 1
console.log(mapIter.next().value); // Object

//--------------------------set---------------------------------------------------------

/*
The set() method adds or updates an element with a specified key and a value to a Map object.
*/

let myMap = new Map()

// Add new elements to the map
myMap.set('bar', 'foo')
myMap.set(1, 'foobar')

// Update an element in the map
myMap.set('bar', 'baz')

// Add new elements to the map with chaining. 
myMap.set('bar', 'foo')
     .set(1, 'foobar')
     .set(2, 'baz');

//--------------------------values---------------------------------------------------------

/*
The values() method returns a new Iterator object that contains the values for each
 element in the Map object in insertion order.
*/

var myMap = new Map();
myMap.set('0', 'foo');
myMap.set(1, 'bar');
myMap.set({}, 'baz');

var mapIter = myMap.values();

console.log(mapIter.next().value); // "foo"
console.log(mapIter.next().value); // "bar"
console.log(mapIter.next().value); // "baz"

//--------------------------iterator---------------------------------------------------------

/*
The initial value of the @@iterator property is the same function object as the initial 
value of the entries method.
*/

const myMap = new Map()
myMap.set('0', 'foo')
myMap.set(1, 'bar')
myMap.set({}, 'baz')

const mapIter = myMap[Symbol.iterator]()

console.log(mapIter.next().value) // ["0", "foo"]
console.log(mapIter.next().value) // [1, "bar"]
console.log(mapIter.next().value) // [Object, "baz"]

//Using for..of

const myMap = new Map()
myMap.set('0', 'foo')
myMap.set(1, 'bar')
myMap.set({}, 'baz')

for (const entry of myMap) {
  console.log(entry)
}
// ["0", "foo"]
// [1, "bar"]
// [{}, "baz"]

for (const [key, value] of myMap) {
  console.log(`${key}: ${value}`)
}
// 0: foo
// 1: bar
// [Object]: baz
Specification

//--------------------------Cloning Maps---------------------------------------------------------

let original = new Map([
    [1, 'one']
  ])
  
  let clone = new Map(original)
  
  console.log(clone.get(1))       // one
  console.log(original === clone) // false (useful for shallow comparison)

//--------------------------Merging---------------------------------------------------------

let first = new Map([
    [1, 'one'],
    [2, 'two'],
    [3, 'three'],
  ])
  
  let second = new Map([
    [1, 'uno'],
    [2, 'dos']
  ])
  
  // Merge two maps. The last repeated key wins.
  // Spread operator essentially converts a Map to an Array
  let merged = new Map([...first, ...second])
  
  console.log(merged.get(1)) // uno
  console.log(merged.get(2)) // dos
  console.log(merged.get(3)) // three

//--------------------------Merging With Arrays------------------------------------------------

let first = new Map([
    [1, 'one'],
    [2, 'two'],
    [3, 'three'],
  ])
  
  let second = new Map([
    [1, 'uno'],
    [2, 'dos']
  ])
  
  // Merge maps with an array. The last repeated key wins.
  let merged = new Map([...first, ...second, [1, 'eins']])
  
  console.log(merged.get(1)) // eins
  console.log(merged.get(2)) // dos
  console.log(merged.get(3)) // three

//--------------------------Side Note---------------------------------------------------------

/* Beware! Setting Object properties works for Map objects as well, and can cause 
considerable confusion.

Therefore, this still sort-of works....*/

let wrongMap = new Map()
wrongMap['bla'] = 'blaa'
wrongMap['bla2'] = 'blaaa2'

console.log(wrongMap)  // Map { bla: 'blaa', bla2: 'blaaa2' }

// ...But, it does not behave as expected:

wrongMap.has('bla')    // false
wrongMap.delete('bla') // false
console.log(wrongMap)  // Map { bla: 'blaa', bla2: 'blaaa2' }

// And there's very little difference from the correct usage, anyway:

let myMap = new Map()
myMap.set('bla','blaa')
myMap.set('bla2','blaa2')
console.log(myMap)  // Map { 'bla' => 'blaa', 'bla2' => 'blaa2' }

myMap.has('bla')    // true
myMap.delete('bla') // true
console.log(myMap)  // Map { 'bla2' => 'blaa2' }

     