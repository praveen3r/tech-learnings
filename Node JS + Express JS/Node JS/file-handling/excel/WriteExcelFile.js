const writer = require('xlsx');

//const file = writer.readFile('C:/Docs/Test/output.xlsx');

const workbook = writer.utils.book_new();
// Sample data set
let test_data = [{
   id: 1,
   name:'Nikhil',
   Age:22
},
{
   id: 2,
   name:'Shree',
   Age:21,
}]

const ws = writer.utils.json_to_sheet(test_data);
 
writer.utils.book_append_sheet(workbook, ws,"sheet1");

// Writing to our file
writer.writeFile(workbook,'C:/Docs/Test/output.xlsx');
