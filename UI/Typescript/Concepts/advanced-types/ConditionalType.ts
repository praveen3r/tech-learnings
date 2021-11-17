/*
Since TypeScript 2.8, we can define types with conditional tests. This lets us add types to data 
that can have different types according to the condition we set. The general expression for 
defining a conditional type in TypeScript is the following:

T extends U ? X : Y

T extends U describes the relationship between the generic types T and U . If T extends U is 
true then the X type is expected. Otherwise, the Y type is expected. 

*/

interface Animal {  
    kind: string;
  }
  interface Cat extends Animal {
    name: string;
  }
  interface Dog {
    name: string;
  }
  type CatAnimal = Cat extends Animal ? Cat : Dog;
  let catAnimal: CatAnimal = <Cat>{
    name: 'Joe',
    kind: 'cat'
  }

  /*
  In the code above, we created the CatAnimal type alias which is set to the Cat type if Cat 
  extends Animal . Otherwise, it’s set to Dog . Since Cat does extend Animal , the CatAnimal 
  type alias is set to the Cat type.

  This means that in the example above if we change <Cat> to <Dog> like we do in the following 
  code:
  */

 interface Animal1 {  
    kind: string;
  }
  interface Cat1 extends Animal1 {
    name: string;
  }
  interface Dog1 {
    name: string;
  }

  type CatAnimal1 = Cat1 extends Animal1 ? Cat1 : Dog1;

  /*
  let catAnimal1: CatAnimal1 = <Dog1>{
    name: 'Joe',
    kind: 'cat'
  }

  Property 'kind' is missing in type 'Dog' but required in type 'Cat'

  This ensures that we have the right type for catAnimal according to the condition expressed in the 
  type. If we want to Dog to be the type for catAnimal , then we can write the following instead:
  */

 interface Animal21 {  
    kind: string;
  }
  interface Cat21  {
    name: string;
  }
  interface Dog21 extends Animal21 {
    name: string;
  }
  type CatAnimal21 = Cat extends Animal21 ? Cat21 : Dog21;
  let catAnimal21: CatAnimal21 = <Dog21>{
    name: 'Joe'
  }

  /*
  We can also have nested conditions to determine the actual type from multiple conditions. 
  For example, we can write:
  */

 interface Animal31 {  
    kind: string;
  }
  interface Bird31  {
    name: string;
  }
  interface Cat31  {
    name: string;
  }
  interface Dog31 extends Animal31 {
    name: string;
  }
  type AnimalTypeName31<T> =
    T extends Animal31 ? Cat31 :    
    T extends Animal31 ? Dog31 :    
    T extends Animal31 ? Bird31 :
    Animal31
  type t0 = AnimalTypeName31<Cat31>;  
  type t1 = AnimalTypeName31<Dog31>;
  type t2 = AnimalTypeName31<Animal31>;
  type t3 = AnimalTypeName31<Bird31>;

  /*

  Then we get the following types for the type alias t0 , t1 , t2 , and t3 :

  type t0 = Animal
  type t1 = Cat
  type t2 = Cat
  type t3: Animal

  The exact doesn’t have to be chosen immediately, we can also have something like:

  */

 interface Foo41 {
}
interface Bar41 extends Foo41 {
  
}
function bar(x: any) {
  return x;
}
function foo<T>(x: T) {
  let y: T extends Foo41 ? string : number = bar(x);
  let z: string | number = y;
}
foo<Bar41>(1);
foo<Bar41>('1');
foo<Bar41>(false);

/*
As we can see we can pass in anything into the foo even though we have the conditional types set. 
This is because the actual type in the type condition hasn’t been chosen yet., so TypeScript doesn’t 
make any assumption about what we can assign to the variables in the foo function.
*/

//-----------------------------------Distribution Conditional Types-------------------------------

/*
Conditional types are distributive. If we have multiple conditional types that can possibly 
extend one type as we have in the following code:
*/

interface A {}
interface B {}
interface C {}
interface D {}
interface X {}
interface Y {}
type TypeName = (A | B | C) extends D ? X : Y;

/* 

Then the last line is equivalent to:

(A extends D ? X : Y) | (B extends D ? X : Y) | (C extends D ? X : Y)

*/

// For example, we can use it to filter out types with various conditions. For example, we can write:

type Diff1<T, U> = T extends U ? never : T;

/* 
To remove types from T that are assignable to U . If T extends U, then the Diff<T, U> type is never, 
which means that we can assign anything to it, otherwise it takes on the type T. Likewise, we can write:
*/

type Filter1<T, U> = T extends U ? T : never;

/*
to remove types from T that aren’t assignable to U . In this case, if T extends U, then the Filter 
type is the same as the T type, otherwise, it takes on the never type. For example, if we have:
*/

type Diff<T, U> = T extends U ? never : T;

type TypeName1 = Diff<string| number | boolean, boolean>;


/*
Then TypeName has the type string | number . This is because Diff<string| number | boolean, boolean> 
is the same as:

(string extends boolean ? never : string) | (number extends boolean ? never: number) | (boolean extends boolean ? never: boolean)

On the other hand, if we write:
*/

type Filter<T, U> = T extends U ? T : never;

type TypeName2 = Filter<string| number | boolean, boolean>;

/*Then TypeName has the boolean type. This is because Diff<string| number | boolean, boolean> is the 
same as:
(string extends boolean ? string: never) | (number extends boolean ? number: never) | (boolean extends boolean ? boolean: never)
*/


//-----------------------------------Pre defined Conditional Types-------------------------------

/*
TypeScript 2.8 has the following predefined conditional types, They’re the following:

Exclude<T, U> – excludes from T those types that are assignable to U.
Extract<T, U> – extract from T those types that are assignable to U.
NonNullable<T> – exclude null and undefined from T.
ReturnType<T> – get the return type of a function type.
InstanceType<T> – get the instance type of a constructor function type.

Since TypeScript 2.8, we can define types with conditional tests. The general expression for 
defining a conditional type in TypeScript is T extends U ? X : Y . They’re distributive, 
so (A | B | C) extends D ? X : Y; is the same as 
(A extends D ? X : Y) | (B extends D ? X : Y) | (C extends D ? X : Y) .
*/