//-------------------------Partial<T>--------------------------------------------------------------

/*
Constructs a type with all properties of T set to optional. This utility will return a 
type that represents all subsets of a given type.
*/

interface Todo {
    title: string;
    description: string;
}

function updateTodo(fieldsToUpdate: Partial<Todo>) {
   
}

updateTodo({
    title: 'organize desk',
    description: 'clear clutter',
});

updateTodo({
    description: 'throw out trash',
});

//-------------------------ReadOnly<T>--------------------------------------------------------------

/*
Constructs a type with all properties of T set to readonly, meaning the properties of the 
constructed type cannot be reassigned.
*/

interface Todo1 {
    title: string;
}

const todo1: Readonly<Todo1> = {
    title: 'Delete inactive users',
};

//todo1.title = 'Hello'; // Error: cannot reassign a readonly property

//-------------------------Record<K,T>--------------------------------------------------------------

/*
Constructs a type with a set of properties K of type T. This utility can be used to map the 
properties of a type to another type.
*/

// Example 1)

const x23: Record<string, number> = {
    apple:10,
    orange:20
}


// Example 2)
interface PageInfo {
    title: string;
}

type Page = 'home' | 'about' | 'contact';

const x: Record<Page, PageInfo> = {
    about: { title: 'about' },
    contact: { title: 'contact' },
    home: { title: 'home' },
};

//-------------------------Pick<T,K>--------------------------------------------------------------

/*
Constructs a type by picking the set of properties K from T.
*/

interface Todo {
    title: string;
    description: string;
    completed: boolean;
}

type TodoPreview = Pick<Todo, 'title' | 'completed'>;

const todo: TodoPreview = {
    title: 'Clean room',
    completed: false,
};

//-------------------------Omit<T,K>--------------------------------------------------------------

/*
Constructs a type by picking all properties from T and then removing K.
*/

interface Todo2 {
    title: string;
    description: string;
    completed: boolean;
}

type TodoPreview2 = Omit<Todo2, 'description'>;

const todo2: TodoPreview = {
    title: 'Clean room',
    completed: false,
};

//-------------------------Exclude<T,U>--------------------------------------------------------------

/*
Constructs a type by excluding from T all properties that are assignable to U.
*/

// Example 1)

type AvailableDrinks = 'Coffee' | 'Tea' | 'Juice' | 'Beer';

let john: AvailableDrinks = 'Coffee';

type JaneDoesnLike = 'Coffee' | 'Tea';

let Jane: Exclude<AvailableDrinks, JaneDoesnLike> = 'Juice';

// Example 2)
type T0 = Exclude<"a" | "b" | "c", "a">;  // "b" | "c"
type T1 = Exclude<"a" | "b" | "c", "a" | "b">;  // "c"
type T2 = Exclude<string | number | (() => void), Function>;  // string | number

//-------------------------Extract<T,U>--------------------------------------------------------------

/*
Constructs a type by extracting from T all properties that are assignable to U.
*/

type T00 = Extract<"a" | "b" | "c", "a" | "f">;  // "a"
type T11 = Extract<string | number | (() => void), Function>;  // () => void

//-------------------------NonNullable<T>--------------------------------------------------------------

/*
Constructs a type by excluding null and undefined from T.
*/

type T02 = NonNullable<string | number | undefined>;  // string | number
type T12 = NonNullable<string[] | null | undefined>;  // string[]

//-------------------------Parameters<T>--------------------------------------------------------------

/*
Constructs a tuple type of the types of the parameters of a function type T.
*/

declare function f1(arg: { a: number, b: string }): void
type T03 = Parameters<() => string>;  // []
type T13 = Parameters<(s: string) => void>;  // [string]
type T23 = Parameters<(<T>(arg: T) => T)>;  // [unknown]
type T43 = Parameters<typeof f1>;  // [{ a: number, b: string }]
type T53 = Parameters<any>;  // unknown[]
type T63 = Parameters<never>;  // never
//type T73 = Parameters<string>;  // Error
//type T83 = Parameters<Function>;  // Error

//-------------------------ConstructorParameters<T>--------------------------------------------------------------

/*
The ConstructorParameters<T> type lets us extract all parameter types of a constructor function type. 
It produces a tuple type with all the parameter types (or the type never if T is not a function).
*/

type T04 = ConstructorParameters<ErrorConstructor>;  // [(string | undefined)?]
type T14 = ConstructorParameters<FunctionConstructor>;  // string[]
type T24 = ConstructorParameters<RegExpConstructor>;  // [string, (string | undefined)?]

