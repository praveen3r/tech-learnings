var car = { color: "red", name: "Honda"};
console.log(car.name);
var car = {};
car["name"] = "Honda";
console.log(car["name"]);
console.log(car.name);

var car = { color: "red", name: "Honda"};
for(var p in car){
    console.log(`key is ${p} and value is ${car[p]}`)
}