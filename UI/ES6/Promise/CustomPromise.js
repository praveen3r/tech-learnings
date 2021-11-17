//--------------------------Successfully resolve---------------------------------------------------------

/*
    promise.then(
    function(result) { // handle a successful result  },
    function(error) { // handle an error  }
    );
*/

let promise = new Promise(function(resolve, reject) {
  setTimeout(() => resolve("done!"), 1000);
});

// resolve runs the first function in .then
promise.then(
  result => alert(result), // shows "done!" after 1 second
  error => alert(error) // doesn't run
);

//--------------------------Reject-----------------------------------------------------------------------

let promise = new Promise(function(resolve, reject) {
    setTimeout(() => reject(new Error("Whoops!")), 1000);
  });
  
  // reject runs the second function in .then
  promise.then(
    result => alert(result), // doesn't run
    error => alert(error) // shows "Error: Whoops!" after 1 second
  );

//--------------------------Only Successful-------------------------------------------------------------

let promise = new Promise(resolve => {
    setTimeout(() => resolve("done!"), 1000);
  });
  
  promise.then(alert); // shows "done!" after 1 second

  //--------------------------Only errors-------------------------------------------------------------

  let promise = new Promise((resolve, reject) => {
    setTimeout(() => reject(new Error("Whoops!")), 1000);
  });
  
  // .catch(f) is the same as promise.then(null, f)
  promise.catch(alert); // shows "Error: Whoops!" after 1 second

  //--------------------------finally-----------------------------------------------------------------

 /*
 The call .finally(f) is similar to .then(f, f) in the sense that f always runs when the promise is 
  settled: be it resolve or reject.

  1) A finally handler has no arguments. In finally we don’t know whether the promise is successful 
  or not. That’s all right, as our task is usually to perform “general” finalizing procedures.

  2) A finally handler passes through results and errors to the next handler.
*/

new Promise((resolve, reject) => {
    setTimeout(() => resolve("result"), 2000)
  })
    .finally(() => alert("Promise ready"))
    .then(result => alert(result)); // <-- .then handles the result

//--------------------------Resolve immediately----------------------------------------------------------

// the promise becomes resolved immediately upon creation
let promise = new Promise(resolve => resolve("done!"));

promise.then(alert); // done! (shows up right now)
