/*
The String global object is a constructor for strings or a sequence of characters.

String literals take the forms:

'string text'
"string text"
"中文 español Deutsch English देवनागरी العربية português বাংলা русский 日本語 norsk bokmål ਪੰਜਾਬੀ 한국어 
தமிழ் עברית"
Strings can also be created using the String constructor:

String(thing)

--------------------------------------Template literals-------------------------------------------------

Starting with ECMAScript 2015, string literals can also be so-called Template literals:

`hello world`
`hello!
 world!`
`hello ${who}`
tag `<a>${who}</a>`

----------------------------------------Escape notation--------------------------------------------------

Besides regular, printable characters, special characters can be encoded using escape notation:

Code	                Output

\XXX    (where XXX is 1–3 octal digits; range of 0–377)	ISO-8859-1 character / Unicode code point
         between U+0000 and U+00FF
\'	    single quote
\"	    double quote
\\	    backslash
\n	    new line
\r	    carriage return
\v	    vertical tab
\t	    tab
\b	    backspace
\f	    form feed
\uXXXX (where XXXX is 4 hex digits; range of 0x0000–0xFFFF)	UTF-16 code unit / Unicode code point 
        between U+0000 and U+FFFF
\u{X} ... \u{XXXXXX} (where X…XXXXXX is 1–6 hex digits; range of 0x0–0x10FFFF)	UTF-32 code unit / Unicode code point between U+0000 and U+10FFFF
\xXX (where XX is 2 hex digits; range of 0x00–0xFF)	ISO-8859-1 character / Unicode code point between U+0000 and U+00FF

----------------------------------------Long literal strings---------------------------------------------

Method 1

let longString = "This is a very long string which needs " +
                 "to wrap across multiple lines because " +
                 "otherwise my code is unreadable."


Method 2

let longString = "This is a very long string which needs \
to wrap across multiple lines because \
otherwise my code is unreadable."

*/


//--------------------------Character access------------------------------------------------------------

/*
There are two ways to access an individual character in a string. The first is the charAt() method:
*/

'cat'.charAt(1) // returns "a"

'cat'[1] // returns "a"

//--------------------------Comparing strings----------------------------------------------------------


    let a = 'a'
    let b = 'b'
    if (a < b) { // true
    console.log(a + ' is less than ' + b)
    } else if (a > b) {
    console.log(a + ' is greater than ' + b)
    } else {
    console.log(a + ' and ' + b + ' are equal.')
    }

//---------------------Distinction between string primitives and String objects--------------------------

/* Note that JavaScript distinguishes between String objects and primitive string values. 
(The same is true of Boolean and Numbers.)

String literals (denoted by double or single quotes) and strings returned from String calls in a 
non-constructor context (that is, called without using the new keyword) are primitive strings. 
JavaScript automatically converts primitives to String objects, so that it's possible to use 
String object methods for primitive strings. In contexts where a method is to be invoked on a 
primitive string or a property lookup occurs, JavaScript will automatically wrap the string primitive 
and call the method or perform the property lookup.

let s_prim = 'foo'
let s_obj = new String(s_prim)

console.log(typeof s_prim) // Logs "string"
console.log(typeof s_obj)  // Logs "object"

String primitives and String objects also give different results when using eval(). Primitives 
passed to eval are treated as source code; String objects are treated as all other objects are, 
by returning the object. For example:

let s1 = '2 + 2'              // creates a string primitive
let s2 = new String('2 + 2')  // creates a String object
console.log(eval(s1))         // returns the number 4
console.log(eval(s2))         // returns the string "2 + 2"

For these reasons, the code may break when it encounters String objects when it expects a primitive 
string instead, although generally, authors need not worry about the distinction.

A String object can always be converted to its primitive counterpart with the valueOf() method.

console.log(eval(s2.valueOf()))  // returns the number 4

*/

//--------------------------fromCharCode----------------------------------------------------------------

//String.fromCharCode(num1[, ...[, numN]])

/*
The static String.fromCharCode() method returns a string created from the specified sequence of 
UTF-16 code units.
*/

