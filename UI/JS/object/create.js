var car = {};
var car = { color: "red", name: "Honda"};
var car = new Object();
car.color = "red";
car.name = "Honda";

//Object.create(proto, [propertiesObject])

/* The Object.create() method creates a new object, using an 
existing object as the prototype of the newly created object.*/

const animal = {name: "puppy"}
const dog = Object.create(animal); //will not copy name property

const animal = {}
const dog = Object.create(animal, {
  breed: {
    value: 'Siberian Husky'
  }
});
console.log(dog.breed) //'Siberian Husky'

var oco = Object.create( {} );   // create a normal object
var ocn = Object.create( null ); // create a "null" object

console.log(oco) // {} -- Seems normal
console.log(ocn) // {} -- Seems normal here too, so far

oco.p = 1; // create a simple property on normal obj
ocn.p = 0; // create a simple property on "null" obj

console.log(oco) // {p: 1} -- Still seems normal
console.log(ocn) // {p: 0} -- Still seems normal here too. BUT WAIT...

"oco is: " + oco // shows "oco is: [object Object]"

"ocn is: " + ocn // throws error: Cannot convert object to primitive value

alert(oco) // shows [object Object]
alert(ocn) // throws error: Cannot convert object to primitive value

oco.toString() // shows [object Object]
ocn.toString() // throws error: ocn.toString is not a function

oco.valueOf() // shows {}
ocn.valueOf() // throws error: ocn.valueOf is not a function

oco.hasOwnProperty("p") // shows "true"
ocn.hasOwnProperty("p") // throws error: ocn.hasOwnProperty is not a function

oco.constructor // shows "Object() { [native code] }"
ocn.constructor // shows "undefined"

//Object.assign(target, ...sources)

/*
The Object.assign() method copies all enumerable own properties from one or more source objects 
to a target object. It returns the target object.
*/

const target = { a: 1, b: 2 };
const source = { b: 4, c: 5 };

const returnedTarget = Object.assign(target, source);

console.log(target);
// expected output: Object { a: 1, b: 4, c: 5 }

console.log(returnedTarget);
// expected output: Object { a: 1, b: 4, c: 5 }

const obj = { a: 1 };
const copy = Object.assign({}, obj);
console.log(copy); // { a: 1 }

/*For deep cloning, we need to use alternatives, because Object.assign() copies property values.
If the source value is a reference to an object, it only copies the reference value.*/

let obj1 = { a: 0 , b: { c: 0}};
  let obj2 = Object.assign({}, obj1);
  console.log(JSON.stringify(obj2)); // { "a": 0, "b": { "c": 0}}
  
  obj1.a = 1;
  console.log(JSON.stringify(obj1)); // { "a": 1, "b": { "c": 0}}
  console.log(JSON.stringify(obj2)); // { "a": 0, "b": { "c": 0}}
  
  obj2.a = 2;
  console.log(JSON.stringify(obj1)); // { "a": 1, "b": { "c": 0}}
  console.log(JSON.stringify(obj2)); // { "a": 2, "b": { "c": 0}}
  
  obj2.b.c = 3;
  console.log(JSON.stringify(obj1)); // { "a": 1, "b": { "c": 3}}
  console.log(JSON.stringify(obj2)); // { "a": 2, "b": { "c": 3}}
  
  // Deep Clone
  obj1 = { a: 0 , b: { c: 0}};
  let obj3 = JSON.parse(JSON.stringify(obj1));
  obj1.a = 4;
  obj1.b.c = 4;
  console.log(JSON.stringify(obj3)); // { "a": 0, "b": { "c": 0}}

  //Merging objects

const o1 = { a: 1 };
const o2 = { b: 2 };
const o3 = { c: 3 };

const obj = Object.assign(o1, o2, o3);
console.log(obj); // { a: 1, b: 2, c: 3 }
console.log(o1);  // { a: 1, b: 2, c: 3 }, target object itself is changed.

//Merging objects with same properties
const o1 = { a: 1, b: 1, c: 1 };
const o2 = { b: 2, c: 2 };
const o3 = { c: 3 };

const obj = Object.assign({}, o1, o2, o3);
console.log(obj); // { a: 1, b: 2, c: 3 }