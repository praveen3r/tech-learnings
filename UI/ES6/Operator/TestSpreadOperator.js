const defaultColors = ['red','blue'];
const userPreferedColors = ['orange','black'];

console.log([...defaultColors]);
console.log([...userPreferedColors]);
console.log([...defaultColors, ...userPreferedColors]);
console.log(['milk',...defaultColors, ...userPreferedColors]);