String.fromCharCode(65, 66, 67);   // returns "ABC"
String.fromCharCode(0x2014);       // returns "—"
String.fromCharCode(0x12014);      // also returns "—"; the digit 1 is truncated and ignored
String.fromCharCode(8212);         // also returns "—"; 8212 is the decimal form of 0x2014
String.fromCharCode(0xD83C, 0xDF03); // Code Point U+1F303 "Night with
String.fromCharCode(55356, 57091);   // Stars" == "\uD83C\uDF03"
String.fromCharCode(0xD834, 0xDF06, 0x61, 0xD834, 0xDF07); // "\uD834\uDF06a\uD834\uDF07"

//--------------------------fromCodePoint---------------------------------------------------------------

//String.fromCodePoint(num1[, ...[, numN]])

/*
The static String.fromCodePoint() method returns a string created by using the specified sequence of 
code points.
*/

String.fromCodePoint(42);       // "*"
String.fromCodePoint(65, 90);   // "AZ"
String.fromCodePoint(0x404);    // "\u0404" == "Є"
String.fromCodePoint(0x2F804);  // "\uD87E\uDC04"
String.fromCodePoint(194564);   // "\uD87E\uDC04"
String.fromCodePoint(0x1D306, 0x61, 0x1D307); // "\uD834\uDF06a\uD834\uDF07"

//Invalid input:

String.fromCodePoint('_');      // RangeError
String.fromCodePoint(Infinity); // RangeError
String.fromCodePoint(-1);       // RangeError
String.fromCodePoint(3.14);     // RangeError
String.fromCodePoint(3e-2);     // RangeError
String.fromCodePoint(NaN);      // RangeError

//--------------------------String.raw---------------------------------------------------------------

//String.raw(callSite, ...substitutions)

//String.raw`templateString`

/*
The static String.raw() method is a tag function of template literals. This is similar to the r 
prefix in Python, or the @ prefix in C# for string literals. (But it is not identical; see 
explanations in this issue.) It's used to get the raw string form of template strings, that is, 
substitutions (e.g. ${foo}) are processed, but escapes (e.g. \n) are not.
*/

// Create a variable that uses a Windows
// path without escaping the backslashes:
const filePath = String.raw`C:\Development\profile\aboutme.html`;

console.log('The file was uploaded from: ' + filePath);
// expected output: "The file was uploaded from: C:\Development\profile\aboutme.html"

//--------------------------String.raw---------------------------------------------------------------

//String.raw(callSite, ...substitutions)

//String.raw`templateString`

/*
The static String.raw() method is a tag function of template literals. This is similar to the r 
prefix in Python, or the @ prefix in C# for string literals. (But it is not identical; see 
explanations in this issue.) It's used to get the raw string form of template strings, that is, 
substitutions (e.g. ${foo}) are processed, but escapes (e.g. \n) are not.
*/

//--------------------------charAt---------------------------------------------------------------

//let character = str.charAt(index)

/*
The String object's charAt() method returns a new string consisting of the single UTF-16 
code unit located at the specified offset into the string.
*/

var anyString = 'Brave new world';
console.log("The character at index 0   is '" + anyString.charAt()   + "'"); 
// No index was provided, used 0 as default

console.log("The character at index 0   is '" + anyString.charAt(0)   + "'");
console.log("The character at index 1   is '" + anyString.charAt(1)   + "'");
console.log("The character at index 2   is '" + anyString.charAt(2)   + "'");
console.log("The character at index 3   is '" + anyString.charAt(3)   + "'");
console.log("The character at index 4   is '" + anyString.charAt(4)   + "'");
console.log("The character at index 999 is '" + anyString.charAt(999) + "'");

//--------------------------charCodeAt---------------------------------------------------------------

//str.charCodeAt(index)

/*
The charCodeAt() method returns an integer between 0 and 65535 representing the UTF-16 code unit 
at the given index.
*/

const sentence = 'The quick brown fox jumps over the lazy dog.';

const index = 4;

console.log('The character code ' + sentence.charCodeAt(index) + ' is equal to ' + sentence.charAt(index));
// expected output: "The character code 113 is equal to q"

//--------------------------codePointAt---------------------------------------------------------------

//str.codePointAt(pos)

/*
The codePointAt() method returns a non-negative integer that is the Unicode code point value.

If there is no element at the specified position, undefined is returned. If no UTF-16 surrogate pair 
begins at pos, the code unit at pos is returned.
*/

'ABC'.codePointAt(1)           // 66
'\uD800\uDC00'.codePointAt(0)  // 65536

'XYZ'.codePointAt(42)          // undefined

