//-------------------------Basics--------------------------------------------------------------

/*
With the introduction of Classes in TypeScript and ES6, there now exist certain scenarios that 
require additional features to support annotating or modifying classes and class members. 
Decorators provide a way to add both annotations and a meta-programming syntax for class 
declarations and members. Decorators are a stage 2 proposal for JavaScript and are available 
as an experimental feature of TypeScript.

To enable experimental support for decorators, you must enable the experimentalDecorators 
compiler option either on the command line or in your tsconfig.json:

tsconfig.json:

{
    "compilerOptions": {
        "target": "ES5",
        "experimentalDecorators": true
    }
}

A Decorator is a special kind of declaration that can be attached to a class declaration, 
method, accessor, property, or parameter. Decorators use the form @expression, where expression 
must evaluate to a function that will be called at runtime with information about the decorated 
declaration.

For example, given the decorator @sealed we might write the sealed function as follows:
*/

function Logger(constructor: Function) {
    console.log('Logging...');
    console.log(constructor);
  }
  
  @Logger
  class Person11 {
    name = 'Max';
  
    constructor() {
      console.log('Creating person object...');
    }
  }
  
  const pers = new Person11();
  
  console.log(pers);

//-------------------------Decorator Factories-----------------------------------------------------

/*
If we want to customize how a decorator is applied to a declaration, we can write a decorator 
factory. A Decorator Factory is simply a function that returns the expression that will be called 
by the decorator at runtime.

We can write a decorator factory in the following fashion:

function color(value: string) { // this is the decorator factory
    return function (target) { // this is the decorator
        // do something with 'target' and 'value'...
    }
}
*/

function Logger112(logString: string) {
    return function(constructor: Function) {
      console.log(logString);
      console.log(constructor);
    };
  }
  
  @Logger112('LOGGING - PERSON')
  class Person112 {
    name = 'Max';
  
    constructor() {
      console.log('Creating person object...');
    }
  }
  
  const pers112 = new Person112();
  
  console.log(pers112);
  
//-------------------------Multiple decorators-----------------------------------------------------

/*
Multiple decorators can be applied to a declaration, as in the following examples:

On a single line:

@f @g x
On multiple lines:

@f
@g
x

When multiple decorators apply to a single declaration, their evaluation is similar to 
function composition in mathematics. In this model, when composing functions f and g, the 
resulting composite (f ∘ g)(x) is equivalent to f(g(x)).

As such, the following steps are performed when evaluating multiple decorators on a single 
declaration in TypeScript:

The expressions for each decorator are evaluated top-to-bottom.
The results are then called as functions from bottom-to-top.
If we were to use decorator factories, we can observe this evaluation order with the following 
example:
*/

function f() {
    console.log("f(): evaluated");
    return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
        console.log("f(): called");
    }
}

function g() {
    console.log("g(): evaluated");
    return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
        console.log("g(): called");
    }
}

class C1 {
    @f()
    @g()
    method() {}
}

/*

Output

f(): evaluated
g(): evaluated
g(): called
f(): called
*/

//-------------------------Property Decorators-----------------------------------------------------

/*
A Property Decorator is declared just before a property declaration. A property decorator cannot 
be used in a declaration file, or in any other ambient context (such as in a declare class).

The expression for the property decorator will be called as a function at runtime, with the 
following two arguments:

1) Either the constructor function of the class for a static member, or the prototype of the class for an 
    instance member.
2) The name of the member.

NOTE  A Property Descriptor is not provided as an argument to a property decorator due to how 
property decorators are initialized in TypeScript. This is because there is currently no mechanism 
to describe an instance property when defining members of a prototype, and no way to observe or 
modify the initializer for a property. The return value is ignored too. As such, a property decorator 
can only be used to observe that a property of a specific name has been declared for a class.
*/

function logParameter(target: Object, propertyName: string) {
  console.log(target);
  console.log(propertyName);
}

class Employee112 {

  @logParameter
  name: string = '';

}

const emp = new Employee112();
emp.name = 'Mohan Ram';
console.log(emp.name);

//-------------------------Accessor Decorators-----------------------------------------------------

/*
An Accessor Decorator is declared just before an accessor declaration. The accessor decorator is 
applied to the Property Descriptor for the accessor and can be used to observe, modify, or 
replace an accessor’s definitions. An accessor decorator cannot be used in a declaration file, 
or in any other ambient context (such as in a declare class).

NOTE  TypeScript disallows decorating both the get and set accessor for a single member. Instead, 
all decorators for the member must be applied to the first accessor specified in document order. 
This is because decorators apply to a Property Descriptor, which combines both the get and set 
accessor, not each declaration separately.

The expression for the accessor decorator will be called as a function at runtime, with the 
following three arguments:

1) Either the constructor function of the class for a static member, or the prototype of the class for an 
   instance member.
2) The name of the member.
3) The Property Descriptor for the member.

NOTE  The Property Descriptor will be undefined if your script target is less than ES5.

If the accessor decorator returns a value, it will be used as the Property Descriptor for the member.

NOTE  The return value is ignored if your script target is less than ES5.

*/

