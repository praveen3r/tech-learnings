// IIFE
var firstname = 'John';

(function(name) {
    
    var greeting = 'Hello';
    console.log(greeting + ' ' + name);
    
}(firstname)); // IIFE

var greeting = function(name){
    console.log(name)
}('John');

console.log(greeting)