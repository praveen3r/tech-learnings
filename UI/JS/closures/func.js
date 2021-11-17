var scope = "global scope";
function checkScope(){
    var scope = "local scope";
    function f(){
        return scope;
    }
    f();
}

console.log(checkScope());

function checkScope(){
    var scope = "local scope";
    function f(){
        return scope;
    }
    f;
}

console.log(checkScope());

console.log(checkScope() ());

function step_iterator(start, step){
    return function(){
        start = start + step;
        return start;
    }
}


var iterator1 = step_iterator(0,2);
console.log(iterator1());
console.log(iterator1());

function step_iterator1(start, step){
    start = start + step;
    return start;
    
}


var iterator1 = step_iterator1(0,2);
console.log(iterator1());
console.log(iterator1());