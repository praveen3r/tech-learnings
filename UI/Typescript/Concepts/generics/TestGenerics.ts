//-------------------------Basics--------------------------------------------------------------

/*
TypeScript supports generic classes. The generic type parameter is specified in 
angular brackets after the name of the class. A generic class can have generic fields 
(member variables) or methods.
*/

class KeyValuePair<T,U>
{ 
    private key: T | undefined;
    private val: U | undefined;;

   setKeyValue(key: T, val: U): void { 
        this.key = key;
        this.val = val;
    }

    display():void { 
        console.log(`Key = ${this.key}, val = ${this.val}`);
    }
}

let kvp1 = new KeyValuePair<number, string>();
kvp1.setKeyValue(1, "Steve");
kvp1.display(); //Output: Key = 1, Val = Steve 

let kvp2 = new KeyValuePair<string, string>();
kvp2.setKeyValue("CEO", "Bill"); 
kvp2.display(); //Output: Key = CEO, Val = Bill


//-------------------------Functions--------------------------------------------------------------

// Example 1)

function identity<T>(arg: T): T {
    return arg;
}

//or let myIdentity: {<T>(arg: T): T} = identity;

let output = identity<string>("myString");

// Example 2)

function merge<T, U>(objA: T, objB: U) {
    return (<any>Object).assign(objA, objB);
  }
  
  const mergedObj = merge({ name: 'Max' }, { age: 30 });
  console.log(mergedObj);

 //-------------------------Constraints------------------------------------------------------------

 //We’re going to write a function, which will return the length of a function’s argument.

/* 
function getLength<T>(args: T) : number {
  return args.length;
} 
*/

/* Instead of working with any and all types, we’d like to constrain this function to work with any 
and all types that also have the .length property. As long as the type has this member, 
we’ll allow it, but it’s required to have at least this member. To do so, we must list our 
requirement as a constraint on what T can be.

To do so, we’ll create an interface that describes our constraint. Here, we’ll create an interface 
that has a single .length property and then we’ll use this interface and the extends keyword to 
denote our constraint:
*/

interface Lengthwise {
    length: number;
}

//Now, change our above function and extend it with this interface to the constraint.

function getLength<T extends Lengthwise>(args:T) : number {
  return args.length;
}

//Because the generic function is now constrained, it will no longer work over any and all types:

// getLength(3);  // Error, number doesn't have a .length property

//Instead, we need to pass in values whose type has all the required properties:

getLength({length: 10, value: 3});

//--------Using Type Parameters in Generic Constraints----

// You can declare a type parameter that is constrained by another type parameter. 

function merge1<T extends object, U extends object>(objA: T, objB: U) {
    return (Object as any).assign(objA, objB);
  }
  
  //const mergedObj1 = merge1({ name: 'Max', hobbies: ['Sports'] }, 10); //error

  const mergedObj1 = merge1({ name: 'Max', hobbies: ['Sports'] }, { age: 30 });
  console.log(mergedObj1);


//-------------------------keyof------------------------------------------------------------

/*
The operator keyof helps us to use correct property name where it is needed.

keyof is an indexed type query which yields the type of permitted property names for an object.

The keyof type is considered a subtype of string.
*/

// Example 1)

function extractAndConvert<T extends object, U extends keyof T>(
  obj: T,
  key: U
) {
  return 'Value: ' + obj[key];
}

extractAndConvert({ name: 'Max' }, 'name');

// Example 2)

class Test{
  x: number = 6;
}

function getProp(a: keyof Test, test: Test): any{
  return test[a];
}

let t: Test = new Test();
let prop = getProp("x", t);
console.log(prop);

//-------------------------Generic class------------------------------------------------------------

/*
Generic classes have a generic type parameter list in angle brackets (<>) following 
the name of the class.
*/

class GenericNumber<T> {
  zeroValue!: T;
  add!: (x: T, y: T) => T;
}

let myGenericNumber = new GenericNumber<number>();
myGenericNumber.zeroValue = 0;
myGenericNumber.add = function(x, y) { return x + y; };