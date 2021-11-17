//---------------------Void-----------------------------------------------

function printResult(num: number): void {
    console.log('Result: ' + num);
  }

  printResult(11);

//---------------------Never-----------------------------------------------

/*
The never type represents the type of values that never occur. For instance, never is the return type 
for a function expression or an arrow function expression that always throws an exception or one that
never returns; Variables also acquire the type never when narrowed by any type guards that can never
be true.

The never type is a subtype of, and assignable to, every type; however, no type is a subtype of,
or assignable to, never (except never itself). Even any isn’t assignable to never.
*/

function generateError(message: string, code: number): never {
    throw { message: message, errorCode: code };
    // while (true) {}
  }
  
  const result = generateError('An error occurred!', 500);
  console.log(result)

  //Examples

  // Function returning never must have unreachable end point
function error(message: string): never {
    throw new Error(message);
}

// Inferred return type is never
function fail() {
    return error("Something failed");
}

// Function returning never must have unreachable end point
function infiniteLoop(): never {
    while (true) {
    }
}

//---------------------------------Union-----------------------------------------------------

function combine(input1: number | string, input2: number | string) : number | string{
  let result;
  if (typeof input1 === 'number' && typeof input2 === 'number') {
    result = input1 + input2;
  } else {
    result = input1.toString() + input2.toString();
  }
  return result;
}

const combinedAges = combine(30, 26);
  console.log(combinedAges);
  
  const combinedNames = combine('Max', 'Anna');
  console.log(combinedNames);
