/*
The data type symbol is a primitive data type. The Symbol() function returns a value of type symbol, 
has static properties that expose several members of built-in objects, has static methods that expose 
the global symbol registry, and resembles a built-in object class, but is incomplete as a constructor 
because it does not support the syntax "new Symbol()".  

Every symbol value returned from Symbol() is unique.  A symbol value may be used as an identifier for 
object properties; this is the data type's primary purpose, although other use-cases exist, such as 
enabling opaque data types, or serving as an implementation-supported unique identifier in general.  
Some further explanation about purpose and usage can be found in the glossary entry for Symbol.

To create a new primitive symbol, you write Symbol() with an optional string as its description:

let sym1 = Symbol()
let sym2 = Symbol('foo')
let sym3 = Symbol('foo')

The above code creates three new symbols. Note that Symbol("foo") does not coerce the string "foo" 
into a symbol. It creates a new symbol each time:

Symbol('foo') === Symbol('foo')  // false

The following syntax with the new operator will throw a TypeError:

let sym = new Symbol()  // TypeError

This prevents authors from creating an explicit Symbol wrapper object instead of a new symbol value and 
might be surprising as creating explicit wrapper objects around primitive data types is generally 
possible (for example, new Boolean, new String and new Number).

If you really want to create a Symbol wrapper object, you can use the Object() function:

let sym = Symbol('foo')
typeof sym      // "symbol" 
let symObj = Object(sym)
typeof symObj   // "object"

Shared symbols in the global symbol registry
----------------------------------------------

The above syntax using the Symbol() function will not create a global symbol that is available in your 
whole codebase. To create symbols available across files and even across realms (each of which has 
its own global scope), use the methods Symbol.for() and Symbol.keyFor() to set and retrieve symbols 
from the global symbol registry.

Finding symbol properties on objects
--------------------------------------

The method Object.getOwnPropertySymbols() returns an array of symbols and lets you find symbol 
properties on a given object. Note that every object is initialized with no own symbol properties, 
so that this array will be empty unless you've set symbol properties on the object.
*/

//--------------------------Symbol.match----------------------------------------------------------

/*
The Symbol.match well-known symbol specifies the matching of a regular 
expression against a string. This function is called by the String.prototype.match() method.

This function is also used to identify if objects have the behavior of regular expressions. 
For example, the methods String.prototype.startsWith(), String.prototype.endsWith() and 
String.prototype.includes(), check if their first argument is a regular expression and will throw a 
TypeError if they are. Now, if the match symbol is set to false (or a Falsy value), it indicates 
that the object is not intended to be used as a regular expression object.

*/

'/bar/'.startsWith(/bar/); 

// Throws TypeError, as /bar/ is a regular expression
// and Symbol.match is not modified.

/* 
However, if you set Symbol.match to false, the isRegExp check (that uses the match property) 
will indicate that the object is not a regular expression object. The methods startsWith and endsWith 
won't throw a TypeError as a consequence.
*/

var re = /foo/;
re[Symbol.match] = false;
'/foo/'.startsWith(re); // true
'/baz/'.endsWith(re);   // false

//--------------------------Symbol.matchAll----------------------------------------------------------

/*
The Symbol.matchAll well-known symbol returns an iterator, that yields matches of the regular 
expression against a string. This function is called by the String.prototype.matchAll() method.

*/

'abc'.matchAll(/a/);

/a/[Symbol.matchAll]('abc');

//--------------------------Symbol.replace----------------------------------------------------------

/*
The Symbol.replace well-known symbol specifies the method that replaces matched substrings of a 
string. This function is called by the String.prototype.replace() method.

*/

class Replace1 {
    constructor(value) {
      this.value = value;
    }
    [Symbol.replace](string) {
      return `s/${string}/${this.value}/g`;
    }
  }
  
  console.log('foo'.replace(new Replace1('bar')));
  // expected output: "s/foo/bar/g"

//--------------------------Symbol.search----------------------------------------------------------

/*
The Symbol.search well-known symbol specifies the method that returns the index within a string 
that matches the regular expression. This function is called by the String.prototype.search() method.

*/

class Search1 {
    constructor(value) {
      this.value = value;
    }
    [Symbol.search](string) {
      return string.indexOf(this.value);
    }
  }
  
  console.log('foobar'.search(new Search1('bar')));
  // expected output: 3

//--------------------------Symbol.split----------------------------------------------------------

/*
The Symbol.split well-known symbol specifies the method that splits a string at the indices 
that match a regular expression. This function is called by the String.prototype.split() method.

*/

class Split1 {
    constructor(value) {
      this.value = value;
    }
    [Symbol.split](string) {
      const index = string.indexOf(this.value);
      return this.value + string.substr(0, index) + "/"
        + string.substr(index + this.value.length);
    }
  }
  
  console.log('foobar'.split(new Split1('foo')));
  // expected output: "foo/bar"

//--------------------------Symbol.hasInstance----------------------------------------------------------

/*
The Symbol.hasInstance well-known symbol is used to determine if a constructor object recognizes an 
object as its instance. The instanceof operator's behavior can be customized by this symbol.

*/

class Array1 {
    static [Symbol.hasInstance](instance) {
      return Array.isArray(instance);
    }
  }
  
  console.log([] instanceof Array1);
  // expected output: true

  
//--------------------------Symbol.for()----------------------------------------------------------

/*
The Symbol.for(key) method searches for existing symbols in a runtime-wide symbol registry 
with the given key and returns it if found. Otherwise a new symbol gets created in the global 
symbol registry with this key.

In contrast to Symbol(), the Symbol.for() function creates a symbol available in a global symbol 
registry list. Symbol.for() does also not necessarily create a new symbol on every call, but 
checks first if a symbol with the given key is already present in the registry. In that case, 
that symbol is returned. If no symbol with the given key is found, Symbol.for() will create a new 
global symbol.

*/

Symbol.for('foo'); // create a new global symbol
Symbol.for('foo'); // retrieve the already created symbol

// Same global symbol, but not locally
Symbol.for('bar') === Symbol.for('bar'); // true
Symbol('bar') === Symbol('bar'); // false

// The key is also used as the description
var sym = Symbol.for('mario');
sym.toString(); // "Symbol(mario)"

/* To avoid name clashes with your global symbol keys and other (library code) global symbols, 
it might be a good idea to prefix your symbols:
*/

Symbol.for('mdn.foo');
Symbol.for('mdn.bar');

//--------------------------Symbol.keyFor()----------------------------------------------------------

/*
The Symbol.keyFor(sym) method retrieves a shared symbol key from the global symbol registry 
for the given symbol.

*/

var globalSym = Symbol.for('foo'); // create a new global symbol
Symbol.keyFor(globalSym); // "foo"

var localSym = Symbol();
Symbol.keyFor(localSym); // undefined

// well-known symbols are not symbols registered 
// in the global symbol registry
Symbol.keyFor(Symbol.iterator) // undefined