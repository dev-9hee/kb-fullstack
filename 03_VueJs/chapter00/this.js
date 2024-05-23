// / 실습 1
// const tezObj = {
//   name: '이효석',
//   isOld: true,
//   sayHello: function () {
//     console.log(this.name);
//   },
//   nestedObj: {
//     name: '변우석',
//     sayHello: function () {
//       console.log(this.name);
//     },
//   },
// };

// // 실습 2
// const obj = {
//     name: '이효석',
//     isOld: true,
//   };

//   function getKKeyValue(obj, key) {
//     if (key in obj) {
//       console.log(obj[key]);
//     }
//   }

//   getKKeyValue(obj, 'name');

const obj = {
  name: '이효석',
  isOld: true,
  condition: 'good',
};

for (let key in obj) {
  console.log(`key 값은 ${key} 이고, value ${obj[key]} 입니다`);
}
