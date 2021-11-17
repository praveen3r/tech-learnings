const expense = {
    type: 'Shopping',
    amount: 20
}

//const { type} = expense;
//const { amount} = expense;

const { type, amount} = expense;

console.log(type);
console.log(amount);

//second case
const employee = {
    name: 'Sachin',
    age: 30,
    type: 'batsman'
}

function getEmployee({name, age, type}){
    return `Employee name is ${name} and age is ${age} and type is ${type}`
}

console.log(getEmployee(employee))