//import { userInfo as _userInfo } from 'os';
const os = require('os')

//returns user info
//const userInfo = _userInfo();
const userInfo = os.userInfo();

console.log(userInfo);

//returns system uptime in seconds
console.log(`system uptime is ${os.uptime()} seconds`);

const currentOs = {
    type: os.type(),
    release: os.release(),
    totalMem: os.totalmem(),
    freeMem: os.freemem()
}

console.log(currentOs);