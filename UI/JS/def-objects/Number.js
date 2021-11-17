/*
The Number JavaScript object is a wrapper object allowing you to work with numerical values. 
A Number object is created using the Number() constructor. A primitive type object number is 
created using the Number() function.

The JavaScript Number type is double-precision 64-bit binary format IEEE 754 value. In more recent 
implementations, JavaScript also supports integers with arbitrary precision using the BigInt type.

Properties
------------

Number.EPSILON
The smallest interval between two representable numbers.

Number.MAX_SAFE_INTEGER
The maximum safe integer in JavaScript (253 - 1).

Number.MAX_VALUE
The largest positive representable number.

Number.MIN_SAFE_INTEGER
The minimum safe integer in JavaScript (-(253 - 1)).

Number.MIN_VALUE
The smallest positive representable number—that is, the positive number closest to zero 
(without actually being zero).

Number.NaN
Special "Not a Number" value.

Number.NEGATIVE_INFINITY
Special value representing negative infinity. Returned on overflow.

Number.POSITIVE_INFINITY
Special value representing infinity. Returned on overflow.

Number.prototype
Allows the addition of properties to the Number object.
*/

//--------------------------Convert numeric strings and null to numbers---------------------------------

Number('123')     // 123
Number('12.3')    // 12.3
Number('12.00')   // 12
Number('123e-1')  // 12.3
Number('')        // 0
Number(null)      // 0
Number('0x11')    // 17
Number('0b11')    // 3
Number('0o11')    // 9
Number('foo')     // NaN
Number('100a')    // NaN
Number('-Infinity') //-Infinity

//--------------------------isNaN---------------------------------------------------------------------

//Number.isNaN(value)

/*
The Number.isNaN() method determines whether the passed value is NaN and its type is Number. 
It is a more robust version of the original, global isNaN().

Due to both equality operators, == and ===, evaluating to false when checking if NaN is NaN, the function Number.isNaN() has become necessary. This situation is unlike all other possible value comparisons in JavaScript.

In comparison to the global isNaN() function, Number.isNaN() doesn't suffer the problem of forcefully 
converting the parameter to a number. This means it is now safe to pass values that would normally 
convert to NaN, but aren't actually the same value as NaN. This also means that only values of the 
type number, that are also NaN, return true.
*/

Number.isNaN(NaN);        // true
Number.isNaN(Number.NaN); // true
Number.isNaN(0 / 0);      // true

// e.g. these would have been true with global isNaN()
Number.isNaN('NaN');      // false
Number.isNaN(undefined);  // false
Number.isNaN({});         // false
Number.isNaN('blabla');   // false

// These all return false
Number.isNaN(true);
Number.isNaN(null);
Number.isNaN(37);
Number.isNaN('37');
Number.isNaN('37.37');
Number.isNaN('');
Number.isNaN(' ');

//--------------------------isFinite---------------------------------------------------------------------

//Number.isFinite(value)

/*
The Number.isFinite() method determines whether the passed value is a finite number.
*/

Number.isFinite(Infinity);  // false
Number.isFinite(NaN);       // false
Number.isFinite(-Infinity); // false

Number.isFinite(0);         // true
Number.isFinite(2e64);      // true

Number.isFinite('0');       // false, would've been true with
                            // global isFinite('0')
Number.isFinite(null);      // false, would've been true with
                            // global isFinite(null)

//--------------------------isSafeInteger---------------------------------------------------------------------

//Number.isSafeInteger(testValue)

/*
The Number.isSafeInteger() method determines whether the provided value is a number that is a safe integer.

A safe integer is an integer that

can be exactly represented as an IEEE-754 double precision number, and
whose IEEE-754 representation cannot be the result of rounding any other integer to fit the 
IEEE-754 representation.
For example, 253 - 1 is a safe integer: it can be exactly represented, and no other integer rounds to 
it under any IEEE-754 rounding mode. In contrast, 253 is not a safe integer: it can be exactly 
represented in IEEE-754, but the integer 253 + 1 can't be directly represented in IEEE-754 but 
instead rounds to 253 under round-to-nearest and round-to-zero rounding.  The safe integers consist 
of all integers from -(253 - 1) inclusive to 253 - 1 inclusive (± 9007199254740991 or 
± 9,007,199,254,740,991).  

Handling values larger or smaller than ~9 quadrillion with full precision requires using an 
arbitrary precision arithmetic library.  See What Every Programmer Needs to Know about Floating 
Point Arithmetic for more information on floating point representations of numbers.

For larger integers, consider using the BigInt type.
*/                            

Number.isSafeInteger(3);                    // true
Number.isSafeInteger(Math.pow(2, 53));      // false
Number.isSafeInteger(Math.pow(2, 53) - 1);  // true
Number.isSafeInteger(NaN);                  // false
Number.isSafeInteger(Infinity);             // false
Number.isSafeInteger('3');                  // false
Number.isSafeInteger(3.1);                  // false
Number.isSafeInteger(3.0);                  // true

