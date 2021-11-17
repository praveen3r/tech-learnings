console.log(this) //Global window object

//------------------------------------------------------------
function test(){
    console.log(this)
}

console.log(test()) 

//------------------------------------------------------------
var person = {
    firstName: "First",
    lastName: "LastName",
    fullName: function(){
        return this.firstName + " " + this.lastName
    }
}

console.log(person.fullName())

//------------------------------------------------------------

var person = {
    lastName: "LastName",
    fullName: function(){
        return this.firstName + " " + this.lastName
    }
}

person.firstName = "Test";
console.log(person.fullName())

//------------------------------------------------------------

function test(){
    console.log(this)
}

var person = {
    lastName: "LastName",
    fullName: function(){
        return this.firstName + " " + this.lastName
    },
    f:test
}

console.log(person.f())

//------------------------------------------------------------

function Circle(r){
    this.radius = r;
}

var cir = new Circle(2); //constructor

console.log(cir);

//------------------------------------------------------------

function Circle(r){
    this.radius = r;
}

Circle.prototype.area = function(){ return 3.14 * this.radius}

var cir = new Circle(2); //constructor

console.log(cir.area());