//arr.push(element1[, ...[, elementN]])

/*
The push() method adds one or more elements to the end of an array and returns the new length of the array.

The push method appends values to an array.

push is intentionally generic. This method can be used with call() or apply() on objects resembling 
arrays. The push method relies on a length property to determine where to start inserting the given 
values. If the length property cannot be converted into a number, the index used is 0. This includes 
the possibility of length being nonexistent, in which case length will also be created.

Although strings are native, Array-like objects, they are not suitable in applications of this method, 
as strings are immutable.  Similarly for the native, Array-like object arguments.

*/

//--------------------------Adding elements to an array----------------------------

let sports = ['soccer', 'baseball']
let total = sports.push('football', 'swimming')

console.log(sports)  // ['soccer', 'baseball', 'football', 'swimming']
console.log(total)   // 4


//---------------------Merging two arrays-----------------------------------------

let vegetables = ['parsnip', 'potato']
let moreVegs = ['celery', 'beetroot']

// Merge the second array into the first one
// Equivalent to vegetables.push('celery', 'beetroot')
Array.prototype.push.apply(vegetables, moreVegs)

console.log(vegetables)  // ['parsnip', 'potato', 'celery', 'beetroot']

//---------------------Using an object in an array-like fashion-----------------------

let obj = {
    length: 0,

    addElem: function addElem(elem) {
        // obj.length is automatically incremented 
        // every time an element is added.
        [].push.call(this, elem)
    }
}

// Let's add some empty objects just to illustrate.
obj.addElem({})
obj.addElem({})
console.log(obj.length)
// → 2
