fs = require('fs');

const data = fs.readFileSync('./example.txt', 'utf-8');
fs.writeFileSync('./text-1.txt', data); // example 내용을 text-1에 저장
