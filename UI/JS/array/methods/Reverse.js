//a.reverse()

/*
The reverse() method reverses an array in place. The first array element becomes the last, and the 
last array element becomes the first.

The reverse method transposes the elements of the calling array object in place, mutating the array, 
and returning a reference to the array.

reverse is intentionally generic; this method can be called or applied to objects resembling arrays. 
Objects which do not contain a length property reflecting the last in a series of consecutive, 
zero-based numerical properties may not behave in any meaningful manner.

*/

//--------------------------Reversing the elements in an array----------------------------

const a = [1, 2, 3];

console.log(a); // [1, 2, 3]

a.reverse(); 

console.log(a); // [3, 2, 1]



//------------------------Reversing the elements in an array-like object----------------------

const a = {0: 1, 1: 2, 2: 3, length: 3};

console.log(a); // {0: 1, 1: 2, 2: 3, length: 3}

Array.prototype.reverse.call(a); //same syntax for using apply()

console.log(a); // {0: 3, 1: 2, 2: 1, length: 3}