//-------------------------ReturnType<T>--------------------------------------------------------------

/*
Constructs a type consisting of the return type of function T.
*/

// Example 1)

function dummy(){
    return "dummy";
}

// const value12: ReturnType<typeof dummy> = dummy();

const value12: ReturnType<() => string> = dummy();

// Example 2)

declare function f1(): { a: number, b: string }
type T05 = ReturnType<() => string>;  // string
type T15 = ReturnType<(s: string) => void>;  // void
type T25 = ReturnType<(<T>() => T)>;  // {}
type T35 = ReturnType<(<T extends U, U extends number[]>() => T)>;  // number[]
type T45 = ReturnType<typeof f1>;  // { a: number, b: string }
type T55 = ReturnType<any>;  // any
type T65 = ReturnType<never>;  // any
//type T75 = ReturnType<string>;  // Error
//type T85 = ReturnType<Function>;  // Error

//-------------------------InstanceType<T>-----------------------------------------------------------

/*
Constructs a type consisting of the instance type of a constructor function type T.
*/

class C {
    x = 0;
    y = 0;
}

type T06 = InstanceType<typeof C>;  // C
type T16 = InstanceType<any>;  // any
type T26 = InstanceType<never>;  // any
//type T36 = InstanceType<string>;  // Error
//type T46 = InstanceType<Function>;  // Error

//-------------------------Required<T>-----------------------------------------------------------

/*
Constructs a type consisting of the instance type of a constructor function type T.
*/

interface Props {
    a?: number;
    b?: string;
};

const obj: Props = { a: 5 }; // OK

//const obj2: Required<Props> = { a: 5 }; // Error: property 'b' missing

//-------------------------ThisParameterType <T>------------------------------------------------------

/*
Extracts the type of the this parameter of a function type, or unknown if the function type has no 
this parameter.

Note: This type only works correctly if --strictFunctionTypes is enabled.
*/

function toHex(this: Number) {
    return this.toString(16);
}

function numberToString(n: ThisParameterType<typeof toHex>) {
    return toHex.apply(n);
}

//-------------------------OmitThisParameter ------------------------------------------------------

/*
Removes the ‘this’ parameter from a function type.

Note: This type only works correctly if --strictFunctionTypes is enabled.
*/

function toHex1(this: Number) {
    return this.toString(16);
}

// The return type of `bind` is already using `OmitThisParameter`, this is just for demonstration.
const fiveToHex: OmitThisParameter<typeof toHex1> = toHex1.bind(5);

console.log(fiveToHex());

//-------------------------ThisType<T>------------------------------------------------------

/*
This utility does not return a transformed type. Instead, it serves as a marker for a 
contextual this type. Note that the --noImplicitThis flag must be enabled to use this utility.
*/

// Compile with --noImplicitThis

// Example 1)

interface MyObject{
    display(): string;
}

interface MyObjectThis{
    display1(): string;
}

const myObj: MyObject & ThisType<MyObjectThis> = {
    display(){
        return this.display1();
    }
}

myObj.display = myObj.display.bind({
    display1(){
        return "display1";
    }
})

// Example 2)

type ObjectDescriptor<D, M> = {
    data?: D;
    methods?: M & ThisType<D & M>;  // Type of 'this' in methods is D & M
}

function makeObject<D, M>(desc: ObjectDescriptor<D, M>): D & M {
    let data: object = desc.data || {};
    let methods: object = desc.methods || {};
    return { ...data, ...methods } as D & M;
}

let obj1 = makeObject({
    data: { x: 0, y: 0 },
    methods: {
        moveBy(dx: number, dy: number) {
            this.x += dx;  // Strongly typed this
            this.y += dy;  // Strongly typed this
        }
    }
});

obj1.x = 10;
obj1.y = 20;
obj1.moveBy(5, 5);

/*
In the example above, the methods object in the argument to makeObject has a contextual type 
that includes ThisType<D & M> and therefore the type of this in methods within the methods 
object is { x: number, y: number } & { moveBy(dx: number, dy: number): number }. 
Notice how the type of the methods property simultaneously is an inference target and a 
source for the this type in methods.

The ThisType<T> marker interface is simply an empty interface declared in lib.d.ts. Beyond 
being recognized in the contextual type of an object literal, the interface acts like any 
empty interface.
*/