for (let codePoint of '\ud83d\udc0e\ud83d\udc71\u2764') {
    console.log(codePoint.codePointAt(0).toString(16)) 
 } 
 // '1f40e', '1f471', '2764'

 //--------------------------concat---------------------------------------------------------------

//str.concat(str2 [, ...strN])

/*
The concat() method concatenates the string arguments to the calling string and returns a 
new string.

The concat() function concatenates the string arguments to the calling string and returns a new 
string. Changes to the original string or the returned string don't affect the other.

If the arguments are not of the type string, they are converted to string values before concatenating.
*/

let hello = 'Hello, '
console.log(hello.concat('Kevin', '. Have a nice day.'))
// Hello, Kevin. Have a nice day.

let greetList = ['Hello', ' ', 'Venkat', '!']
"".concat(...greetList)  // "Hello Venkat!"

"".concat({})    // [object Object]
"".concat([])    // ""
"".concat(null)  // "null"
"".concat(true)  // "true"
"".concat(4, 5)  // "45"

/* 
It is strongly recommended that the assignment operators (+, +=) are used instead of the 
concat() method. 
According to this performance test, the assignment operators are several times faster.
*/

 //--------------------------includes---------------------------------------------------------------

//str.includes(searchString[, position])

/*
The includes() method determines whether one string may be found within another string, returning 
true or false as appropriate.
*/

const str = 'To be, or not to be, that is the question.' 

console.log(str.includes('To be'))        // true
console.log(str.includes('question'))     // true
console.log(str.includes('nonexistent'))  // false
console.log(str.includes('To be', 1))     // false
console.log(str.includes('TO BE'))        // false
console.log(str.includes(''))             // true

 //--------------------------endsWith---------------------------------------------------------------

//str.endsWith(searchString[, length])

/*
The endsWith() method determines whether a string ends with the characters of a specified 
string, returning true or false as appropriate.
*/

let str = 'To be, or not to be, that is the question.'

console.log(str.endsWith('question.'))  // true
console.log(str.endsWith('to be'))      // false
console.log(str.endsWith('to be', 19))  // true

 //--------------------------indexOf---------------------------------------------------------------

//str.indexOf(searchValue [, fromIndex])

/*
The indexOf() method returns the index within the calling String object of the first 
occurrence of the specified value, starting the search at fromIndex. Returns -1 if the value is 
not found.
*/

'Blue Whale'.indexOf('Blue')      // returns  0
'Blue Whale'.indexOf('Blute')     // returns -1
'Blue Whale'.indexOf('Whale', 0)  // returns  5
'Blue Whale'.indexOf('Whale', 5)  // returns  5
'Blue Whale'.indexOf('Whale', 7)  // returns -1
'Blue Whale'.indexOf('')          // returns  0
'Blue Whale'.indexOf('', 9)       // returns  9
'Blue Whale'.indexOf('', 10)      // returns 10
'Blue Whale'.indexOf('', 11)      // returns 10

'Blue Whale'.indexOf('blue')  // returns -1

//Checking occurrences
//----------------------

'Blue Whale'.indexOf('Blue') !== -1  // true
'Blue Whale'.indexOf('Bloe') !== -1  // false
~('Blue Whale'.indexOf('Bloe')) // 0, which is falsy

//Using indexOf()
//----------------------

const str = 'Brave new world'

console.log('Index of first w from start is ' + str.indexOf('w'))   // logs 8
console.log('Index of "new" from start is ' + str.indexOf('new'))   // logs 6

//Using indexOf()
//----------------------

const myString    = 'brie, pepper jack, cheddar'
const myCapString = 'Brie, Pepper Jack, Cheddar'

console.log('myString.indexOf("cheddar") is ' + myString.indexOf('cheddar'))
// logs 19
console.log('myCapString.indexOf("cheddar") is ' + myCapString.indexOf('cheddar'))
// logs -1

//Using indexOf() to count occurrences of a letter in a string
//--------------------------------------------------------------

const str = 'To be, or not to be, that is the question.'
let count = 0
let position = str.indexOf('e')

while (position !== -1) {
  count++
  position = str.indexOf('e', position + 1)
}

console.log(count)  // displays 4

 //--------------------------lastIndexOf---------------------------------------------------------------

//str.lastIndexOf(searchValue[, fromIndex])

/*
The lastIndexOf() method returns the index within the calling String object of the last 
occurrence of the specified value, searching backwards from fromIndex. Returns -1 if the value is not 
found.
*/