function configurable(value: boolean) {
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
      descriptor.configurable = value;
  };
}

class Point {
  private _x1: number;
  private _y1: number;
  constructor(x: number, y: number) {
      this._x1 = x;
      this._y1 = y;
  }

  @configurable(false)
  get x1() { return this._x1; }

  @configurable(false)
  get y1() { return this._y1; }
}


//-------------------------Method Decorators-----------------------------------------------------

/*
A Method Decorator is declared just before a method declaration. The decorator is applied to the 
Property Descriptor for the method, and can be used to observe, modify, or replace a method definition. 
A method decorator cannot be used in a declaration file, on an overload, or in any other ambient 
context (such as in a declare class).

The expression for the method decorator will be called as a function at runtime, with the following 
three arguments:

1) Either the constructor function of the class for a static member, or the prototype of the class for an 
    instance member.
2) The name of the member.
3) The Property Descriptor for the member.

NOTE  The Property Descriptor will be undefined if your script target is less than ES5.

If the method decorator returns a value, it will be used as the Property Descriptor for the method.

NOTE  The return value is ignored if your script target is less than ES5.

*/

function enumerable(value: boolean) {
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
      descriptor.enumerable = value;
  };
}

class Greeter12 {
  greeting: string;
  constructor(message: string) {
      this.greeting = message;
  }

  @enumerable(false)
  greet() {
      return "Hello, " + this.greeting;
  }
}

//-------------------------Parameter Decorators-----------------------------------------------------

/*
A Parameter Decorator is declared just before a parameter declaration. The parameter decorator is 
applied to the function for a class constructor or method declaration. A parameter decorator 
cannot be used in a declaration file, an overload, or in any other ambient context (such as in a 
declare class).

The expression for the parameter decorator will be called as a function at runtime, with the 
following three arguments:

1) Either the constructor function of the class for a static member, or the prototype of the class for an instance member.
2) The name of the member.

The ordinal index of the parameter in the function’s parameter list.

NOTE  A parameter decorator can only be used to observe that a parameter has been declared on a method.

The return value of the parameter decorator is ignored.

The following is an example of a parameter decorator (@required) applied to parameter of a member of the Greeter class:
*/


function required(target: any, name: string | Symbol, position: number) {
  console.log('Parameter decorator!');
  console.log(target);
  console.log(name);
  console.log(position);
}

class Greeter123 {
  greeting: string;

  constructor(message: string) {
      this.greeting = message;
  }

  greet(@required name: string) {
      return "Hello " + name + ", " + this.greeting;
  }
}

//-------------------------Decorator Evaluation-----------------------------------------------------

/*
There is a well defined order to how decorators applied to various declarations inside of a class are applied:

Parameter Decorators, followed by Method, Accessor, or Property Decorators are applied for each instance member.
Parameter Decorators, followed by Method, Accessor, or Property Decorators are applied for each static member.
Parameter Decorators are applied for the constructor.
Class Decorators are applied for the class.
*/

//-------------------------Returning from a class-----------------------------------------------------

// return will work only if class is instantiated. Applicable for class, method and accessors

function classDecorator<T extends {new(...args:any[]):{}}>(constructor:T) {
  return class extends constructor {
      newProperty = "new property";
      hello = "override";
  }
}

@classDecorator
class Greeter1234 {
  property = "property";
  hello: string;
  constructor(m: string) {
      this.hello = m;
  }
}

console.log(new Greeter1234("world"));

//-------------------------Validating class-----------------------------------------------------


interface ValidatorConfig {
  [property: string]: {
    [validatableProp: string]: string[]; // ['required', 'positive']
  };
}

const registeredValidators: ValidatorConfig = {};

function Required(target: any, propName: string) {
  registeredValidators[target.constructor.name] = {
    ...registeredValidators[target.constructor.name],
    [propName]: ['required']
  };
}

function PositiveNumber(target: any, propName: string) {
  registeredValidators[target.constructor.name] = {
    ...registeredValidators[target.constructor.name],
    [propName]: ['positive']
  };
}

function validate(obj: any) {
  const objValidatorConfig = registeredValidators[obj.constructor.name];
  if (!objValidatorConfig) {
    return true;
  }
  let isValid = true;
  for (const prop in objValidatorConfig) {
    for (const validator of objValidatorConfig[prop]) {
      switch (validator) {
        case 'required':
          isValid = isValid && !!obj[prop];
          break;
        case 'positive':
          isValid = isValid && obj[prop] > 0;
          break;
      }
    }
  }
  return isValid;
}

class Course {
  @Required
  title: string;
  @PositiveNumber
  price: number;

  constructor(t: string, p: number) {
    this.title = t;
    this.price = p;
  }
}


function validate11() {

  const title = "";
  const price = 0;

  const createdCourse = new Course(title, price);

  if (!validate(createdCourse)) {
    console.log('Invalid input, please try again!');
    
  }else{
    console.log('Success!');
  }
  
};

validate11();