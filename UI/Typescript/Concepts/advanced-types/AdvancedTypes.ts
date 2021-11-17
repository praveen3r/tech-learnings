//-------------------------Intersection Types----------------------------------------

/*
An intersection type combines multiple types into one. This allows you to 
add together existing types to get a single type that has all the features 
you need
*/

type Admin = {
    name: string;
    privileges: string[];
  };
  
  type Employee7 = {
    name: string;
    startDate: Date;
  };
  
  type ElevatedEmployee = Admin & Employee7;
  
  const e1: ElevatedEmployee = {
    name: 'Max',
    privileges: ['create-server'],
    startDate: new Date()
  };
  
  type Combinable2 = string;
  type Numeric = number;
  
  type Universal = Combinable2 & Numeric;

//-------------------------Union Types------------------------------------------------

/*
A union type describes a value that can be one of several types.
We use the vertical bar (|) to separate each type, so number | string | boolean
is the type of a value that can be a number, a string, or a boolean.

If we have a value that has a union type, we can only access members that are common
to all types in the union.
*/

type Admin1 = {
    name: string;
    privileges: string[];
  };
  
  type Employee8 = {
    name: string;
    startDate: Date;
  };
  
  type ElevatedEmployee1 = Admin1 | Employee8;
  
  const e2: ElevatedEmployee1 = {
    name: 'Max',
    privileges: ['create-server'],
    startDate: new Date()
  };

  console.log(e2.name);
  //console.log(e2.privileges);//error

  //-------------------------Type Guards------------------------------------------------

  /*

  Union types are useful for modeling situations when values can overlap in the types 
  they can take on. What happens when we need to know specifically whether we have a Fish? 
  A common idiom in JavaScript to differentiate between two possible values is to check 
  for the presence of a member. As we mentioned, you can only access members that are
  guaranteed to be in all the constituents of a union type.

  */

//  1) typeof type guards

type Combinable3 = string | number;

function add23(a: Combinable3, b: Combinable3) {
    if (typeof a === 'string' || typeof b === 'string') {
      return a.toString() + b.toString();
    }
    return a + b;
  }

//  2) Using the in operator

type Admin3 = {
    name: string;
    privileges: string[];
  };
  
  type Employee3 = {
    name: string;
    startDate: Date;
  };

  type UnknownEmployee = Employee3 | Admin3;

function printEmployeeInformation(emp: UnknownEmployee) {
  console.log('Name: ' + emp.name);
  if ('privileges' in emp) {
    console.log('Privileges: ' + emp.privileges);
  }
  if ('startDate' in emp) {
    console.log('Start Date: ' + emp.startDate);
  }
}

printEmployeeInformation({ name: 'Manu', startDate: new Date() });

//  3) instanceof type guards

class Car {
    drive() {
      console.log('Driving...');
    }
  }
  
  class Truck {
    drive() {
      console.log('Driving a truck...');
    }
  
    loadCargo(amount: number) {
      console.log('Loading cargo ...' + amount);
    }
  }
  
  type Vehicle = Car | Truck;
  
  const v1 = new Car();
  const v2 = new Truck();
  
  function useVehicle(vehicle: Vehicle) {
    vehicle.drive();
    if (vehicle instanceof Truck) {
      vehicle.loadCargo(1000);
    }
  }
  
  useVehicle(v1);
  useVehicle(v2);

  //  4) Discriminating union

  interface Bird {
    type: 'bird';
    flyingSpeed: number;
  }
  
  interface Horse {
    type: 'horse';
    runningSpeed: number;
  }
  
  type Animal4 = Bird | Horse;
  
  function moveAnimal(animal: Animal4) {
    let speed;
    switch (animal.type) {
      case 'bird':
        speed = animal.flyingSpeed;
        break;
      case 'horse':
        speed = animal.runningSpeed;
    }
    console.log('Moving at speed: ' + speed);
  }
  
  moveAnimal({type: 'bird', flyingSpeed: 10});

  //-------------------------Type Assertion------------------------------------------------

  /*
  
  Type assertion allows you to set the type of a value and tell the compiler not to infer it.
  It is merely a way to let the TypeScript compiler know the type of a variable.

  */

 let code: any = 123; 
 let employeeCode = <number> code; 

 // or use "as"

 let employeeCode1 = code as number;

 /*
 In the above example, we have a variable code of type any. We assign the value of this
 variable to another variable called employeeCode. However, we know that code is of type number, 
 even though it has been declared as 'any'. So, while assigning code to employeeCode, we have 
 asserted that code is of type number in this case, and we are certain about it. Now, the type 
 of employeeCode is number.
 */

 // Type assertion with object

