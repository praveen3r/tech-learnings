/*
The WeakMap object is a collection of key/value pairs in which the keys are weakly referenced. 
The keys must be objects and the values can be arbitrary values.

Keys of WeakMaps are of the type Object only. Primitive data types as keys are not allowed
 (e.g. a Symbol can't be a WeakMap key).

 A map API could be implemented in JavaScript with two arrays (one for keys, one for values)
 shared by the four API methods. Setting elements on this map would involve pushing a key and
 value onto the end of each of those arrays simultaneously. As a result, the indices of the key
  and value would correspond to both arrays. Getting values from the map would involve iterating
   through all keys to find a match, then using the index of this match to retrieve the corresponding
 value from the array of values.

Such an implementation would have two main inconveniences. The first one is an O(n) set and search 
(n being the number of keys in the map) since both operations must iterate through the list of keys 
to find a matching value. The second inconvenience is a memory leak because the arrays ensure that 
references to each key and each value are maintained indefinitely. These references prevent the keys 
from being garbage collected, even if there are no other references to the object. This would also 
prevent the corresponding values from being garbage collected.

By contrast, native WeakMaps hold "weak" references to key objects, which means that they do not 
prevent garbage collection in case there would be no other reference to the key object. 
This also avoids preventing garbage collection of values in the map. Native WeakMaps can be particularly
 useful constructs when mapping keys to information about the key that is valuable only if the key 
 has not been garbage collected.

Because of references being weak, WeakMap keys are not enumerable (i.e. there is no method giving 
  you a list of the keys). If they were, the list would depend on the state of garbage collection, 
  introducing non-determinism. If you want to have a list of keys, you should use a Map.
*/

//--------------------------delete----------------------------------------------

/*
The delete() method removes the specified element from a WeakMap object.

*/
var wm = new WeakMap();
wm.set(window, 'foo');

wm.delete(window); // Returns true. Successfully removed.

wm.has(window);    // Returns false. The window object is no longer in the WeakMap.


//--------------------------get---------------------------------------------------------

/*
The get() method returns a specified element from a WeakMap object.
*/

var wm = new WeakMap();
wm.set(window, 'foo');

wm.get(window); // Returns "foo".
wm.get('baz');  // Returns undefined.

//--------------------------has---------------------------------------------------------

/*
The has() method returns a boolean indicating whether an element with the specified
 key exists in the WeakMap object or not.
*/

var wm = new WeakMap();
wm.set(window, 'foo');

wm.has(window); // returns true
wm.has('baz');  // returns false

//--------------------------set---------------------------------------------------------

/*
The set() method adds a new element with a specified key and value to a WeakMap object.
*/

var wm = new WeakMap();
var obj = {};

// Add new elements to the WeakMap
wm.set(obj, 'foo').set(window, 'bar'); // chainable

// Update an element in the WeakMap
wm.set(obj, 'baz');



     