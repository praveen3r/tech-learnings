/*
BigInt is a built-in object that provides a way to represent whole numbers larger than 2 power 53 - 1, 
which is the largest number JavaScript can reliably represent with the Number primitive and represented 
by the Number.MAX_SAFE_INTEGER constant. BigInt can be used for arbitrarily large integers.

A BigInt is created by appending n to the end of an integer literal — 10n — or by calling the function 
BigInt().

const theBiggestInt = 9007199254740991n

const alsoHuge = BigInt(9007199254740991)
// ↪ 9007199254740991n

const hugeString = BigInt("9007199254740991")
// ↪ 9007199254740991n

const hugeHex = BigInt("0x1fffffffffffff")
// ↪ 9007199254740991n

const hugeBin = BigInt("0b11111111111111111111111111111111111111111111111111111")
// ↪ 9007199254740991n
BigInt is similar to Number in some ways, but also differs in a few key matters — it cannot be used 
with methods in the built-in Math object and cannot be mixed with instances of Number in operations; 
they must be coerced to the same type. Be careful coercing values back and forth, however, as the 
precision of a BigInt may be lost when it is coerced to a Number.

Type information
*/

//--------------------------Type information------------------------------------------------------------

// When tested against typeof, a BigInt will give "bigint":

typeof 1n === 'bigint'           // true
typeof BigInt('1') === 'bigint'  // true

// When wrapped in an Object, a BigInt will be considered as a normal "object" type:

typeof Object(1n) === 'object'  // true

//--------------------------Operators------------------------------------------------------------

/*
The following operators may be used with BigInts (or object-wrapped BigInts): +, *, -, **, %.

Bitwise operators are supported as well, except >>> (zero-fill right shift) as all BigInts are signed.

Also unsupported is the unary operator (+), in order to not break asm.js.
*/

const previousMaxSafe = BigInt(Number.MAX_SAFE_INTEGER) 
// ↪ 9007199254740991n

const maxPlusOne = previousMaxSafe + 1n 
// ↪ 9007199254740992n
 
const theFuture = previousMaxSafe + 2n 
// ↪ 9007199254740993n, this works now!

const multi = previousMaxSafe * 2n 
// ↪ 18014398509481982n

const subtr = multi - 10n
// ↪ 18014398509481972n

const mod = multi % 10n 
// ↪ 2n

const bigN = 2n ** 54n 
// ↪ 18014398509481984n

bigN * -1n
// ↪ –18014398509481984n

/* 
The / operator also works as expected with whole numbers.

However, since these are BigInts and not BigDecimals, this operation will round towards 0 
(which is to say, it will not return any fractional digits).

An operation with a fractional result will be truncated when used with a BigInt.
*/

const expected = 4n / 2n
// ↪ 2n

const rounded = 5n / 2n
// ↪ 2n, not 2.5


//--------------------------Comparisons------------------------------------------------------------

/*
A BigInt is not strictly equal to a Number, but it is loosely so:
*/


0n === 0
// ↪ false

0n == 0
// ↪ true

//A Number and a BigInt may be compared as usual:

1n < 2
// ↪ true

2n > 1
// ↪ true

2 > 2
// ↪ false

2n > 2
// ↪ false

2n >= 2
// ↪ true
//They may be mixed in arrays and sorted:

const mixed = [4n, 6, -12n, 10, 4, 0, 0n] 
// ↪  [4n, 6, -12n, 10, 4, 0, 0n]

mixed.sort() 
// ↪ [-12n, 0, 0n, 4n, 4, 6, 10]

//Note that comparisons with Object-wrapped BigInts act as with other objects, only indicating equality 
//when the same object instance is compared:

0n === Object(0n)          // false
Object(0n) === Object(0n)  // false

const o = Object(0n) 
o === o                    // true

//--------------------------Conditionals------------------------------------------------------------

/*
A BigInt behaves like a Number in cases where:

it is converted to a Boolean: via the Boolean function;
when used with logical operators ||, &&, and !; or
within a conditional test like an if statement.
*/

if (0n) {
  console.log('Hello from the if!') 
} else {
  console.log('Hello from the else!') 
}

// ↪ "Hello from the else!"

0n || 12n
// ↪ 12n

0n && 12n
// ↪ 0n

Boolean(0n)
// ↪ false

Boolean(12n)
// ↪ true

!12n
// ↪ false

!0n
// ↪ true