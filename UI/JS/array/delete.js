var arr = [];
arr[0] = "test";
arr[1] = 1;
arr[2] = 2;
arr[12] = 2;

arr.length = 2;
console.log(arr);

var arr1 = [];
arr1[0] = "test";
arr1[1] = 1;
arr1[2] = 2;

delete arr1[1]; //does not remove, to remove use splice