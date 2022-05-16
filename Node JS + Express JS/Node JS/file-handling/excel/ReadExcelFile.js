const reader = require('xlsx');


const startDate = new Date();
// Reading our test file
const file = reader.readFile('C:/Docs/Test/Book1.xlsx')
  

let data = []
  
const sheets = file.SheetNames;
  
for(let i = 0; i < sheets.length; i++)
{
   const temp = reader.utils.sheet_to_json(
        file.Sheets[file.SheetNames[i]]);

   temp.forEach((res) => {
      data.push(res);
   })
}
  
// Printing data
//console.log(data);

const endDate = new Date();

const diff = (endDate.getTime() - startDate.getTime())/ 1000;

console.log(`time diff ${diff}`);