let anyString = 'Brave new world';

console.log('The index of the first w from the beginning is ' + anyString.indexOf('w'));
// logs 8
console.log('The index of the first w from the end is ' + anyString.lastIndexOf('w')); 
// logs 10
console.log('The index of "new" from the beginning is ' + anyString.indexOf('new'));
// logs 6
console.log('The index of "new" from the end is ' + anyString.lastIndexOf('new'));
// logs 6

//--------------------------match---------------------------------------------------------------

//str.match(regexp)

/*
The match() method retrieves the result of matching a string against a regular expression.

If the regular expression does not include the g flag, str.match() will return the same 
result as RegExp.exec().

1) If you need to know if a string matches a regular expression RegExp, use RegExp.test().

2) If you only want the first match found, you might want to use RegExp.exec() instead.

3) Ff you want to obtain capture groups and the global flag is set, you need to use RegExp.exec() 
    or String.prototype.matchAll() instead.
*/

//Using match()
//----------------

let str = 'For more information, see Chapter 3.4.5.1';
let re = /see (chapter \d+(\.\d)*)/i;
let found = str.match(re);

console.log(found);

// logs [ 'see Chapter 3.4.5.1',
//        'Chapter 3.4.5.1',
//        '.1',
//        index: 22,
//        input: 'For more information, see Chapter 3.4.5.1' ]

// 'see Chapter 3.4.5.1' is the whole match.
// 'Chapter 3.4.5.1' was captured by '(chapter \d+(\.\d)*)'.
// '.1' was the last value captured by '(\.\d)'.
// The 'index' property (22) is the zero-based index of the whole match.
// The 'input' property is the original string that was parsed.

//Using global and ignore case flags with match()
//--------------------------------------------------

let str = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
let regexp = /[A-E]/gi;
let matches_array = str.match(regexp);

console.log(matches_array);
// ['A', 'B', 'C', 'D', 'E', 'a', 'b', 'c', 'd', 'e']

//Using named capturing groups
//--------------------------------

let paragraph = 'The quick brown fox jumps over the lazy dog. It barked.';

let capturingRegex = /(?<animal>fox|cat) jumps over/;
found = paragraph.match(capturingRegex);
console.log(found.groups); // {animal: "fox"}

//Using match() with no parameter
//----------------------------------

let str = "Nothing will come of nothing.";

str.match();   // returns [""]

//A non-RegExp object as the parameter
//----------------------------------------

let str1 = "NaN means not a number. Infinity contains -Infinity and +Infinity in JavaScript.",
str2 = "My grandfather is 65 years old and My grandmother is 63 years old.",
str3 = "The contract was declared null and void.";
str1.match("number");   // "number" is a string. returns ["number"]
str1.match(NaN);        // the type of NaN is the number. returns ["NaN"]
str1.match(Infinity);   // the type of Infinity is the number. returns ["Infinity"]
str1.match(+Infinity);  // returns ["Infinity"]
str1.match(-Infinity);  // returns ["-Infinity"]
str2.match(65);         // returns ["65"]
str2.match(+65);        // A number with a positive sign. returns ["65"]
str3.match(null);       // returns ["null"]

//--------------------------matchAll---------------------------------------------------------------

//str.matchAll(regexp)

/*
The matchAll() method returns an iterator of all results matching a string against a regular 
expression, including capturing groups.
*/

//Regexp.exec() and matchAll()
//-------------------------------

/*
Prior to the addition of matchAll to JavaScript, it was possible to use calls to 
regexp.exec (and regexes with the /g flag) in a loop to obtain all the matches:
*/

const regexp = RegExp('foo[a-z]*','g');
const str = 'table football, foosball';
let match;

while ((match = regexp.exec(str)) !== null) {
  console.log(`Found ${match[0]} start=${match.index} end=${regexp.lastIndex}.`);
  // expected output: "Found football start=6 end=14."
  // expected output: "Found foosball start=16 end=24."
}

/*
With matchAll available, you can avoid the while  loop and exec with g.

Instead, by using matchAll, you get an iterator to use with the more 
convenient for...of, array spread, or Array.from() constructs:
*/

const regexp = RegExp('foo[a-z]*','g');
const str = 'table football, foosball';
const matches = str.matchAll(regexp);

