/*
The value passed as the first parameter is converted to a boolean value, if necessary. If the value is 
omitted or is 0, -0, null, false, NaN, undefined, or the empty string (""), the object has an initial 
value of false. All other values, including any object, an empty array ([]), or the string "false", 
create an object with an initial value of true.

Do not confuse the primitive Boolean values true and false with the true and false values of the Boolean 
object.

Any object of which the value is not undefined or null, including a Boolean object whose value is false, 
evaluates to true when passed to a conditional statement. For example, the condition in the following if 
statement evaluates to true:

var x = new Boolean(false);
if (x) {
  // this code is executed
}
This behavior does not apply to Boolean primitives. For example, the condition in the following if 
statement evaluates to false:

var x = false;
if (x) {
  // this code is not executed
}
Do not use a Boolean object to convert a non-boolean value to a boolean value. To perform this task, 
instead, use Boolean as a function, or a double NOT operator:

var x = Boolean(expression);     // use this...
var x = !!(expression);          // ...or this
var x = new Boolean(expression); // don't use this!
If you specify any object, including a Boolean object whose value is false, as the initial value of a 
Boolean object, the new Boolean object has a value of true.

var myFalse = new Boolean(false);   // initial value of false
var g = Boolean(myFalse);       // initial value of true
var myString = new String('Hello'); // string object
var s = Boolean(myString);      // initial value of true
Do not use a Boolean object in place of a Boolean primitive.

Note: When the non-standard property document.all is used as an argument for this constructor, the 
result is a Boolean object with the value false. This property is legacy and non-standard and should 
not be used.
*/