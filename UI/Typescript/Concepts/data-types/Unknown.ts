/*
TypeScript 3.0 introduces a new top type unknown. unknown is the type-safe counterpart of any. 
Anything is assignable to unknown, but unknown isn’t assignable to anything but itself and any 
without a type assertion or a control flow based narrowing. Likewise, no operations are permitted 
on an unknown without first asserting or narrowing to a more specific type.
*/

let userInput: unknown;
let userName: string;

userInput = 5;
userInput = 'Max';
if (typeof userInput === 'string') {
  userName = userInput;
}