//--------------------------parseFloat------------------------------------------------------------------

//Number.parseFloat(value)

/*
The Number.parseFloat() method parses an argument and returns a floating point number. If a number 
cannot be parsed from the argument, it returns NaN.
*/

function circumference(r) {
    if (Number.isNaN(Number.parseFloat(r))) {
      return 0;
    }
    return parseFloat(r) * 2.0 * Math.PI ;
  }
  
  console.log(circumference('4.567abcdefgh'));
  // expected output: 28.695307297889173
  
  console.log(circumference('abcdefgh'));
  // expected output: 0

//--------------------------parseInt------------------------------------------------------------------

//Number.parseInt(string,[ radix])

/*
The Number.parseInt() method parses a string argument and returns an integer of the specified 
radix or base.
*/

function roughScale(x, base) {
    const parsed = Number.parseInt(x, base);
    if (Number.isNaN(parsed)) {
      return 0;
    }
    return parsed * 100;
  }
  
  console.log(roughScale(' 0xF', 16));
  // expected output: 1500
  
  console.log(roughScale('321', 2));
  // expected output: 0

//--------------------------toExponential----------------------------------------------------------------

//numObj.toExponential([fractionDigits])

/*
The toExponential() method returns a string representing the Number object in exponential notation.

If the fractionDigits argument is omitted, the number of digits after the decimal point defaults to 
the number of digits necessary to represent the value uniquely.

If you use the toExponential() method for a numeric literal and the numeric literal has no exponent 
and no decimal point, leave whitespace(s) before the dot that precedes the method call to prevent 
the dot from being interpreted as a decimal point.

If a number has more digits than requested by the fractionDigits parameter, the number is rounded 
to the nearest number represented by fractionDigits digits. See the discussion of rounding in the 
description of the toFixed() method, which also applies to toExponential().
*/

var numObj = 77.1234;

console.log(numObj.toExponential());  // logs 7.71234e+1
console.log(numObj.toExponential(4)); // logs 7.7123e+1
console.log(numObj.toExponential(2)); // logs 7.71e+1
console.log(77.1234.toExponential()); // logs 7.71234e+1
console.log(77 .toExponential());     // logs 7.7e+1

//--------------------------toFixed----------------------------------------------------------------

//numObj.toFixed([digits])

/*
The toFixed() method formats a number using fixed-point notation.

toFixed() returns a string representation of numObj that does not use exponential notation and has 
exactly digits digits after the decimal place. The number is rounded if necessary, and the fractional 
part is padded with zeros if necessary so that it has the specified length. If the absolute value of 
numObj is greater or equal to 1e+21, this method simply calls Number.prototype.toString() and returns 
a string in exponential notation.
*/

let numObj = 12345.6789

numObj.toFixed()       // Returns '12346': note rounding, no fractional part
numObj.toFixed(1)      // Returns '12345.7': note rounding
numObj.toFixed(6)      // Returns '12345.678900': note added zeros
(1.23e+20).toFixed(2)  // Returns '123000000000000000000.00'
(1.23e-10).toFixed(2)  // Returns '0.00'
2.34.toFixed(1)        // Returns '2.3'
2.35.toFixed(1)        // Returns '2.4'. Note it rounds up
2.55.toFixed(1)        // Returns '2.5'. Note it rounds down - see warning above
-2.34.toFixed(1)       // Returns -2.3 (due to operator precedence, negative number literals don't return a string...)
(-2.34).toFixed(1)     // Returns '-2.3' 

//--------------------------toPrecision----------------------------------------------------------------

//numObj.toFixed([digits])

/*
The toFixed() method formats a number using fixed-point notation.

toFixed() returns a string representation of numObj that does not use exponential notation and has 
exactly digits digits after the decimal place. The number is rounded if necessary, and the fractional 
part is padded with zeros if necessary so that it has the specified length. If the absolute value of 
numObj is greater or equal to 1e+21, this method simply calls Number.prototype.toString() and returns 
a string in exponential notation.
*/

let numObj = 5.123456

console.log(numObj.toPrecision())    // logs '5.123456'
console.log(numObj.toPrecision(5))   // logs '5.1235'
console.log(numObj.toPrecision(2))   // logs '5.1'
console.log(numObj.toPrecision(1))   // logs '5'

numObj = 0.000123

console.log(numObj.toPrecision())    // logs '0.000123'
console.log(numObj.toPrecision(5))   // logs '0.00012300'
console.log(numObj.toPrecision(2))   // logs '0.00012'
console.log(numObj.toPrecision(1))   // logs '0.0001' 

// note that exponential notation might be returned in some circumstances
console.log((1234.5).toPrecision(2)) // logs '1.2e+3'