for (const match of matches) {
  console.log(`Found ${match[0]} start=${match.index} end=${match.index + match[0].length}.`);
}
// expected output: "Found football start=6 end=14."
// expected output: "Found foosball start=16 end=24."

// matches iterator is exhausted after the for..of iteration
// Call matchAll again to create a new iterator
Array.from(str.matchAll(regexp), m => m[0]);
// Array [ "football", "foosball" ]

/*
matchAll will throw an exception if the g flag is missing.
*/

const regexp = RegExp('[a-c]','');
const str = 'abc';
str.matchAll(regexp);
// TypeError

/*
matchAll internally makes a clone of the regexp—so, 
unlike regexp.exec(), lastIndex does not change as the string is scanned.
*/

const regexp = RegExp('[a-c]','g');
regexp.lastIndex = 1;
const str = 'abc';
Array.from(str.matchAll(regexp), m => `${regexp.lastIndex} ${m[0]}`);
// Array [ "1 b", "1 c" ]

//Better access to capturing groups (than String.prototype.match())
//------------------------------------------------------------------

let regexp = /t(e)(st(\d?))/g;
let str = 'test1test2';

str.match(regexp); 
// Array ['test1', 'test2']

//Using matchAll, you can access capture groups easily:

let array = [...str.matchAll(regexp)];

array[0];
// ['test1', 'e', 'st1', '1', index: 0, input: 'test1test2', length: 4]
array[1];
// ['test2', 'e', 'st2', '2', index: 5, input: 'test1test2', length: 4]

//--------------------------normalize---------------------------------------------------------------

//str.normalize([form])

/*
The normalize() method returns the Unicode Normalization Form of the string.
*/

const name1 = '\u0041\u006d\u00e9\u006c\u0069\u0065';
const name2 = '\u0041\u006d\u0065\u0301\u006c\u0069\u0065';

console.log(`${name1}, ${name2}`);
// expected output: "Amélie, Amélie"
console.log(name1 === name2);
// expected output: false
console.log(name1.length === name2.length);
// expected output: false

const name1NFC = name1.normalize('NFC');
const name2NFC = name2.normalize('NFC');

console.log(`${name1NFC}, ${name2NFC}`);
// expected output: "Amélie, Amélie"
console.log(name1NFC === name2NFC);
// expected output: true
console.log(name1NFC.length === name2NFC.length);
// expected output: true

//--------------------------padEnd---------------------------------------------------------------

//str.padEnd(targetLength [, padString])

/*
The padEnd() method pads the current string with a given string (repeated, if needed) so 
that the resulting string reaches a given length. The padding is applied from the end of the 
current string.
*/

'abc'.padEnd(10);          // "abc       "
'abc'.padEnd(10, "foo");   // "abcfoofoof"
'abc'.padEnd(6, "123456"); // "abc123"
'abc'.padEnd(1);           // "abc"

//--------------------------padStart---------------------------------------------------------------

//str.padStart(targetLength [, padString])

/*
The padStart() method pads the current string with another string (multiple times, if needed) 
until the resulting string reaches the given length. The padding is applied from the start of the 
current string.
*/

'abc'.padStart(10);         // "       abc"
'abc'.padStart(10, "foo");  // "foofoofabc"
'abc'.padStart(6,"123465"); // "123abc"
'abc'.padStart(8, "0");     // "00000abc"
'abc'.padStart(1);          // "abc"

// Javascript version of: (unsigned)
//  printf "%0*d" width num
function leftFillNum(num, targetLength) {
  return num.toString().padStart(targetLength, 0);
}

const num = 123;
console.log(leftFillNum(num, 5));
// expected output: "00123"

//--------------------------repeat---------------------------------------------------------------

//str.repeat(count)

/*
The repeat() method constructs and returns a new string which contains the specified number 
of copies of the string on which it was called, concatenated together.
*/

'abc'.repeat(-1)    // RangeError
'abc'.repeat(0)     // ''
'abc'.repeat(1)     // 'abc'
'abc'.repeat(2)     // 'abcabc'
'abc'.repeat(3.5)   // 'abcabcabc' (count will be converted to integer)
'abc'.repeat(1/0)   // RangeError

({ toString: () => 'abc', repeat: String.prototype.repeat }).repeat(2) 
// 'abcabc' (repeat() is a generic method)

//--------------------------replace---------------------------------------------------------------

//const newStr = str.replace(regexp|substr, newSubstr|function)

