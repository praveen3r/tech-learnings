let numbers = [1, 2, 3, 4, 5];
let sum = 0;
numbers.forEach(function(number){
    sum += number;
});
console.log(sum);

function adder(number){
  sum += number;
}
numbers.forEach(adder);

console.log(sum);

numbers.forEach(number => {
    sum += number;
});

console.log(sum);

//single line only
numbers.forEach(number => sum += number);

console.log(sum);