/*
let employee = { };
employee.name = "John"; //Compiler Error: Property 'name' does not exist on type '{}'
employee.code = 123; //Compiler Error: Property 'code' does not exist on type '{}'
*/

interface Employee6 { 
    name: string; 
    code: number; 
} 

let employee6 = { } as Employee6; 
employee6.name = "John"; // OK
employee6.code = 123; // OK

 //-------------------------Index types------------------------------------------------

  /*
  
  With index types, you can get the compiler to check code that uses dynamic property names.
  For example, a common JavaScript pattern is to pick a subset of properties from an object:

  */

 interface ErrorContainer { // { email: 'Not a valid email', username: 'Must start with a character!' }
 [prop: string]: string;
}

const errorBag: ErrorContainer = {
 email: 'Not a valid email!',
 username: 'Must start with a capital character!'
};

 //-------------------------Overloading---------------------------------------------------

  /*
  
  TypeScript provides the concept of function overloading. You can have multiple 
  functions with the same name but different parameter types and return type.
  However, the number of parameters should be the same (or the implementation should
  support default value)
  */

 function add1(a:string, b:string):string;

function add1(a:number, b:number): number;

function add1(a: any, b:any): any {
    return a + b;
}

add1("Hello ", "Steve"); // returns "Hello Steve" 
add1(10, 20); // returns 30 

/*
In the above example, we have the same function add() with two function declarations 
and one function implementation. The first signature has two parameters of type string, 
whereas the second signature has two parameters of the type number.

The last function should have the function implementation. Since the return type can be 
either string or number as per the first two function declarations, we must use compatible 
parameters and return type as any in the function definition.

Function overloading with different number of parameters and types with same name is not 
supported.
*/
 
/*function display(a:string, b:string):void //Compiler Error: Duplicate function implementation
{
    console.log(a + b);
}

function display(a:number): void //Compiler Error: Duplicate function implementation
{
    console.log(a);
}*/

/*
Thus, in order to achieve function overloading, we must declare all the functions with possible 
signatures. Also, function implementation should have compatible types for all declarations.
*/

//-------------------------Optional Chaining(3.7)---------------------------------------------------

  /*
 You might find yourself using ?. to replace a lot of code that performs repetitive 
 nullish checks using the && operator.
  */

  // Example 1)

 const arr = [
  { key:{code: "a",name:"a"} },
  { key:{code: "b",name:"b"} },
  { key:{code: "c",name:"c"} },
  { name: "Caty" },
  { name: "Siri" },
];

const notThere = arr[3].key?.code;

// Example 2)

const test = [{name:"test1", code:[{name:"test1", code:"test1"}]},
              {name:"test2", code:[{name:"test2", code:"test2"}]},
              {name:"test3", code:[{name:"test3", code:"test3"}]},
              {name:"test4"}]

              

/*for(const value of test){
    for(const value1 of value?.code){
    console.log(value1?.name);
}*/

test.forEach(value => {
    value?.code?.forEach(value1 => {
    console.log(value1.name);
  })
})


//-------------------------Nullish Coalescing(3.7)---------------------------------------------------

  /*
 You can think of this feature - the ?? operator - as a way to “fall back” to a default 
 value when dealing with null or undefined. 
  */

 console.log(null ?? 20 ); // returns 20
 console.log(undefined ?? 20 ); // returns 20
 console.log(true ?? 10 ); // returns true
 console.log(NaN ?? 20 ); // returns NaN
 console.log('' ?? 20 ); // returns NaN