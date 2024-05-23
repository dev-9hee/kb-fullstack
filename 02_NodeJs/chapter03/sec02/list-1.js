const fs = require('fs');

// 현재 디렉터리 읽기, 동기 처리로 디렉터리 읽기
let files = fs.readdirSync('./');
console.log(files);
