function makeAjaxRequest(URL, method){
    if(!method){
        method = 'GET'
    }
    return method;
}

console.log(makeAjaxRequest('google'));
console.log(makeAjaxRequest('google','GET'));

//ES6

function makeAjaxRequest1(URL, method = 'GET'){
   return method;
}

console.log(makeAjaxRequest1('google'));
console.log(makeAjaxRequest1('google','GET'));