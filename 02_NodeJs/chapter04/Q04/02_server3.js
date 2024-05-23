// Node 내장 모듈인 http 모듈 불러오기
const http = require('http');

// http 모듈로 서버 만들기
const server = http.createServer((req, res) => {
  // 요청(request)의 메소드를 출력
  console.log(req.method);

  res.setHeader('Content-Type', 'text/pain'); // 응답 헤더 설정
  res.write('Hello Node'); // 응답 본문 작성
  res.end(); // 응답 종료
});

// 서버 실행
server.listen(3000, () => {
  console.log('3000번포트에서서버실행중');
});
