function getData(){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET","https://jsonplaceholder.typicode.com/posts/1", true);
    xmlHttp.onload = function(event){
        console.log(xmlHttp);
        console.log(xmlHttp.status);
        console.log(xmlHttp.responseText);
    }
    xmlHttp.onerror = function(event){
        console.log("Error");
    }
    xmlHttp.send();
}

getData();