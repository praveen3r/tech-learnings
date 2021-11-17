var x = false;
var y = undefined;
console.log(x == y);

function checkFalsy(z){
    if(z){
        console.log("true");
    }else{
        console.log("false");
    }
}

checkFalsy(undefined);
checkFalsy(null);
checkFalsy(' ');
checkFalsy(0);
checkFalsy(NaN);