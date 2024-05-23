let obj1 = { name: '박문수', age: 29 };
let obj2 = { ...obj1, email: 'mspark@gmail.com' };

console.log(obj2);

// const copy = {
//   ...obj2,
//   email: 'hello',
// };

// // 값은 복사되지만 같은건 아님
// console.log(obj1 === obj2);
// // 이메일 주소 변경
// console.log(copy);
