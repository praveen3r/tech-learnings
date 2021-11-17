/*
One of TypeScript’s core principles is that type checking focuses on the shape that values have. 
This is sometimes called “duck typing” or “structural subtyping”. In TypeScript, interfaces fill 
the role of naming these types, and are a powerful way of defining contracts within your code as 
well as contracts with code outside of your project.
*/

//------------------------Basic Interface-----------------------------------------------

interface Person5 {
    name: string;
    age: number;
  
    greet(phrase: string): void;
  }
  
  let user1: Person5;
  
  user1 = {
    name: 'Max',
    age: 30,
    greet(phrase: string) {
      console.log(phrase + ' ' + this.name);
    }
  };
  
  user1.greet('Hi there - I am');

  //------------------------Class with Interface-----------------------------------------------

  interface Greetable {
    name: string;
  
    greet(phrase: string): void;
  }
  
  class Person6 implements Greetable {
    name: string;
    age = 30;
  
    constructor(n: string) {
      this.name = n;
    }
  
    greet(phrase: string) {
      console.log(phrase + ' ' + this.name);
    }
  }
  
  let user6: Greetable;
  
  user6 = new Person6('Max');
  
  user6.greet('Hi there - I am');
  console.log(user1);

  //------------------------Readonly-----------------------------------------------

  /*
  Some properties should only be modifiable when an object is first created. 
  You can specify this by putting readonly before the name of the property:
  */

 interface Point {
    readonly x: number;
    readonly y: number;
}

let p1: Point = { x: 10, y: 20 };
//p1.x = 5; // error!

//------------------------Extending Interfaces-----------------------------------------------

/*
Like classes, interfaces can extend each other. This allows you to copy the members of one 
interface into another, which gives you more flexibility in how you separate your interfaces
into reusable components.
*/

interface Shape {
    color: string;
}

interface Square extends Shape {
    sideLength: number;
}

let square = {} as Square;
square.color = "blue";
square.sideLength = 10;

//------------------------Function type-----------------------------------------------

/*
Interfaces are capable of describing the wide range of shapes that JavaScript objects
can take. In addition to describing an object with properties, interfaces are also 
capable of describing function types.

To describe a function type with an interface, we give the interface a call signature. 
This is like a function declaration with only the parameter list and return type given. 
Each parameter in the parameter list requires both name and type.
*/

interface SearchFunc {
    (source: string, subString: string): boolean;
}

/*
Once defined, we can use this function type interface like we would other 
interfaces. Here, we show how you can create a variable of a function type and assign
it a function value of the same type.
*/

let mySearch: SearchFunc;
mySearch = function(source: string, subString: string) {
    let result = source.search(subString);
    return result > -1;
}

/*
or function types to correctly type check, the names of the parameters do not need 
to match. We could have, for example, written the above example like this:
*/

let mySearch1: SearchFunc;
mySearch1 = function(src: string, sub: string): boolean {
    let result = src.search(sub);
    return result > -1;
}

/*
Function parameters are checked one at a time, with the type in each corresponding 
parameter position checked against each other. If you do not want to specify types 
at all, TypeScript’s contextual typing can infer the argument types since the function 
value is assigned directly to a variable of type SearchFunc. Here, also, the return 
type of our function expression is implied by the values it returns (here false and true).
*/

let mySearch2: SearchFunc;
mySearch2 = function(src, sub) {
    let result = src.search(sub);
    return result > -1;
}

/*
Had the function expression returned numbers or strings, the type checker would 
have made an error that indicates return type doesn’t match the return type described 
in the SearchFunc interface.
*/

let mySearc3h: SearchFunc;

// error: Type '(src: string, sub: string) => string' is not assignable to type 'SearchFunc'.
// Type 'string' is not assignable to type 'boolean'.

/*
mySearch3 = function(src, sub) {
  let result = src.search(sub);
  return "string";
};
*/

//------------------------Optional properties-----------------------------------------------

/*
Interfaces with optional properties are written similar to other interfaces, with each
optional property denoted by a ? at the end of the property name in the declaration.

The advantage of optional properties is that you can describe these possibly available 
properties while still also preventing use of properties that are not part of the interface. 
*/
interface SquareConfig {
    color?: string;
    width?: number;
}

function createSquare(config: SquareConfig): {color: string; area: number} {
    let newSquare = {color: "white", area: 100};
    if (config.color) {
        newSquare.color = config.color;
    }
    if (config.width) {
        newSquare.area = config.width * config.width;
    }
    return newSquare;
}

let mySquare = createSquare({color: "black"});


