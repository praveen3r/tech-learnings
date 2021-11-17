/*
Math is a built-in object that has properties and methods for mathematical constants and functions. 
It’s not a function object.

Math works with the Number type. It doesn't work with BigInt.

Unlike many other global objects, Math is not a constructor. All properties and methods of Math are 
static. You refer to the constant pi as Math.PI and you call the sine function as Math.sin(x), 
where x is the method’s argument. Constants are defined with the full precision of real numbers in 
JavaScript.

Properties
-----------

Math.E
Euler's constant and the base of natural logarithms; approximately 2.718.

Math.LN2
Natural logarithm of 2; approximately 0.693.

Math.LN10
Natural logarithm of 10; approximately 2.303.

Math.LOG2E
Base 2 logarithm of E; approximately 1.443.

Math.LOG10E
Base 10 logarithm of E; approximately 0.434.

Math.PI
Ratio of the a circle's circumference to its diameter; approximately 3.14159.

Math.SQRT1_2
Square root of ½ (or equivalently, 1/√2); approximately 0.707.

Math.SQRT2
Square root of 2; approximately 1.414.
*/

//--------------------------abs--------------------------------------------

// Math.abs(x)

/*
The Math.abs() function returns the absolute value of a number, that is

Math.abs(x)=|x|={ x	if x>0	and 0	if x=0	and -x	if x<0 }
*/

Math.abs('-1');     // 1
Math.abs(-2);       // 2
Math.abs(null);     // 0
Math.abs('');       // 0
Math.abs([]);       // 0
Math.abs([2]);      // 2
Math.abs([1,2]);    // NaN
Math.abs({});       // NaN
Math.abs('string'); // NaN
Math.abs();         // NaN

//--------------------------cbrt--------------------------------------------

//Math.cbrt(x)

/*
The Math.cbrt() function returns the cube root of a number, that is
*/

Math.cbrt(NaN); // NaN
Math.cbrt(-1); // -1
Math.cbrt(-0); // -0
Math.cbrt(-Infinity); // -Infinity
Math.cbrt(0); // 0
Math.cbrt(1); // 1
Math.cbrt(Infinity); // Infinity
Math.cbrt(null); // 0
Math.cbrt(2);  // 1.2599210498948732

//--------------------------cbrt-----------------------------------------------------------------------

//Math.ceil(x)

/*
The Math.ceil() function always rounds a number up to the next largest whole number or integer.
*/

Math.ceil(.95);    // 1
Math.ceil(4);      // 4
Math.ceil(7.004);  // 8
Math.ceil(-0.95);  // -0
Math.ceil(-4);     // -4
Math.ceil(-7.004); // -7

//Decimal adjustment
//-----------------------

// Closure
(function() {
    /**
     * Decimal adjustment of a number.
     *
     * @param {String}  type  The type of adjustment.
     * @param {Number}  value The number.
     * @param {Integer} exp   The exponent (the 10 logarithm of the adjustment base).
     * @returns {Number} The adjusted value.
     */
    function decimalAdjust(type, value, exp) {
      // If the exp is undefined or zero...
      if (typeof exp === 'undefined' || +exp === 0) {
        return Math[type](value);
      }
      value = +value;
      exp = +exp;
      // If the value is not a number or the exp is not an integer...
      if (isNaN(value) || !(typeof exp === 'number' && exp % 1 === 0)) {
        return NaN;
      }
      // Shift
      value = value.toString().split('e');
      value = Math[type](+(value[0] + 'e' + (value[1] ? (+value[1] - exp) : -exp)));
      // Shift back
      value = value.toString().split('e');
      return +(value[0] + 'e' + (value[1] ? (+value[1] + exp) : exp));
    }
  
    // Decimal round
    if (!Math.round10) {
      Math.round10 = function(value, exp) {
        return decimalAdjust('round', value, exp);
      };
    }
    // Decimal floor
    if (!Math.floor10) {
      Math.floor10 = function(value, exp) {
        return decimalAdjust('floor', value, exp);
      };
    }
    // Decimal ceil
    if (!Math.ceil10) {
      Math.ceil10 = function(value, exp) {
        return decimalAdjust('ceil', value, exp);
      };
    }
  })();
  
  // Round
  Math.round10(55.55, -1);   // 55.6
  Math.round10(55.549, -1);  // 55.5
  Math.round10(55, 1);       // 60
  Math.round10(54.9, 1);     // 50
  Math.round10(-55.55, -1);  // -55.5
  Math.round10(-55.551, -1); // -55.6
  Math.round10(-55, 1);      // -50
  Math.round10(-55.1, 1);    // -60
  // Floor
  Math.floor10(55.59, -1);   // 55.5
  Math.floor10(59, 1);       // 50
  Math.floor10(-55.51, -1);  // -55.6
  Math.floor10(-51, 1);      // -60
  // Ceil
  Math.ceil10(55.51, -1);    // 55.6
  Math.ceil10(51, 1);        // 60
  Math.ceil10(-55.59, -1);   // -55.5
  Math.ceil10(-59, 1);       // -50

