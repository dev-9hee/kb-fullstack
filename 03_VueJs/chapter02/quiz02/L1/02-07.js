// 배열의 구조 분해
let arr = [10, 20, 30, 40];

const [a1, a2, a3] = arr;

console.log(a1, a2, a3);

// 객체 리터럴 표기법을 사용하여 객체를 생성하고, 속성과 값을 정의하는 방식
// p1은 객체이고, name, age, gender는 객체의 속성(property)이며, '홍길동', 20, 'M'은 각각 해당 속성의 값
let p1 = { name: '홍길동', age: 20, gender: 'M' };

const { name: n, age: a, gender: gender } = p1;

console.log(n, a, gender);

// 10 20 30
// 홍길동 20 M
