/*
The JSON object contains methods for parsing JavaScript Object Notation (JSON) and converting values 
to JSON. It can't be called or constructed, and aside from its two method properties, it has no 
interesting functionality of its own.
*/

//--------------------------JavaScript and JSON differences--------------------------------------------

/*
JSON is a syntax for serializing objects, arrays, numbers, strings, booleans, and null. It is based 
upon JavaScript syntax but is distinct from it: some JavaScript is not JSON.

Objects and Arrays
--------------------
Property names must be double-quoted strings; trailing commas are forbidden.

Numbers
--------
Leading zeros are prohibited. A decimal point must be followed by at least one digit. NaN and 
Infinity are unsupported.

Any JSON text is a valid JavaScript expression...

...But only in JavaScript engines that have implemented the proposal to make all JSON text valid 
ECMA-262. In engines that haven't implemented the proposal, U+2028 LINE SEPARATOR and U+2029 
PARAGRAPH SEPARATOR are allowed in string literals and property keys in JSON; but their use in 
these features in JavaScript string literals is a SyntaxError.
Consider this example where JSON.parse() parses the string as JSON and eval executes the string as 
JavaScript:

let code = '"\u2028\u2029"'
JSON.parse(code)  // evaluates to "\u2028\u2029" in all engines
eval(code)        // throws a SyntaxError in old engines

Other differences include allowing only double-quoted strings and having no provisions for 
undefined or comments. For those who wish to use a more human-friendly configuration format 
based on JSON, there is JSON5, used by the Babel compiler, and the more commonly used YAML.
*/

//--------------------------Syntax----------------------------------------------------------------

/*
JSON = null
    or true or false
    or JSONNumber
    or JSONString
    or JSONObject
    or JSONArray

JSONNumber = - PositiveNumber
          or PositiveNumber
PositiveNumber = DecimalNumber
              or DecimalNumber . Digits
              or DecimalNumber . Digits ExponentPart
              or DecimalNumber ExponentPart
DecimalNumber = 0
             or OneToNine Digits
ExponentPart = e Exponent
            or E Exponent
Exponent = Digits
        or + Digits
        or - Digits
Digits = Digit
      or Digits Digit
Digit = 0 through 9
OneToNine = 1 through 9

JSONString = ""
          or " StringCharacters "
StringCharacters = StringCharacter
                or StringCharacters StringCharacter
StringCharacter = any character
                  except " or \ or U+0000 through U+001F
               or EscapeSequence
EscapeSequence = \" or \/ or \\ or \b or \f or \n or \r or \t
              or \u HexDigit HexDigit HexDigit HexDigit
HexDigit = 0 through 9
        or A through F
        or a through f

JSONObject = { }
          or { Members }
Members = JSONString : JSON
       or Members , JSONString : JSON

JSONArray = [ ]
         or [ ArrayElements ]
ArrayElements = JSON
             or ArrayElements , JSON



Insignificant whitespace may be present anywhere except within a JSONNumber (numbers must contain 
no whitespace) or JSONString (where it is interpreted as the corresponding character in the string,
or would cause an error). The tab character (U+0009), carriage return (U+000D), line feed (U+000A),
and space (U+0020) characters are the only valid whitespace characters.
*/

//--------------------------JSON.parse---------------------------------------------------------------

//JSON.parse(text[, reviver])

/*
The JSON.parse() method parses a JSON string, constructing the JavaScript value or object 
described by the string. An optional reviver function can be provided to perform a transformation 
on the resulting object before it is returned.
*/

const json = '{"result":true, "count":42}';
const obj = JSON.parse(json);

console.log(obj.count);
// expected output: 42

console.log(obj.result);
// expected output: true

JSON.parse('{}');              // {}
JSON.parse('true');            // true
JSON.parse('"foo"');           // "foo"
JSON.parse('[1, 5, "false"]'); // [1, 5, "false"]
JSON.parse('null');            // null

//Using the reviver parameter
//-------------------------------

/*
If a reviver is specified, the value computed by parsing is transformed before being returned. 
Specifically, the computed value and all its properties (beginning with the most nested properties 
and proceeding to the original value itself) are individually run through the reviver. Then it is 
called, with the object containing the property being processed as this, and with the property 
name as a string, and the property value as arguments. If the reviver function returns undefined 
(or returns no value, for example, if execution falls off the end of the function), the property 
is deleted from the object. Otherwise, the property is redefined to be the return value.

If the reviver only transforms some values and not others, be certain to return all untransformed 
values as-is, otherwise, they will be deleted from the resulting object.
*/

