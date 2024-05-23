fs = require('fs');
if (fs.existsSync('./test2/test3/test4')) {
  // 디렉터리가있다면
  console.log('폴더가 존재합니다!');
} else {
  // 디렉터리가없다면
  fs.mkdir('./test2/test3/test4', { recursive: true }, (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('폴더 생성!');
  });
}
