//arr.sort([compareFunction])

/*
The sort() method sorts the elements of an array in place and returns the sorted array. 
The default sort order is ascending, built upon converting the elements into strings, 
then comparing their sequences of UTF-16 code units values.

The time and space complexity of the sort cannot be guaranteed as it depends on the implementation.

If compareFunction is not supplied, all non-undefined array elements are sorted by converting them to strings and comparing strings in UTF-16 code units order. For example, "banana" comes before "cherry". In a numeric sort, 9 comes before 80, but because numbers are converted to strings, "80" comes before "9" in the Unicode order. All undefined elements are sorted to the end of the array.

Note : In UTF-16, Unicode characters above \uFFFF are encoded as two surrogate code units, of the range \uD800-\uDFFF. The value of each code unit is taken separately into account for the comparison. Thus the character formed by the surrogate pair \uD655\uDE55 will be sorted before the character \uFF3A.

If compareFunction is supplied, all non-undefined array elements are sorted according to the return value of the compare function (all undefined elements are sorted to the end of the array, with no call to compareFunction). If a and b are two elements being compared, then:

If compareFunction(a, b) returns less than 0, sort a to an index lower than b (i.e. a comes first).
If compareFunction(a, b) returns 0, leave a and b unchanged with respect to each other, but sorted with respect to all different elements. Note: the ECMAscript standard does not guarantee this behavior, thus, not all browsers (e.g. Mozilla versions dating back to at least 2003) respect this.
If compareFunction(a, b) returns greater than 0, sort b to an index lower than a (i.e. b comes first).
compareFunction(a, b) must always return the same value when given a specific pair of elements a and b as its two arguments. If inconsistent results are returned, then the sort order is undefined.
So, the compare function has the following form:

function compare(a, b) {
  if (a is less than b by some ordering criterion) {
    return -1;
  }
  if (a is greater than b by the ordering criterion) {
    return 1;
  }
  // a must be equal to b
  return 0;
}
To compare numbers instead of strings, the compare function can simply subtract b from a. The following function will sort the array in ascending order (if it doesn't contain Infinity and NaN):

function compareNumbers(a, b) {
  return a - b;
}
The sort method can be conveniently used with function expressions:

var numbers = [4, 2, 5, 1, 3];
numbers.sort(function(a, b) {
  return a - b;
});
console.log(numbers);

// [1, 2, 3, 4, 5]
ES2015 provides arrow function expressions with even shorter syntax.

let numbers = [4, 2, 5, 1, 3];
numbers.sort((a, b) => a - b);
console.log(numbers);

// [1, 2, 3, 4, 5]
Objects can be sorted, given the value of one of their properties.

var items = [
  { name: 'Edward', value: 21 },
  { name: 'Sharpe', value: 37 },
  { name: 'And', value: 45 },
  { name: 'The', value: -12 },
  { name: 'Magnetic', value: 13 },
  { name: 'Zeros', value: 37 }
];

// sort by value
items.sort(function (a, b) {
  return a.value - b.value;
});

// sort by name
items.sort(function(a, b) {
  var nameA = a.name.toUpperCase(); // ignore upper and lowercase
  var nameB = b.name.toUpperCase(); // ignore upper and lowercase
  if (nameA < nameB) {
    return -1;
  }
  if (nameA > nameB) {
    return 1;
  }

  // names must be equal
  return 0;
});


*/

//--------------------------Creating, displaying, and sorting an array----------------------------

var stringArray = ['Blue', 'Humpback', 'Beluga'];
var numericStringArray = ['80', '9', '700'];
var numberArray = [40, 1, 5, 200];
var mixedNumericArray = ['80', '9', '700', 40, 1, 5, 200];

function compareNumbers(a, b) {
  return a - b;
}

console.log('stringArray:', stringArray.join());
console.log('Sorted:', stringArray.sort());

console.log('numberArray:', numberArray.join());
console.log('Sorted without a compare function:', numberArray.sort());
console.log('Sorted with compareNumbers:', numberArray.sort(compareNumbers));

console.log('numericStringArray:', numericStringArray.join());
console.log('Sorted without a compare function:', numericStringArray.sort());
console.log('Sorted with compareNumbers:', numericStringArray.sort(compareNumbers));

console.log('mixedNumericArray:', mixedNumericArray.join());
console.log('Sorted without a compare function:', mixedNumericArray.sort());
console.log('Sorted with compareNumbers:', mixedNumericArray.sort(compareNumbers));

/* This example produces the following output. As the output shows, when a compare function is used, numbers sort correctly whether they are numbers or numeric strings.

stringArray: Blue,Humpback,Beluga
Sorted: Beluga,Blue,Humpback

numberArray: 40,1,5,200
Sorted without a compare function: 1,200,40,5
Sorted with compareNumbers: 1,5,40,200

numericStringArray: 80,9,700
Sorted without a compare function: 700,80,9
Sorted with compareNumbers: 9,80,700

mixedNumericArray: 80,9,700,40,1,5,200
Sorted without a compare function: 1,200,40,5,700,80,9
Sorted with compareNumbers: 1,5,9,40,80,200,700
*/



//------------------------Sorting non-ASCII characters---------------------------------

var items = ['réservé', 'premier', 'communiqué', 'café', 'adieu', 'éclair'];
items.sort(function (a, b) {
  return a.localeCompare(b);
});

// items is ['adieu', 'café', 'communiqué', 'éclair', 'premier', 'réservé']


//------------------------Sorting with map--------------------------------------------

/*
The compareFunction can be invoked multiple times per element within the array. Depending on the 
compareFunction's nature, this may yield a high overhead. The more work a compareFunction does and 
the more elements there are to sort, it may be more efficient to use map for sorting. The idea is to 
traverse the array once to extract the actual values used for sorting into a temporary array, sort 
the temporary array, and then traverse the temporary array to achieve the right order.
*/


// the array to be sorted
var list = ['Delta', 'alpha', 'CHARLIE', 'bravo'];

// temporary array holds objects with position and sort-value
var mapped = list.map(function(el, i) {
  return { index: i, value: el.toLowerCase() };
})

// sorting the mapped array containing the reduced values
mapped.sort(function(a, b) {
  if (a.value > b.value) {
    return 1;
  }
  if (a.value < b.value) {
    return -1;
  }
  return 0;
});

// container for the resulting order
var result = mapped.map(function(el){
  return list[el.index];
});