//--------------------------exp-----------------------------------------------------------------------

//Math.exp(x)

/*
The Math.exp() function returns e power x, where x is the argument, and e is Euler's number 
(also known as Napier's constant), the base of the natural logarithms.
*/

Math.exp(-1); // 0.36787944117144233
Math.exp(0);  // 1
Math.exp(1);  // 2.718281828459045

//--------------------------floor-----------------------------------------------------------------------

//Math.floor(x)

/*
The Math.floor() function returns the largest integer less than or equal to a given number.
*/

Math.floor( 45.95); //  45
Math.floor( 45.05); //  45
Math.floor(  4   ); //   4
Math.floor(-45.05); // -46 
Math.floor(-45.95); // -46

//Decimal adjustment
//-------------------

/**
 * Decimal adjustment of a number.
 *
 * @param {String}  type  The type of adjustment.
 * @param {Number}  value The number.
 * @param {Integer} exp   The exponent (the 10 logarithm of the adjustment base).
 * @returns {Number} The adjusted value.
 */
function decimalAdjust(type, value, exp) {
    // If the exp is undefined or zero...
    if (typeof exp === 'undefined' || +exp === 0) {
      return Math[type](value);
    }
    value = +value;
    exp = +exp;
    // If the value is not a number or the exp is not an integer...
    if (isNaN(value) || !(typeof exp === 'number' && exp % 1 === 0)) {
      return NaN;
    }
    // Shift
    value = value.toString().split('e');
    value = Math[type](+(value[0] + 'e' + (value[1] ? (+value[1] - exp) : -exp)));
    // Shift back
    value = value.toString().split('e');
    return +(value[0] + 'e' + (value[1] ? (+value[1] + exp) : exp));
  }
  
  // Decimal round
  const round10 = (value, exp) => decimalAdjust('round', value, exp);
  // Decimal floor
  const floor10 = (value, exp) => decimalAdjust('floor', value, exp);
  // Decimal ceil
  const ceil10 = (value, exp) => decimalAdjust('ceil', value, exp);
  
  // Round
  round10(55.55, -1);   // 55.6
  round10(55.549, -1);  // 55.5
  round10(55, 1);       // 60
  round10(54.9, 1);     // 50
  round10(-55.55, -1);  // -55.5
  round10(-55.551, -1); // -55.6
  round10(-55, 1);      // -50
  round10(-55.1, 1);    // -60
  // Floor
  floor10(55.59, -1);   // 55.5
  floor10(59, 1);       // 50
  floor10(-55.51, -1);  // -55.6
  floor10(-51, 1);      // -60
  // Ceil
  ceil10(55.51, -1);    // 55.6
  ceil10(51, 1);        // 60
  ceil10(-55.59, -1);   // -55.5
  ceil10(-59, 1);       // -50

//--------------------------fround-----------------------------------------------------------------------

//var singleFloat = Math.fround(doubleFloat);

/*
The Math.fround() function returns the nearest 32-bit single precision float representation of a Number.

JavaScript uses 64-bit double floating-point numbers internally, which offer a very high precision. 
However, sometimes you may be working with 32-bit floating-point numbers, for example if you are 
reading values from a Float32Array. This can create confusion: Checking a 64-bit float and a 32-bit 
float for equality may fail even though the numbers are seemingly identical.

To solve this, Math.fround() can be used to cast the 64-bit float to a 32-bit float. Internally, 
JavaScript continues to treat the number as a 64-bit float, it just performs a "round to even" on 
the 23rd bit of the mantissa, and sets all following mantissa bits to 0. If the number is outside 
the range of a 32-bit float, Infinity or -Infinity is returned.

Because fround() is a static method of Math, you always use it as Math.fround(), rather than as a 
method of a Math object you created (Math is not a constructor).
*/

//The number 1.5 can be precisely represented in the binary numeral system, and is identical
// in 32-bit and 64-bit:

Math.fround(1.5); // 1.5
Math.fround(1.5) === 1.5; // true

//However, the number 1.337 cannot be precisely represented in the binary numeral system, 
//so it differs in 32-bit and 64-bit:

Math.fround(1.337); // 1.3370000123977661
Math.fround(1.337) === 1.337; // false

//2150 is too big for a 32-bit float, so Infinity is returned:
2 ** 150; // 1.42724769270596e+45
Math.fround(2 ** 150); // Infinity

//If the parameter cannot be converted to a number, or it is not-a-number (NaN), 
//Math.fround() will return NaN:

