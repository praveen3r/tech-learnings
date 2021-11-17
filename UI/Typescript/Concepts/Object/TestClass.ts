//------------------------------------------------------------------------------------

class Greeter {
    greeting: string;
    constructor(message: string) {
        this.greeting = message;
    }
    greet() {
        return "Hello, " + this.greeting;
    }
}

let greeter = new Greeter("world");

//------------------------------Using this------------------------------------------------------

class Department {
    name: string;
  
    constructor(n: string) {
      this.name = n;
    }
  
    describe(this: Department) {
      console.log('Department: ' + this.name);
    }
  }
  
  const accounting = new Department('Accounting');
  
  accounting.describe();
  
  const accountingCopy = { name: 'DUMMY', describe: accounting.describe };
  
  accountingCopy.describe();

//------------------------------Modifiers------------------------------------------------------

/* 
Public by default #
In our examples, we’ve been able to freely access the members that we declared throughout our 
programs. If you’re familiar with classes in other languages, you may have noticed in the above 
examples we haven’t had to use the word public to accomplish this; for instance, C# requires that 
each member be explicitly labeled public to be visible. In TypeScript, each member is public by 
default.
*/

//You may still mark a member public explicitly. 

class Animal {
    public name: string;

    public constructor(theName: string) { 
        this.name = theName; 
    }

    public move(distanceInMeters: number) {
        console.log(`${this.name} moved ${distanceInMeters}m.`);
    }
}

//-----------------------------ECMAScript Private Fields #----------------------------

// class Animal1 {
//     #name: string;
//     constructor(theName: string) { 
//         this.#name = theName; 
//     }
// }

//new Animal1("Cat").#name; // Property '#name' is not accessible outside class 'Animal' because 
//it has a private identifier.

//------------------------------Understanding TypeScript’s private-----------------------------

/*
TypeScript also has it’s own way to declare a member as being marked private, it cannot be 
accessed from outside of its containing class. For example:
*/

class Animal2 {
    private name: string;
    constructor(theName: string) { this.name = theName; }
}

//new Animal2("Cat").name; // Error: 'name' is private;


//---------------------------Shorthand(Parameter properties)--------------------------------------

class Octopus {

    constructor(private name: string) {
        this.name = name;
    }
}

console.log(new Octopus("test"));

//---------------------------Read-only--------------------------------------

/*
You can make properties readonly by using the readonly keyword. 
Readonly properties must be initialized at their declaration or in the constructor.
*/
class Octopus1 {

    constructor(private readonly name: string) {
        this.name = name;
    }
}

let dad = new Octopus("Man with the 8 strong legs");
//dad.name = "Man with the 3-piece suit"; // error! name is readonly.

//------------------------Inheritance -----------------------------------------

class Animal3 {
    name: string;
    constructor(theName: string) { this.name = theName; }
    move(distanceInMeters: number = 0) {
        console.log(`${this.name} moved ${distanceInMeters}m.`);
    }
}

class Snake extends Animal3 {
    constructor(name: string) { super(name); }
    move(distanceInMeters = 5) {
        console.log("Slithering...");
        super.move(distanceInMeters);
    }
}

class Horse extends Animal3 {
    constructor(name: string) { super(name); }
    move(distanceInMeters = 45) {
        console.log("Galloping...");
        super.move(distanceInMeters);
    }
}

let sam = new Snake("Sammy the Python");
let tom: Animal3 = new Horse("Tommy the Palomino");

sam.move();
tom.move(34);


//------------------------protected-----------------------------------------

class Person {
    protected name: string;
    constructor(name: string) { this.name = name; }
}

class Employee extends Person {
    private department: string;

    constructor(name: string, department: string) {
        super(name);
        this.department = department;
    }

    public getElevatorPitch() {
        return `Hello, my name is ${this.name} and I work in ${this.department}.`;
    }
}

let howard = new Employee("Howard", "Sales");
console.log(howard.getElevatorPitch());
//console.log(howard.name); // error

/*
Notice that while we can’t use name from outside of Person, we can still use it from within an 
instance method of Employee because Employee derives from Person.

A constructor may also be marked protected. This means that the class cannot be instantiated outside 
of its containing class, but can be extended. For example,
*/

class Person2 {
    protected name: string;
    protected constructor(theName: string) { this.name = theName; }
}

// Employee can extend Person
class Employee2 extends Person2 {
    private department: string;

    constructor(name: string, department: string) {
        super(name);
        this.department = department;
    }

    public getElevatorPitch() {
        return `Hello, my name is ${this.name} and I work in ${this.department}.`;
    }
}

let howard1 = new Employee2("Howard", "Sales");
//let john = new Person2("John"); // Error: The 'Person' constructor is protected

//------------------------getters/setters-----------------------------------------------------------

/* 
TypeScript supports getters/setters as a way of intercepting accesses to a member of an object. 
This gives you a way of having finer-grained control over how a member is accessed on each object.
*/

const fullNameMaxLength = 10;

class Employee4 {
    private _fullName: string;

    constructor(){
        this._fullName = '';
    }

    get fullName(): string {
        return this._fullName;
    }

    set fullName(newName: string) {
        if (newName && newName.length > fullNameMaxLength) {
            throw new Error("fullName has a max length of " + fullNameMaxLength);
        }
        
        this._fullName = newName;
    }
}

let employee = new Employee4();
employee.fullName = "Bob Smith";
if (employee.fullName) {
    console.log(employee.fullName);
}

//------------------------Static Properties -----------------------------------------------

class Grid {
    static display(){
        console.log("displaying")
    }
}

console.log(Grid.display());

//------------------------Abstract-----------------------------------------------

abstract class Department4 {

    constructor(public name: string) {
    }

    printName(): void {
        console.log("Department name: " + this.name);
    }

    abstract printMeeting(): void; // must be implemented in derived classes
}

class AccountingDepartment extends Department4 {

    constructor() {
        super("Accounting and Auditing"); // constructors in derived classes must call super()
    }

    printMeeting(): void {
        console.log("The Accounting Department meets each Monday at 10am.");
    }

    generateReports(): void {
        console.log("Generating accounting reports...");
    }
}

let department: Department4; // ok to create a reference to an abstract type
//department = new Department4(); // error: cannot create an instance of an abstract class
department = new AccountingDepartment(); // ok to create and assign a non-abstract subclass
department.printName();
department.printMeeting();
//department.generateReports(); // error: method doesn't exist on declared abstract type

//------------------------Singleton-----------------------------------------------

/**
 * The Singleton class defines the `getInstance` method that lets clients access
 * the unique singleton instance.
 */
class Singleton {
    private static instance: Singleton;

    /**
     * The Singleton's constructor should always be private to prevent direct
     * construction calls with the `new` operator.
     */
    private constructor() { }

    /**
     * The static method that controls the access to the singleton instance.
     *
     * This implementation let you subclass the Singleton class while keeping
     * just one instance of each subclass around.
     */
    public static getInstance(): Singleton {
        if (!Singleton.instance) {
            Singleton.instance = new Singleton();
        }

        return Singleton.instance;
    }

    /**
     * Finally, any singleton should define some business logic, which can be
     * executed on its instance.
     */
    public someBusinessLogic() {
        // ...
    }
}

/**
 * The client code.
 */
function clientCode() {
    const s1 = Singleton.getInstance();
    const s2 = Singleton.getInstance();

    if (s1 === s2) {
        console.log('Singleton works, both variables contain the same instance.');
    } else {
        console.log('Singleton failed, variables contain different instances.');
    }
}

//------------------------Abstract-----------------------------------------------