JSON.parse('{"p": 5}', (key, value) =>
  typeof value === 'number'
    ? value * 2 // return value * 2 for numbers
    : value     // return everything else unchanged
);

// { p: 10 }

JSON.parse('{"1": 1, "2": 2, "3": {"4": 4, "5": {"6": 6}}}', (key, value) => {
  console.log(key); // log the current property name, the last is "".
  return value;     // return the unchanged property value.
});

// 1
// 2
// 4
// 6
// 5
// 3 
// ""

//JSON.parse() does not allow trailing commas

// both will throw a SyntaxError
JSON.parse('[1, 2, 3, 4, ]');
JSON.parse('{"foo" : 1, }');

//JSON.parse() does not allow single quotes

// will throw a SyntaxError
JSON.parse("{'foo': 1}");

//--------------------------JSON.stringify---------------------------------------------------------------

//JSON.stringify(value[, replacer[, space]])

/*
The JSON.stringify() method converts a JavaScript object or value to a JSON string, optionally replacing 
values if a replacer function is specified or optionally including only the specified properties if a 
replacer array is specified.

JSON.stringify() converts a value to JSON notation representing it:

1) If the value has a toJSON() method, it's responsible to define what data will be serialized.

2) Boolean, Number, and String objects are converted to the corresponding primitive values during 
   stringification, in accord with the traditional conversion semantics.

3) undefined, Functions, and Symbols are not valid JSON values. If any such values are encountered 
    during conversion they are either omitted (when found in an object) or changed to null (when found 
    in an array). JSON.stringify() can return undefined when passing in "pure" values like 
    JSON.stringify(function(){}) or JSON.stringify(undefined).

4) All Symbol-keyed properties will be completely ignored, even when using the replacer function.
    The instances of Date implement the toJSON() function by returning a string (the same as 
    date.toISOString()). Thus, they are treated as strings.

5) The numbers Infinity and NaN, as well as the value null, are all considered null.

6) All the other Object instances (including Map, Set, WeakMap, and WeakSet) will have only their 
    enumerable properties serialized.
*/

console.log(JSON.stringify({ x: 5, y: 6 }));
// expected output: "{"x":5,"y":6}"

console.log(JSON.stringify([new Number(3), new String('false'), new Boolean(false)]));
// expected output: "[3,"false",false]"

console.log(JSON.stringify({ x: [10, undefined, function(){}, Symbol('')] }));
// expected output: "{"x":[10,null,null,null]}"

console.log(JSON.stringify(new Date(2006, 0, 2, 15, 4, 5)));
// expected output: ""2006-01-02T15:04:05.000Z""

JSON.stringify({});                    // '{}'
JSON.stringify(true);                  // 'true'
JSON.stringify('foo');                 // '"foo"'
JSON.stringify([1, 'false', false]);   // '[1,"false",false]'
JSON.stringify([NaN, null, Infinity]); // '[null,null,null]'
JSON.stringify({ x: 5 });              // '{"x":5}'

JSON.stringify(new Date(2006, 0, 2, 15, 4, 5)) 
// '"2006-01-02T15:04:05.000Z"'

JSON.stringify({ x: 5, y: 6 });
// '{"x":5,"y":6}'
JSON.stringify([new Number(3), new String('false'), new Boolean(false)]);
// '[3,"false",false]'

// String-keyed array elements are not enumerable and make no sense in JSON
let a = ['foo', 'bar'];
a['baz'] = 'quux';      // a: [ 0: 'foo', 1: 'bar', baz: 'quux' ]
JSON.stringify(a); 
// '["foo","bar"]'

JSON.stringify({ x: [10, undefined, function(){}, Symbol('')] }); 
// '{"x":[10,null,null,null]}' 

// Standard data structures
JSON.stringify([new Set([1]), new Map([[1, 2]]), new WeakSet([{a: 1}]), new WeakMap([[{a: 1}, 2]])]);
// '[{},{},{},{}]'

// TypedArray
JSON.stringify([new Int8Array([1]), new Int16Array([1]), new Int32Array([1])]);
// '[{"0":1},{"0":1},{"0":1}]'
JSON.stringify([new Uint8Array([1]), new Uint8ClampedArray([1]), new Uint16Array([1]), new Uint32Array([1])]);
// '[{"0":1},{"0":1},{"0":1},{"0":1}]'
JSON.stringify([new Float32Array([1]), new Float64Array([1])]);
// '[{"0":1},{"0":1}]'
 
