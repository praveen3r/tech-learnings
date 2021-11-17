/*
The Atomics object provides atomic operations as static methods. They are used with SharedArrayBuffer 
objects.

The Atomic operations are installed on an Atomics module. Unlike the other global objects, 
Atomics is not a constructor. You cannot use it with a new operator or invoke the Atomics object 
as a function. All properties and methods of Atomics are static (as is the case with the Math object, 
for example).
*/

//--------------------------add------------------------------------------------------------------------

//Atomics.add(typedArray, index, value)

/*
The static Atomics.add() method adds a given value at a given position in the array and returns 
the old value at that position. This atomic operation guarantees that no other write happens until 
the modified value is written back.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 7;

// 7 + 2 = 9
console.log(Atomics.add(uint8, 0, 2));
// expected output: 7

console.log(Atomics.load(uint8, 0));
// expected output: 9


//--------------------------and---------------------------------------------------------------------

//Atomics.and(typedArray, index, value)

/*
The static Atomics.and() method computes a bitwise AND with a given value at a given position 
in the array, and returns the old value at that position. This atomic operation guarantees 
that no other write happens until the modified value is written back.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 7;

// 7 (0111) AND 2 (0010) = 2 (0010)
console.log(Atomics.and(uint8, 0, 2));
// expected output: 7

console.log(Atomics.load(uint8, 0));
// expected output: 2

//--------------------------compareExchange---------------------------------------------------------------------

//Atomics.compareExchange(typedArray, index, expectedValue, replacementValue)

/*
The static Atomics.compareExchange() method exchanges a given replacement value at a given position 
in the array, if a given expected value equals the old value.  It returns the old value at that 
position whether it was equal to the expected value or not. This atomic operation guarantees 
that no other write happens until the modified value is written back.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 5;

Atomics.compareExchange(uint8, 0, 5, 2); // returns 5
console.log(Atomics.load(uint8, 0));
// expected output: 2

Atomics.compareExchange(uint8, 0, 5, 4); // returns 2
console.log(Atomics.load(uint8, 0));
// expected output: 2

//--------------------------exchange---------------------------------------------------------------------

//Atomics.exchange(typedArray, index, value)

/*
The static Atomics.exchange() method stores a given value at a given position in the array and returns 
the old value at that position. This atomic operation guarantees that no other write happens between 
the read of the old value and the write of the new value.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 5;

console.log(Atomics.load(uint8, 0));
// expected output: 5

Atomics.exchange(uint8, 0, 2); // returns 5
console.log(Atomics.load(uint8, 0));
// expected output: 2

//--------------------------load---------------------------------------------------------------------

//Atomics.load(typedArray, index)

/*
The static Atomics.load() method returns a value at a given position in the array.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 5;

// 5 + 2 = 7
console.log(Atomics.add(uint8, 0, 2));
// expected output: 5

console.log(Atomics.load(uint8, 0));
// expected output: 7

//--------------------------or---------------------------------------------------------------------

//Atomics.or(typedArray, index, value)

/*
The static Atomics.or() method computes a bitwise OR with a given value at a given position 
in the array, and returns the old value at that position. This atomic operation guarantees that no 
other write happens until the modified value is written back.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 5;

// 5 (0101) OR 2 (0010) = 7 (0111)
console.log(Atomics.or(uint8, 0, 2));
// expected output: 5

console.log(Atomics.load(uint8, 0));
// expected output: 7

//--------------------------store---------------------------------------------------------------------

//Atomics.store(typedArray, index, value)

/*
The static Atomics.store() method stores a given value at the given position in the array and 
returns that value.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 5;

console.log(Atomics.store(uint8, 0, 2));
// expected output: 2

console.log(Atomics.load(uint8, 0));
// expected output: 2

//--------------------------sub---------------------------------------------------------------------

//Atomics.sub(typedArray, index, value)

/*
The static Atomics.sub() method substracts a given value at a given position in the array and 
returns the old value at that position. This atomic operation guarantees that no other write 
happens until the modified value is written back.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 7;

// 7 - 2 = 5
console.log(Atomics.sub(uint8, 0, 2));
// expected output: 7

console.log(Atomics.load(uint8, 0));
// expected output: 5


//--------------------------xor---------------------------------------------------------------------

//Atomics.xor(typedArray, index, value)

/*
The static Atomics.xor() method computes a bitwise XOR with a given value at a given position 
in the array, and returns the old value at that position. This atomic operation guarantees that 
no other write happens until the modified value is written back.
*/

// create a SharedArrayBuffer with a size in bytes
const buffer = new SharedArrayBuffer(16);
const uint8 = new Uint8Array(buffer);
uint8[0] = 7;

// 7 (0111) XOR 2 (0010) = 5 (0101)
console.log(Atomics.xor(uint8, 0, 2));
// expected output: 7

console.log(Atomics.load(uint8, 0));
// expected output: 5


//--------------------------wait---------------------------------------------------------------------

//Atomics.wait(typedArray, index, value[, timeout])

/*
The static Atomics.wait() method verifies that a given position in an Int32Array still contains 
a given value and if so sleeps, awaiting a wakeup or a timeout. It returns a string which is either 
"ok", "not-equal", or "timed-out".
*/

// Given a shared Int32Array:

const sab = new SharedArrayBuffer(1024);
const int32 = new Int32Array(sab);

/*
A reading thread is sleeping and waiting on location 0 which is expected to be 0. As long as that 
is true, it will not go on. However, once the writing thread has stored a new value, it will be 
notified by the writing thread and return the new value (123).
*/

Atomics.wait(int32, 0, 0);
console.log(int32[0]); // 123

// A writing thread stores a new value and notifies the waiting thread once it has written:

console.log(int32[0]); // 0;
Atomics.store(int32, 0, 123); 
Atomics.notify(int32, 0, 1);

//--------------------------notify---------------------------------------------------------------------

//Atomics.notify(typedArray, index, count)

/*
The static Atomics.notify() method notifies up some agents that are sleeping in the wait queue.
*/

// Given a shared Int32Array:

const sab = new SharedArrayBuffer(1024);
const int32 = new Int32Array(sab);

/*
A reading thread is sleeping and waiting on location 0 which is expected to be 0. As long as that 
is true, it will not go on. However, once the writing thread has stored a new value, it will be 
notified by the writing thread and return the new value (123).
*/

Atomics.wait(int32, 0, 0);
console.log(int32[0]); // 123

// A writing thread stores a new value and notifies the waiting thread once it has written:

console.log(int32[0]); // 0;
Atomics.store(int32, 0, 123); 
Atomics.notify(int32, 0, 1);

//--------------------------isLockFree---------------------------------------------------------------------

//Atomics.isLockFree(size)

/*
The static Atomics.isLockFree() method is used to determine whether to use locks or atomic operations. 
It returns true, if the given size is one of the BYTES_PER_ELEMENT property of integer TypedArray types.
*/

console.log(Atomics.isLockFree(3));
// 3 is not one of the BYTES_PER_ELEMENT values
// expected output: false

console.log(Atomics.isLockFree(4));
// 4 is one of the BYTES_PER_ELEMENT values
// expected output: true

Atomics.isLockFree(1); // true
Atomics.isLockFree(2); // true
Atomics.isLockFree(3); // false
Atomics.isLockFree(4); // true
Atomics.isLockFree(5); // false
Atomics.isLockFree(6); // false
Atomics.isLockFree(7); // false
Atomics.isLockFree(8); // false