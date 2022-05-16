const moment = require("moment");

/*const startDate = new Date();
const start_date =moment(startDate,'YYYY-MM-DD HH:mm:ss');

const endDate = new Date();
const end_date =moment(endDate,'YYYY-MM-DD HH:mm:ss');*/

const startDate = moment();

for(let i=1; i< 999999999; i++){
    let gh='ad';
}
const endDate = moment();

/*const duration = moment.duration(end_date.diff(start_date));
const time = duration.asMilliseconds;*/

//const time = endDate.diff(startDate, 'seconds', true);

var duration = moment.duration(endDate.diff(startDate));
var seconds = duration.asSeconds();

//console.log(`time duration ${time}`);
console.log(`time duration ${seconds}`);