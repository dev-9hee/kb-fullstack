const user = require('./02_user'); // 02_user.js에서 user 가져오기
const hello = require('./03_hello'); // 03_hello.js에서 hello 가져오기

console.log(user);
console.log(hello);

hello(user); // 모듈에서 가져온 user 변수와 hello 함수 사용하기
