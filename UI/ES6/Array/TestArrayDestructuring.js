const companies = [
    'TCS',
    'Infosys',
    'Google'
]

const [name] = companies;

console.log(name);

const [name, ...rest] = companies;

console.log(name);
console.log(rest);

//Scenario two (pull out name JSON property from first object in the array)
const companiesNew = [
    {name: 'TCS', location:'EC'},
    {name: 'Infosys', location:'EC'},
    {name: 'TCS', location:'EC'}
]

const [{name}] = companiesNew;

console.log(name);

//Scenario three (pull out first object in the array from a JSON)
const TCS = {
    locations: ['EC', 'ITPL', 'Chennai']
}

const { locations: [location]} = TCS;

console.log(location);