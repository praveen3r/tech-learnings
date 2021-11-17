//var newArray = arr.flat([depth]);

/*
The flat() method creates a new array with all sub-array elements concatenated 
into it recursively up to the specified depth.
*/

//-----------------------Flattening nested arrays--------------------------

const arr1 = [1, 2, [3, 4]];
arr1.flat(); 
// [1, 2, 3, 4]

const arr2 = [1, 2, [3, 4, [5, 6]]];
arr2.flat();
// [1, 2, 3, 4, [5, 6]]

const arr3 = [1, 2, [3, 4, [5, 6]]];
arr3.flat(2);
// [1, 2, 3, 4, 5, 6]

const arr4 = [1, 2, [3, 4, [5, 6, [7, 8, [9, 10]]]]];
arr4.flat(Infinity);
// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

//-----------------------Flattening and array holes----------------------------

const arr5 = [1, 2, , 4, 5];
arr5.flat();
// [1, 2, 4, 5]
