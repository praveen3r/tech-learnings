//let arrDeletedItems = array.splice(start[, deleteCount[, item1[, item2[, ...]]]])

/*
The splice() method changes the contents of an array by removing or replacing existing elements and/or adding new elements in place.

If the specified number of elements to insert differs from the number of elements being removed, 
the array's length will be different at the end of the call.

*/

//---------------Remove 0 (zero) elements before index 2, and insert "drum"-----------------

let myFish = ['angel', 'clown', 'mandarin', 'sturgeon']
let removed = myFish.splice(2, 0, 'drum')

// myFish is ["angel", "clown", "drum", "mandarin", "sturgeon"] 
// removed is [], no elements removed



//---------------Remove 0 (zero) elements before index 2, and insert "drum" and "guitar"------------------

let myFish = ['angel', 'clown', 'mandarin', 'sturgeon']
let removed = myFish.splice(2, 0, 'drum', 'guitar')

// myFish is ["angel", "clown", "drum", "guitar", "mandarin", "sturgeon"] 
// removed is [], no elements removed


//------------------------Remove 1 element at index 3------------------------------

let myFish = ['angel', 'clown', 'drum', 'mandarin', 'sturgeon']
let removed = myFish.splice(3, 1)

// removed is ["mandarin"]
// myFish is ["angel", "clown", "drum", "sturgeon"]

//--------------------Remove 1 element at index 2, and insert "trumpet"--------------------

let myFish = ['angel', 'clown', 'drum', 'sturgeon']
let removed = myFish.splice(2, 1, 'trumpet')

// myFish is ["angel", "clown", "trumpet", "sturgeon"]
// removed is ["drum"]

//--------------------Remove 2 elements from index 0, and insert "parrot", "anemone" and "blue"--------------------

let myFish = ['angel', 'clown', 'trumpet', 'sturgeon']
let removed = myFish.splice(0, 2, 'parrot', 'anemone', 'blue')

// myFish is ["parrot", "anemone", "blue", "trumpet", "sturgeon"] 
// removed is ["angel", "clown"]

//--------------------Remove 2 elements from index 2--------------------------

let myFish = ['parrot', 'anemone', 'blue', 'trumpet', 'sturgeon']
let removed = myFish.splice(2, 2)

// myFish is ["parrot", "anemone", "sturgeon"] 
// removed is ["blue", "trumpet"]

//--------------------Remove 1 element from index -2--------------------------

let myFish = ['angel', 'clown', 'mandarin', 'sturgeon']
let removed = myFish.splice(-2, 1)

// myFish is ["angel", "clown", "sturgeon"] 
// removed is ["mandarin"]

//--------------------Remove all elements after index 2 (incl.)--------------------------

let myFish = ['angel', 'clown', 'mandarin', 'sturgeon']
let removed = myFish.splice(2)

// myFish is ["angel", "clown"]
// removed is ["mandarin", "sturgeon"]