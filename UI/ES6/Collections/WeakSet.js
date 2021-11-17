/*
The WeakSet object lets you store weakly held objects in a collection.

WeakSet objects are collections of objects. An object in the WeakSet may occur only once;
it is unique in the WeakSet's collection.

The main differences to the Set object are:

In contrast to Sets, WeakSets are collections of objects only and not of arbitrary values of any type.
The WeakSet is weak: References to objects in the collection are held weakly. If there is no 
other reference to an object stored in the WeakSet, they can be garbage collected. That also 
means that there is no list of current objects stored in the collection. WeakSets are not enumerable.
Detecting circular references
Functions that call themselves recursively need a way of guarding against circular data structures 
by tracking which objects have already been processed. WeakSets are ideal for this purpose:

// Execute a callback on everything stored inside an object
function execRecursively(fn, subject, _refs = null){
	if(!_refs)
		_refs = new WeakSet();
	
	// Avoid infinite recursion
	if(_refs.has(subject))
		return;

	fn(subject);
	if("object" === typeof subject){
		_refs.add(subject);
		for(let key in subject)
			execRecursively(fn, subject[key], _refs);
	}
}

const foo = {
	foo: "Foo",
	bar: {
		bar: "Bar"
	}
};

foo.bar.baz = foo; // Circular reference!
execRecursively(obj => console.log(obj), foo);
Here, a WeakSet is created on the first run, and passed along with every subsequent function call 
(using the internal _refs parameter). The number of objects or their traversal order is immaterial, 
so a WeakSet is more suitable (and performant) than a Set for tracking object references, especially 
if a very large number of objects is involved.
*/

//--------------------------delete----------------------------------------------

/*
The delete() method removes the specified element from a WeakSet object.

*/
const weakset1 = new WeakSet();
const object1 = {};

weakset1.add(object1);

console.log(weakset1.has(object1));
// expected output: true

weakset1.delete(object1);

console.log(weakset1.has(object1));
// expected output: false


//--------------------------add---------------------------------------------------------

/*
The add() method appends a new object to the end of a WeakSet object.
*/

const weakset1 = new WeakSet();
const object1 = {};

weakset1.add(object1);
console.log(weakset1.has(object1));
// expected output: true

try {
  weakset1.add(1);
} catch(error) {
  console.log(error);
  // expected output: "Error: Invalid value used in weak set" in Chrome
  // expected output: "TypeError: WeakSet value must be an object, got the number 1" in Firefox
}


//--------------------------has---------------------------------------------------------

/*
The has() method returns a boolean indicating whether an object exists in a
WeakSet or not.
*/

const weakset1 = new WeakSet();
const object1 = {};
const object2 = {};

weakset1.add(object1);

console.log(weakset1.has(object1));
// expected output: true

console.log(weakset1.has(object2));
// expected output: false


