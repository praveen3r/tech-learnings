var car = '{ "color": "red", "name": "Honda"}';
var newCar = JSON.parse(car); //convert json string to javascript object
console.log(newCar.color)