fs = require('fs');
const data = fs.readFileSync('./example.txt', 'utf-8');
console.log(data);