/*
The replace() method returns a new string with some or all matches of a pattern replaced by a 
replacement. The pattern can be a string or a RegExp, and the replacement can be a string or a 
function to be called for each match. If pattern is a string, only the first occurrence will be 
replaced.

The original string is left unchanged.
*/

//Using global and ignore with replace()
//----------------------------------------

let re = /apples/gi;
let str = 'Apples are round, and apples are juicy.';
let newstr = str.replace(re, 'oranges');
console.log(newstr);  // oranges are round, and oranges are juicy.

//Switching words in a string
//------------------------------

let re = /(\w+)\s(\w+)/;
let str = 'John Smith';
let newstr = str.replace(re, '$2, $1');
console.log(newstr);  // Smith, John

//Using an inline function that modifies the matched characters
//------------------------------------------------------------------

/*
In this example, all occurrences of capital letters in the string are converted to lower case, 
and a hyphen is inserted just before the match location. The important thing here is that 
additional operations are needed on the matched item before it is given back as a replacement.

The replacement function accepts the matched snippet as its parameter, and uses it to 
transform the case and concatenate the hyphen before returning.

function styleHyphenFormat(propertyName) {
  function upperToHyphenLower(match, offset, string) {
    return (offset > 0 ? '-' : '') + match.toLowerCase();
  }
  return propertyName.replace(/[A-Z]/g, upperToHyphenLower);
}

Given styleHyphenFormat('borderTop'), this returns 'border-top'.

Because we want to further transform the result of the match before the final substitution is made, 
we must use a function. This forces the evaluation of the match prior to the toLowerCase() method. 
If we had tried to do this using the match without a function, the toLowerCase() would have no effect.

let newString = propertyName.replace(/[A-Z]/g, '-' + '$&'.toLowerCase());  // won't work
This is because '$&'.toLowerCase() would first be evaluated as a string literal (resulting in the same 
'$&') before using the characters as a pattern.
*/

//Replacing a Fahrenheit degree with its Celsius equivalent
//------------------------------------------------------------------

/*
The following example replaces a Fahrenheit degree with its equivalent Celsius degree. 
The Fahrenheit degree should be a number ending with "F". The function returns the Celsius 
number ending with "C". For example, if the input number is "212F", the function returns "100C". 
If the number is "0F", the function returns "-17.77777777777778C".

The regular expression test checks for any number that ends with F. The number of Fahrenheit degree 
is accessible to the function through its second parameter, p1. The function sets the Celsius number 
based on the Fahrenheit degree passed in a string to the f2c() function. f2c() then returns the 
Celsius number. This function approximates Perl's s///e flag.

function f2c(x) {
  function convert(str, p1, offset, s) {
    return ((p1 - 32) * 5/9) + 'C';
  }
  let s = String(x);
  let test = /(-?\d+(?:\.\d*)?)F\b/g;
  return s.replace(test, convert);
}
*/

//--------------------------search---------------------------------------------------------------

//str.search(regexp)

/*
The search() method executes a search for a match between a regular expression and this 
String object.

When you want to know whether a pattern is found, and also know its index within a string, 
use search(). (If you only want to know if it exists, use the similar test() method on the 
RegExp prototype, which returns a boolean.) 

For more information (but slower execution) use match() (similar to the regular expression 
exec() method).
*/

let str = "hey JudE"
let re = /[A-Z]/g
let re2 = /[.]/g
console.log(str.search(re))   // returns 4, which is the index of the first capital letter "J"
console.log(str.search(re2))  // returns -1 cannot find '.' dot punctuation

//--------------------------slice---------------------------------------------------------------

//str.slice(beginIndex[, endIndex])

/*
The slice() method extracts a section of a string and returns it as a new string, 
without modifying the original string.

slice() extracts the text from one string and returns a new string. Changes to the text in 
one string do not affect the other string.

slice() extracts up to but not including endIndex. str.slice(1, 4) extracts the second 
character through the fourth character (characters indexed 1, 2, and 3).

As an example, str.slice(2, -1) extracts the third character through the second to last 
character in the string.
*/

let str1 = 'The morning is upon us.', // the length of str1 is 23.
    str2 = str1.slice(1, 8),
    str3 = str1.slice(4, -2),
    str4 = str1.slice(12),
    str5 = str1.slice(30);