Math.fround('abc'); // NaN
Math.fround(NaN); // NaN

//--------------------------imul-----------------------------------------------------------------------

//var product = Math.imul(a, b);

/*
The Math.imul() function returns the result of the C-like 32-bit multiplication of the two parameters.

Math.imul() allows for 32-bit integer multiplication with C-like semantics. This feature is useful for 
projects like Emscripten. Because imul() is a static method of Math, you always use it as Math.imul(), 
rather than as a method of a Math object you created (Math is not a constructor). If you use normal 
JavaScript floating point numbers in imul, you will experience a degrade in performance. This is 
because of the costly conversion from a floating point to an integer for multiplication, and then 
converting the multiplied integer back into a floating point. The reason imul exists is because it is 
faster in only one (so far) circumstance: AsmJS. AsmJS allows for JIST-optimizers to more easily 
implement internal integers in JavaScript. Multiplying two numbers stored internally as integers 
(which is only possible with AsmJS) with imul is the only potential circumstance where Math.imul may 
prove performant in current browsers.
*/

Math.imul(2, 4);          // 8
Math.imul(-1, 8);         // -8
Math.imul(-2, -2);        // 4
Math.imul(0xffffffff, 5); // -5
Math.imul(0xfffffffe, 5); // -10

//--------------------------log-----------------------------------------------------------------------

//Math.log(x)

/*
The Math.log() function returns the natural logarithm (base e) of a number, that is

∀x>0,Math.log(x)=ln(x)=the uniqueysuch thatey=x

The JavaScript Math.log() function is equivalent to ln(x) in mathematics.

If the value of x is 0, the return value is always -Infinity.

If the value of x is negative, the return value is always NaN.

Because log() is a static method of Math, you always use it as Math.log(), rather than as a method of a 
Math object you created (Math is not a constructor).

If you need the natural log of 2 or 10, use the constants Math.LN2 or Math.LN10 .  If you need a 
logarithm to base 2 or 10, use Math.log2() or Math.log10() .  If you need a logarithm to other bases, 
use Math.log(x) / Math.log(otherBase) as in the example below; you might want to precalculate 
1 / Math.log(otherBase) .
*/

Math.log(-1); // NaN, out of range
Math.log(0);  // -Infinity
Math.log(1);  // 0
Math.log(10); // 2.302585092994046

//Using Math.log() with a different base

function getBaseLog(x, y) {
    return Math.log(y) / Math.log(x);
  }

  /*
  If you run getBaseLog(10, 1000) it returns 2.9999999999999996 due to floating-point rounding, which is 
  very close to the actual answer of 3.
  */

  
//--------------------------max-----------------------------------------------------------------------

//Math.max([value1[, value2[, ...]]])

/*
The Math.max() function returns the largest of zero or more numbers.

Because Math is not a constructor, max() is a static method of Math (You always use it as Math.max(), 
rather than as a method of an instanced Math object).

-Infinity is the initial comparant because almost every other value is bigger, that's why when no 
arguments are given, -Infinity is returned.

If at least one of arguments cannot be converted to a number, the result is NaN.
*/

Math.max(10, 20);   //  20
Math.max(-10, -20); // -10
Math.max(-10, 20);  //  20

//Getting the maximum element of an array

//Array.reduce() can be used to find the maximum element in a numeric array, by comparing each value:
var arr = [1,2,3];
var max = arr.reduce(function(a, b) {
    return Math.max(a, b);
});

// or

//This should only be used for arrays with relatively few elements.
function getMaxOfArray(numArray) {
    return Math.max.apply(null, numArray);
  }

//or

//This should only be used for arrays with relatively few elements.
var arr = [1, 2, 3];
var max = Math.max(...arr);

/* 
However, both spread (...) and apply will either fail or return the wrong result if the array 
has too many elements, because they try to pass the array elements as function parameters.
*/

//--------------------------min-----------------------------------------------------------------------

//Math.min([value1[, value2[, ...]]])

/*
The static function Math.min() returns the lowest-valued number passed into it, or NaN if any 
parameter isn't a number and can't be converted into one.
*/

var x = 10, y = -20;
var z = Math.min(x, y);

//--------------------------pow-----------------------------------------------------------------------

//Math.pow(base, exponent)

/*
The Math.pow() function returns the base to the exponent power, that is, base power exponent.
*/

