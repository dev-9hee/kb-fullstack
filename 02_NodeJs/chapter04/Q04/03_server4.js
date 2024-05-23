// Node 내장 모듈인 http 모듈 불러오기
const http = require('http');

// http 모듈로 서버 만들기
const server = http.createServer((req, res) => {
  res.setHeader('Content-Type', 'text/html'); // 응답 헤더 설정, html 파일을 보낼 것이므로 text/html 로 전달

  // 03_index.html 파일을 읽어들이기
  const readStream = fs.createReadStream(__dirname + '/index.html', 'utf8');

  // 스트림 형태로 클라이언트에 전송
  readStream.pipe(res);
});

// 서버 실행
server.listen(3000, () => {
  console.log('3000번포트에서서버실행중');
});
