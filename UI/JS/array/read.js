var arr = [];
arr[0] = "test";
arr[1] = "test";

console.log(arr[0]);
console.log(arr["0"]);
console.log(typeof arr);
console.log(arr instanceof Object);
console.log(arr instanceof Array);

var arr1 = [];
arr1[0] = "test";
arr1[1] = "test";
arr1[2] = null;
arr1[3] = "";
arr1[4] = undefined;
arr1[10] = "test123";

for(var i in arr1){
    if(arr1.hasOwnProperty(i)){
        console.log(`value is ${arr1[i]}`)
    }
}

//The Array.isArray() method determines whether the passed value is an Array.

// all following calls return true
Array.isArray([]);
Array.isArray([1]);
Array.isArray(new Array());
Array.isArray(new Array('a', 'b', 'c', 'd'));
Array.isArray(new Array(3));
// Little known fact: Array.prototype itself is an array:
Array.isArray(Array.prototype); 

// all following calls return false
Array.isArray();
Array.isArray({});
Array.isArray(null);
Array.isArray(undefined);
Array.isArray(17);
Array.isArray('Array');
Array.isArray(true);
Array.isArray(false);
Array.isArray(new Uint8Array(32));
Array.isArray({ __proto__: Array.prototype });

//When checking for Array instance, Array.isArray is preferred over instanceof because it works through iframes.