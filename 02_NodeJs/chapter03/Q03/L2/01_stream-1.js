const fs = require('fs');

const rs = fs.createReadStream('./readMe.txt');

rs.on('data', (chunk) => {
  console.log('파일을 읽었습니다. 그 내용은:');
  console.log(chunk.length, chunk);
})
  .on('end', () => {
    console.log('파일 데이터 읽기 완료!');
  })
  .on('error', (err) => {
    console.error(`파일을 읽던 중 에러가 발생, 에러 내용 : ${err}`);
  });
