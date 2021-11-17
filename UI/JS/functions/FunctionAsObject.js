var person = {
    firstName: "First",
    lastName: "LastName",
    fullName: function(){
        return this.firstName + " " + this.lastName
    }
}

console.log(person.fullName())

function Person(firstname, lastname) {
 
    console.log(this);
    this.firstname = firstname;
    this.lastname = lastname;
    console.log('This function is invoked.');
    
}

var john = new Person('John', 'Doe');
console.log(john);

var jane = new Person('Jane', 'Doe');
console.log(jane);