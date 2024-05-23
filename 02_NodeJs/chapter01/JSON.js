// 객체
const jhObj = {
  name: '정지희',
  hobbies: ['Drink', 'cafe', 'Bicycle'],
};

console.log(jhObj);
const strJhObj = JSON.stringify(jhObj); // 객체를 문자열화
console.log(strJhObj);
console.log(typeof jhObj); // object
console.log(typeof strJhObj); // string
console.log(jhObj.name); // 정지희
console.log(strJhObj.name); // undefined
