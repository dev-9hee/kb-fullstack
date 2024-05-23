fs = require('fs');
if (fs.existsSync('./test')) {
  // 디렉터리가있다면
  console.log('폴더가 존재합니다!');
} else {
  // 디렉터리가없다면
  fs.mkdir('./test', (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('폴더 생성!');
  });
}