// toJSON()
JSON.stringify({ x: 5, y: 6, toJSON(){ return this.x + this.y; } });
// '11'

// Symbols:
JSON.stringify({ x: undefined, y: Object, z: Symbol('') });
// '{}'
JSON.stringify({ [Symbol('foo')]: 'foo' });
// '{}'
JSON.stringify({ [Symbol.for('foo')]: 'foo' }, [Symbol.for('foo')]);
// '{}'
JSON.stringify({ [Symbol.for('foo')]: 'foo' }, function(k, v) {
  if (typeof k === 'symbol') {
    return 'a symbol';
  }
});
// undefined

// Non-enumerable properties:
JSON.stringify( Object.create(null, { x: { value: 'x', enumerable: false }, y: { value: 'y', enumerable: true } }) );
// '{"y":"y"}'


// BigInt values throw
JSON.stringify({x: 2n});
// TypeError: BigInt value can't be serialized in JSON

//--------------------------replacer parameter----------------------------------------------------------

/*
The replacer parameter can be either a function or an array.

As a function, it takes two parameters: the key and the value being stringified. The object in which 
the key was found is provided as the replacer's this parameter.

Initially, the replacer function is called with an empty string as key representing the object being 
stringified. It is then called for each property on the object or array being stringified.

It should return the value that should be added to the JSON string, as follows:

1) If you return a Number, the string corresponding to that number is used as the value for the 
    property when added to the JSON string.

2) If you return a String, that string is used as the property's value when adding it to the JSON string.

3) If you return a Boolean, "true" or "false" is used as the property's value, as appropriate, when 
    adding it to the JSON string.

4) If you return null, null will be added to the JSON string.

5) If you return any other object, the object is recursively stringified into the JSON string, 
    calling the replacer function on each property, unless the object is a function, in which case 
    nothing is added to the JSON string.

6) If you return undefined, the property is not included (i.e., filtered out) in the output JSON string.
*/

//replacer, as a function
//------------------------

function replacer(key, value) {
    // Filtering out properties
    if (typeof value === 'string') {
      return undefined;
    }
    return value;
  }
  
  var foo = {foundation: 'Mozilla', model: 'box', week: 45, transport: 'car', month: 7};
  JSON.stringify(foo, replacer);
  // '{"week":45,"month":7}'

  //replacer, as an array
  //------------------------

  //If replacer is an array, the array's values indicate the names of the properties in the object 
  //that should be included in the resulting JSON string.

  JSON.stringify(foo, ['week', 'month']);  
  // '{"week":45,"month":7}', only keep "week" and "month" properties

 //The space argument
 //--------------------

 /*
 The space argument may be used to control spacing in the final string.

 1) If it is a number, successive levels in the stringification will each be indented by this many 
    space characters (up to 10).

2) If it is a string, successive levels will be indented by this string (or the first ten characters 
    of it).
 */

JSON.stringify({ a: 2 }, null, ' ');
// '{
//  "a": 2
// }'

//Using a tab character mimics standard pretty-print appearance:
JSON.stringify({ uno: 1, dos: 2 }, null, '\t');
// returns the string:
// '{
//     "uno": 1,
//     "dos": 2
// }'

//toJSON() behavior
/*If an object being stringified has a property named toJSON whose value is a function, then the 
    toJSON() method customizes JSON stringification behavior: instead of the object being serialized, 
    the value returned by the toJSON() method when called will be serialized. JSON.stringify() calls 
    toJSON with one parameter:

1) if this object is a property value, the property name

2) if it is in an array, the index in the array, as a string

3) an empty string if JSON.stringify() was directly called on this object
*/

var obj = {
    data: 'data',
    
    toJSON (key) {
        if (key)
            return `Now I am a nested object under key '${key}'`;
        else
            return this;
    }
};

JSON.stringify(obj);
// '{"data":"data"}'

JSON.stringify({ obj })
// '{"obj":"Now I am a nested object under key 'obj'"}'

JSON.stringify([ obj ])
// '["Now I am a nested object under key '0'"]'

//Issue with JSON.stringify() when serializing circular references
//------------------------------------------------------------------

const circularReference = {};
circularReference.myself = circularReference;

// Serializing circular references throws "TypeError: cyclic object value"
JSON.stringify(circularReference);