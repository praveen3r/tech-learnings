//--------------------------same description – not equal------------------------------------------------

let id1 = Symbol("id");
let id2 = Symbol("id");

alert(id1 == id2); // false

//--------------------------Symbols to a string--------------------------------------------------------

let id = Symbol("id");
alert(id); // TypeError: Cannot convert a Symbol value to a string

//If we really want to show a symbol, we need to explicitly call .toString() on it, like here:

let id = Symbol("id");
alert(id.toString()); // Symbol(id), now it works

let id = Symbol("id");
alert(id.description); // id

//--------------------------“Hidden” properties-------------------------------------------------------

/*
Symbols allow us to create “hidden” properties of an object, that no other part of code can 
accidentally access or overwrite.
*/
let user = { // belongs to another code
    name: "John"
  };
  
  let id = Symbol("id");
  
  user[id] = 1;
  
  alert( user[id] ); // we can access the data using the symbol as the key

/*
As user objects belongs to another code, and that code also works with them, we shouldn’t just add 
any fields to it. That’s unsafe. But a symbol cannot be accessed accidentally, the third-party 
code probably won’t even see it, so it’s probably all right to do.
*/

//--------------------------Symbols in a literal-------------------------------------------------------

let id = Symbol("id");

let user = {
  name: "John",
  [id]: 123 // not "id: 123"
};

//That’s because we need the value from the variable id as the key, not the string “id”.

//Symbolic properties do not participate in for..in loop.

//For instance:

let id = Symbol("id");
let user = {
  name: "John",
  age: 30,
  [id]: 123
};

for (let key in user) alert(key); // name, age (no symbols)

// the direct access by the symbol works
alert( "Direct: " + user[id] );

//--------------------------Symbols in a literal-------------------------------------------------------

/* 
Object.keys(user) also ignores them. That’s a part of the general “hiding symbolic properties”
principle. If another script or a library loops over our object, it won’t unexpectedly access a 
symbolic property.
*/

//In contrast, Object.assign copies both string and symbol properties:

let id = Symbol("id");
let user = {
  [id]: 123
};

let clone = Object.assign({}, user);

alert( clone[id] ); // 123

//--------------------------Global symbols-----------------------------------------------------------

/* 
As we’ve seen, usually all symbols are different, even if they have the same name. But sometimes 
we want same-named symbols to be same entities. For instance, different parts of our application 
want to access symbol "id" meaning exactly the same property.

To achieve that, there exists a global symbol registry. We can create symbols in it and access 
them later, and it guarantees that repeated accesses by the same name return exactly the same symbol.

In order to read (create if absent) a symbol from the registry, use Symbol.for(key).

That call checks the global registry, and if there’s a symbol described as key, then returns it, 
otherwise creates a new symbol Symbol(key) and stores it in the registry by the given key.
*/

// read from the global registry
let id = Symbol.for("id"); // if the symbol did not exist, it is created

// read it again (maybe from another part of the code)
let idAgain = Symbol.for("id");

// the same symbol
alert( id === idAgain ); // true

//--------------------------Symbol.keyFor-----------------------------------------------------------

/* 
For global symbols, not only Symbol.for(key) returns a symbol by name, but there’s a reverse 
call: Symbol.keyFor(sym), that does the reverse: returns a name by a global symbol.
*/

// get symbol by name
let sym = Symbol.for("name");
let sym2 = Symbol.for("id");

// get name by symbol
alert( Symbol.keyFor(sym) ); // name
alert( Symbol.keyFor(sym2) ); // id

/*
The Symbol.keyFor internally uses the global symbol registry to look up the key for the symbol. 
So it doesn’t work for non-global symbols. If the symbol is not global, it won’t be able to find it 
and returns undefined.
*/

let globalSymbol = Symbol.for("name");
let localSymbol = Symbol("name");

alert( Symbol.keyFor(globalSymbol) ); // name, global symbol
alert( Symbol.keyFor(localSymbol) ); // undefined, not global

alert( localSymbol.description ); // name