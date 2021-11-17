//arr.unshift(element1[, ...[, elementN]])

/*
The unshift() method adds one or more elements to the beginning of an array and 
returns the new length of the array.

The unshift method inserts the given values to the beginning of an array-like object.

unshift is intentionally generic. This method can be called or applied to objects resembling arrays. 
Objects which do not contain a length property—reflecting the last in a series of consecutive, 
zero-based numerical properties—may not behave in any meaningful manner.

Please note that, if multiple elements are passed as parameters, they're inserted in chunk at the 
beginning of the object, in the exact same order they were passed as parameters. Hence, calling 
unshift with n arguments once, or calling it n times with 1 argument (with a loop, for example), 
don't yield the same results.

*/

//---------------------------------Examples--------------------------------

let arr = [1, 2]

arr.unshift(0)               // result of the call is 3, which is the new array length
// arr is [0, 1, 2]

arr.unshift(-2, -1)          // the new array length is 5
// arr is [-2, -1, 0, 1, 2]

arr.unshift([-4, -3])        // the new array length is 6
// arr is [[-4, -3], -2, -1, 0, 1, 2]

arr.unshift([-7, -6], [-5])  // the new array length is 8
// arr is [ [-7, -6], [-5], [-4, -3], -2, -1, 0, 1, 2 ]



