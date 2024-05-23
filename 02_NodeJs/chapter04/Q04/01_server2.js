// Node 내장 모듈인 http 모듈 불러오기
const http = require('http');

// http 모듈로 서버 만들기
const server = http.createServer((req, res) => {
  // 요청(request)이 들어온 정보를 그대로 출력
  console.log(req);
});

// 서버 실행
server.listen(3000, () => {
  console.log('3000번포트에서서버실행중');
});
