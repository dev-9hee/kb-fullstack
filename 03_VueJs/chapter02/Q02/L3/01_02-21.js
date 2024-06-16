// Promise를 사용하여 비동기 작업을 처리
// Promise 객체를 생성, Promise 생성자 함수에는 resolve와 reject 콜백 함수가 전달
const promise = new Promise((resolve, reject) => {
  // 2초 후에 실행되는 비동기 작업을 수행
  setTimeout(() => {
    let num = Math.random();
    //0~1사이의 난수 발생
    // 생성된 난수가 0.8 이상이면 reject 함수를 호출하여 Promise를 실패 상태로 만듦
    if (num >= 0.8) {
      reject('생성된 숫자가 0.8이상임- ' + num);
    }
    // 생성된 난수가 0.8 미만이면 resolve 함수를 호출하여 Promise를 성공 상태로 만듦, 생성된 난수 값 num을 전달
    resolve(num);
  }, 2000);
});

promise
  // Promise 객체의 then 메서드를 호출하여 Promise가 성공적으로 완료되었을 때의 처리 로직을 등록
  .then((result) => {
    console.log('처리 결과 : ', result);
  })
  // Promise가 실패하면 catch 메서드에 등록된 로직이 실행
  .catch((error) => {
    console.log('오류 : ', error);
  });

// Promise 객체 생성 후 바로 이 메시지가 출력
// 비동기 작업이 2초 후에 실행되기 때문에, Promise 객체 생성 시점과 비동기 작업 완료 시점이 다름
console.log('## Promise 객체 생성!');

// ## Promise 객체 생성!
// 처리 결과 :  0.5899489679486913
