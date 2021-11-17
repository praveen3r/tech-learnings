//arr.shift()

/*
The shift() method removes the first element from an array and returns that removed element.
 This method changes the length of the array.

 The shift method removes the element at the zeroeth index and shifts the values at consecutive 
 indexes down, then returns the removed value. If the length property is 0, undefined is returned.

shift is intentionally generic; this method can be called or applied to objects resembling arrays. 
Objects which do not contain a length property reflecting the last in a series of consecutive,
 zero-based numerical properties may not behave in any meaningful manner.

Array.prototype.pop() has similar behavior to shift, but applied to the last element in an array.

*/

//--------------------------Removing the elements in an array----------------------------

var myFish = ['angel', 'clown', 'mandarin', 'surgeon'];

console.log('myFish before:', JSON.stringify(myFish));
// myFish before: ['angel', 'clown', 'mandarin', 'surgeon']

var shifted = myFish.shift(); 

console.log('myFish after:', myFish); 
// myFish after: ['clown', 'mandarin', 'surgeon']

console.log('Removed this element:', shifted); 
// Removed this element: angel



//------------------------Using shift() method in while loop------------------------------

var names = ["Andrew", "Edward", "Paul", "Chris" ,"John"];

while( (i = names.shift()) !== undefined ) {
    console.log(i);
}
// Andrew, Edward, Paul, Chris, John


