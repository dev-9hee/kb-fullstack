// obj라는 이름의 객체를 생성하고, 그 객체에 result 속성을 추가하여 초기값을 0으로 설정
let obj = { result: 0 };

// obj.add = function (x, y) {
//   function inner() {
//     this.result = x + y;
//   }
//   inner();
// };

// obj 객체에 add라는 메서드를 추가, add 메서드는 함수 타입의 값을 가지고 있음
obj.add = function (x, y) {
  const inner = () => {
    // 이 부분에서 this는 화살표 함수의 특성상 상위 스코프의 this를 가리킴
    // 상위 스코프는 add 메서드이므로, this는 obj 객체를 가리킴
    this.result = x + y;
  };
  inner();
};

obj.add(3, 4);

console.log(obj); // { result: 0 }
// console.log(global.result);
