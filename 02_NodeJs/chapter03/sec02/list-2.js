const fs = require('fs');

// 현재 디렉터리 읽기, 비동기 처리로 디렉터리 읽기
fs.readdir('./', (err, files) => {
  if (err) {
    console.log(err);
    return;
  }
  console.log(files);
});
