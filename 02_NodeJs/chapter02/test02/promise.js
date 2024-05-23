const promise = new Promise((resolve, reject) => {
  console.log('프로미스 시작!');
  setTimeout(() => {
    console.log('setTimeout 끝!');
    resolve('프로미스로 비동기 구현 성공!');
  }, 2000);
});

console.log(promise);

promise.then(function (data) {
  console.log(data);
});

// async function asyncFunc() {
//   const data = await promise;
//   console.log(data);
// }

// asyncFunc();