console.log(str2)  // OUTPUT: he morn
console.log(str3)  // OUTPUT: morning is upon u
console.log(str4)  // OUTPUT: is upon us.
console.log(str5)  // OUTPUT: ""

let str = 'The morning is upon us.'
str.slice(-3)      // returns 'us.'
str.slice(-3, -1)  // returns 'us'
str.slice(0, -1)   // returns 'The morning is upon us'

/*
This example counts backwards from the end of the string by 11 to find the start index and 
forwards from the start of the string by 16 to find the end index.
*/
console.log(str.slice(-11, 16)) // => "is u"
/*
Here it counts forwards from the start by 11 to find the start index and backwards from 
the end by 7 to find the end index.
*/
console.log(str.slice(11, -7)) // => " is u"
/*
These arguments count backwards from the end by 5 to find the start index and backwards 
from the end by 1 to find the end index.
*/
console.log(str.slice(-5, -1)) // => "n us"

//--------------------------split---------------------------------------------------------------

//str.split([separator[, limit]])

/*
The split() method divides a String into an ordered set of substrings, puts these substrings 
into an array, and returns the array.  The division is done by searching for a pattern; where 
the pattern is provided as the first parameter in the method's call. 

When found, separator is removed from the string and the substrings are returned in an array.

If separator is a regular expression with capturing parentheses, then each time separator matches, 
the results (including any undefined results) of the capturing parentheses are spliced into the 
output array.

If the separator is an array, then that Array is coerced to a String and used as a separator.
*/

//Using split()
//----------------

/*
When the string is empty, split() returns an array containing one empty string, rather than an 
empty array. If the string and separator are both empty strings, an empty array is returned.
*/

const myString = ''
const splits = myString.split()

console.log(splits)

// ↪ [""]

//Replacing a Fahrenheit degree with its Celsius equivalent
//------------------------------------------------------------------

function splitString(stringToSplit, separator) {
  const arrayOfStrings = stringToSplit.split(separator)

  console.log('The original string is: ', stringToSplit)
  console.log('The separator is: ', separator)
  console.log('The array has ', arrayOfStrings.length, ' elements: ', arrayOfStrings.join(' / '))
}

const tempestString = 'Oh brave new world that has such people in it.'
const monthString = 'Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec'

const space = ' '
const comma = ','

splitString(tempestString, space)
splitString(tempestString)
splitString(monthString, comma)

//Removing spaces from a string
//-------------------------------

const names = 'Harry Trump ;Fred Barney; Helen Rigby ; Bill Abel ;Chris Hand '

console.log(names)

const re = /\s*(?:;|$)\s*/
const nameList = names.split(re)

console.log(nameList)

//Returning a limited number of splits
//---------------------------------------

const myString = 'Hello World. How are you doing?'
const splits = myString.split(' ', 3)

console.log(splits)

//Splitting with a RegExp to include parts of the separator in the result
//-------------------------------------------------------------------------

const myString = 'Hello 1 word. Sentence number 2.'
const splits = myString.split(/(\d)/)

console.log(splits)

//Reversing a String using split()
//----------------------------------

const str = 'asdfghjkl'
const strReverse = str.split('').reverse().join('') 
// 'lkjhgfdsa'

// split() returns an array on which reverse() and join() can be applied

//--------------------------startsWith---------------------------------------------------------------

//str.startsWith(searchString[, position])

/*
The startsWith() method determines whether a string begins with the characters of a specified 
string, returning true or false as appropriate.
*/

let str = 'To be, or not to be, that is the question.'

console.log(str.startsWith('To be'))          // true
console.log(str.startsWith('not to be'))      // false
console.log(str.startsWith('not to be', 10))  // true

//Using substring()
//--------------------

let anyString = 'Mozilla'

// Displays 'M'
console.log(anyString.substring(0, 1))
console.log(anyString.substring(1, 0))

// Displays 'Mozill'
console.log(anyString.substring(0, 6))

// Displays 'lla'
console.log(anyString.substring(4))
console.log(anyString.substring(4, 7))
console.log(anyString.substring(7, 4))

// Displays 'Mozilla'
console.log(anyString.substring(0, 7))
console.log(anyString.substring(0, 10))

//Using substring() with length property
//-----------------------------------------

// Displays 'illa' the last 4 characters
let anyString = 'Mozilla'
let anyString4 = anyString.substring(anyString.length - 4)
console.log(anyString4)

