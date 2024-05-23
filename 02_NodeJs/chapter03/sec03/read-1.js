fs = require('fs');

const data = fs.readFileSync('./example.txt');
console.log(data);