Math.pow(7, 2);    // 49
Math.pow(7, 3);    // 343
Math.pow(2, 10);   // 1024
// fractional exponents
Math.pow(4, 0.5);  // 2 (square root of 4)
Math.pow(8, 1/3);  // 2 (cube root of 8)
Math.pow(2, 0.5);  // 1.4142135623730951 (square root of 2)
Math.pow(2, 1/3);  // 1.2599210498948732 (cube root of 2)
// signed exponents
Math.pow(7, -2);   // 0.02040816326530612 (1/49)
Math.pow(8, -1/3); // 0.5
// signed bases
Math.pow(-7, 2);   // 49 (squares are positive)
Math.pow(-7, 3);   // -343 (cubes can be negative)
Math.pow(-7, 0.5); // NaN (negative numbers don't have a real square root)
// due to "even" and "odd" roots laying close to each other, 
// and limits in the floating number precision, 
// negative bases with fractional exponents always return NaN
Math.pow(-7, 1/3); // NaN

//--------------------------random-----------------------------------------------------------------------

//Math.random()

/*
The Math.random() function returns a floating-point, pseudo-random number in the range 0 to less 
than 1 (inclusive of 0, but not 1) with approximately uniform distribution over that range — which you 
can then scale to your desired range. The implementation selects the initial seed to the random number 
generation algorithm; it cannot be chosen or reset by the user.
*/

//Getting a random number between 0 (inclusive) and 1 (exclusive)

function getRandom() {
    return Math.random();
  }

//Getting a random number between two values

function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
  }

//Getting a random integer between two values

function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
  }

//Getting a random integer between two values

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min; //The maximum is exclusive and the minimum is inclusive
  }

//Getting a random integer between two values, inclusive

function getRandomIntInclusive(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min; //The maximum is inclusive and the minimum is inclusive 
  }

//--------------------------round-----------------------------------------------------------------------

//Math.round(x)

/*
The Math.round() function returns the value of a number rounded to the nearest integer.

If the fractional portion of the argument is greater than 0.5, the argument is rounded to the integer 
with the next higher absolute value. If it is less than 0.5, the argument is rounded to the integer 
with the lower absolute value.  If the fractional portion is exactly 0.5, the argument is rounded to 
the next integer in the direction of +∞.  Note that this differs from many languages' round() functions, 
which often round this case to the next integer away from zero, instead giving a different result in 
the case of negative numbers with a fractional part of exactly 0.5.

Because round() is a static method of Math, you always use it as Math.round(), rather than as a method 
of a Math object you created (Math has no constructor).
*/

Math.round( 20.49); //  20
Math.round( 20.5 ); //  21
Math.round( 42   ); //  42
Math.round(-20.5 ); // -20
Math.round(-20.51); // -21

function vanilla_round(x) {
    var y = Math.abs(x) + 0.5; // so that less than 1/2 rounds down; greater rounds up
    return Math.floor(x+0.5)
}

//The modulus operator above gets the decimal part of x. Further, the above code snippet 
//could be modified to round to a certain precision on a number:

function round_to_precision(x, precision) {
    var y = +x + (precision === undefined ? 0.5 : precision/2);
    return y - (y % (precision === undefined ? 1 : +precision));
}

round_to_precision(11, 2); // outputs 12
round_to_precision(11, 3); // outputs 12
round_to_precision(11, 4); // outputs 12
round_to_precision(11, 5); // outputs 10
round_to_precision(11, 6); // outputs 12
round_to_precision(11, 7); // outputs 14
round_to_precision(11, 8); // outputs 8
round_to_precision(3.7, 0.5); // outputs 3.5
round_to_precision(3.75, 0.5); // outputs 4
round_to_precision(3.8, 0.5); // outputs 4

//--------------------------sign-----------------------------------------------------------------------

//Math.sign(x)

/*
The Math.sign() function returns either a positive or negative +/- 1, indicating the sign of a number 
passed into the argument. If the number passed into Math.sign() is 0, it will return a +/- 0. Note 
that if the number is positive, an explicit (+) will not be returned.
*/

Math.sign(3);     //  1
Math.sign(-3);    // -1
Math.sign('-3');  // -1
Math.sign(0);     //  0
Math.sign(-0);    // -0
Math.sign(NaN);   // NaN
Math.sign('foo'); // NaN
Math.sign();      // NaN

//--------------------------sqrt-----------------------------------------------------------------------

//Math.sqrt(x)

/*
If the value of x is negative, Math.sqrt() returns NaN.
*/

Math.sqrt(9); // 3
Math.sqrt(2); // 1.414213562373095

Math.sqrt(1);  // 1
Math.sqrt(0);  // 0
Math.sqrt(-1); // NaN
Math.sqrt(-0); // -0

//--------------------------trunc-----------------------------------------------------------------------

//Math.trunc(x)

/*
The Math.trunc() function returns the integer part of a number by removing any fractional digits.
*/

Math.trunc(13.37);    // 13
Math.trunc(42.84);    // 42
Math.trunc(0.123);    //  0
Math.trunc(-0.123);   // -0
Math.trunc('-1.123'); // -1
Math.trunc(NaN);      // NaN
Math.trunc('foo');    // NaN
Math.trunc();         // NaN