// Displays 'zilla' the last 5 characters
let anyString = 'Mozilla'
let anyString5 = anyString.substring(anyString.length - 5)
console.log(anyString5)

//Differences between substring() and slice()
//---------------------------------------------

/*
The substring() method swaps its two arguments if indexStart is greater than indexEnd, 
meaning that a string is still returned. The slice() method returns an empty string if 
this is the case.
*/

let text = 'Mozilla'
console.log(text.substring(5, 2))  // => "zil" 
console.log(text.slice(5, 2))      // => ""

/*
If either or both of the arguments are negative or NaN, the substring() method
treats them as if they were 0.
*/

console.log(text.substring(-5, 2))  // => "Mo"
console.log(text.substring(-5, -2)) // => ""

/*
slice() also treats NaN arguments as 0, but when it is given negative values it counts 
backwards from the end of the string to find the indexes.
*/

console.log(text.slice(-5, 2))   // => ""
console.log(text.slice(-5, -2))  // => "zil"

//Replacing a substring within a string
//---------------------------------------

// Replaces oldS with newS in the string fullS
function replaceString(oldS, newS, fullS) {
  for (let i = 0; i < fullS.length; ++i) {
    if (fullS.substring(i, i + oldS.length) == oldS) {
      fullS = fullS.substring(0, i) + newS + fullS.substring(i + oldS.length, fullS.length)
    }
  }
  return fullS
}

replaceString('World', 'Web', 'Brave New World')

/* 
Note that this can result in an infinite loop if oldS is itself a substring of newS — 
for example, if you attempted to replace 'World' with 'OtherWorld' here.

A better method for replacing strings is as follows:
*/

function replaceString(oldS, newS, fullS) {
  return fullS.split(oldS).join(newS)
}

//--------------------------toLowerCase---------------------------------------------------------------

//str.toLowerCase()

/*
The toLowerCase() method returns the calling string value converted to lower case.
*/

console.log('ALPHABET'.toLowerCase()); // 'alphabet'

//--------------------------toString---------------------------------------------------------------

//str.toString()

/*
The toString() method returns a string representing the specified object.

The String object overrides the toString() method of the Object object; it does not inherit 
Object.prototype.toString(). For String objects, the toString() method returns a string 
representation of the object and is the same as the String.prototype.valueOf() method.
*/

var x = new String('Hello world');

console.log(x.toString()); // logs 'Hello world'

//--------------------------toUpperCase---------------------------------------------------------------

//str.toUpperCase()

/*
The toUpperCase() method returns the calling string value converted to uppercase 
(the value will be converted to a string if it isn't one).
*/

console.log('alphabet'.toUpperCase()); // 'ALPHABET'

//Non-string to string

const a = String.prototype.toUpperCase.call({
  toString: function toString() {
    return 'abcdef';
  }
});

const b = String.prototype.toUpperCase.call(true);

// prints out 'ABCDEF TRUE'.
console.log(a, b);

//--------------------------trim---------------------------------------------------------------

//str.trim()

/*
The trim() method removes whitespace from both ends of a string. Whitespace in this context 
is all the whitespace characters (space, tab, no-break space, etc.) and all the line terminator 
characters (LF, CR, etc.).
*/

var orig = '   foo  ';
console.log(orig.trim()); // 'foo'

// Another example of .trim() removing whitespace from just one side.

var orig = 'foo    ';
console.log(orig.trim()); // 'foo'

//--------------------------trimStart---------------------------------------------------------------

//str.trimStart();
//str.trimLeft();

/*
The trimStart() method removes whitespace from the beginning of a string. trimLeft() is an alias 
of this method.
*/

var str = '   foo  ';

console.log(str.length); // 8

str = str.trimStart();
console.log(str.length); // 5
console.log(str);        // 'foo  '

//--------------------------trimEnd---------------------------------------------------------------

//str.trimEnd();
//str.trimRight();

/*
The trimStart() method removes whitespace from the beginning of a string. trimLeft() is an alias 
of this method.
*/

var str = '   foo  ';

console.log(str.length); // 8

str = str.trimEnd();
console.log(str.length); // 6
console.log(str);        // '   foo'

//--------------------------valueOf---------------------------------------------------------------

//str.valueOf()

/*
The valueOf() method returns the primitive value of a String object.
*/

var x = new String('Hello world');
console.log(x.valueOf()); // Displays 'Hello world'