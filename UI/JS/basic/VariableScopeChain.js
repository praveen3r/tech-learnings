//Global
function a(){
    scopeVar = 2;
    console.log(scopeVar);
}

function b(){
    console.log(scopeVar);
}

var scopeVar = 1;
console.log(scopeVar);

//Nested

function a(){
    function b(){
        console.log(scopeVar);
    }
    scopeVar = 2;
    b();
}



var scopeVar = 1;
console.log(scopeVar);