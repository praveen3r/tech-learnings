/*
A function’s type has the same two parts: the type of the arguments and the return type. 
When writing out the whole function type, both parts are required. We write out the parameter 
types just like a parameter list, giving each parameter a name and a type. This name is just to 
help with readability. We could have instead written:
*/

function add(n1: number, n2: number) {
    return n1 + n2;
  }

  let combineValues: (a: number, b: number) => number;

combineValues = add;
// combineValues = printResult;
// combineValues = 5;

console.log(combineValues(8, 8));

/*
As long as the parameter types line up, it’s considered a valid type for the function, 
regardless of the names you give the parameters in the function type.

The second part is the return type. We make it clear which is the return type by using a fat arrow 
(=>) between the parameters and the return type. As mentioned before, this is a required part of the 
function type, so if the function doesn’t return a value, you would use void instead of leaving it off.

Of note, only the parameters and the return type make up the function type. Captured variables are not 
reflected in the type. In effect, captured variables are part of the “hidden state” of any function 
and do not make up its API.

*/


//----------------------------Callback----------------------------------------------

function addAndHandle(n1: number, n2: number, cb: (num: number) => void) {
    const result = n1 + n2;
    cb(result);
  }

  addAndHandle(10, 20, (result) => {
    console.log(result);
  });