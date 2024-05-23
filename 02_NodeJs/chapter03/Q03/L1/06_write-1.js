fs = require('fs');
const data = fs.readFileSync('./example.txt', 'utf8');
fs.writeFileSync('./text-1.txt', data);
