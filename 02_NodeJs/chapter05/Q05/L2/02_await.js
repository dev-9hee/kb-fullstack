const fs = require('fs').promises;

async function readDirAsyn() {
  // 에러 발생에 대비한 try / catch 구문 사용
  try {
    // await 를 사용하여 파일을 다 읽을 때 까지 '멈춰!'
    const files = await fs.readdir('./'); // Promise 객체를리턴하는비동기함수

    // 파일 내용 출력
    console.log(files);
  } catch (err) {
    // 에러 발생 시 에러 내용 출력
    console.error(err);
  }
}

// 선언한 async 함수를 사용
readDirAsyn();
