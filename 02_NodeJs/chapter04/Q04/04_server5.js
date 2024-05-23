// Node 내장 모듈인 http 모듈 불러오기
const http = require('http');

// http 모듈로 서버 만들기
const server = http.createServer((req, res) => {
  const { method, url } = req; // 요청 메서드와 URL 을 request 로 부터 가져오기

  res.setHeader('Content-Type', 'text/plain'); // 응답 헤더 설정

  // URL과 메서드에 따라 응답을 다르게 처리하는 if 문
  if (method === 'GET' && url === '/home') {
    res.statusCode = 200;
    res.end('HOME');
  } else if (method === 'GET' && url === '/about') {
    res.statusCode = 200;
    res.end('ABOUT');
  } else {
    res.statusCode = 404;
    res.end('NOT FOUND');
  }
});

// 서버 실행
server.listen(3000, () => {
  console.log('3000번포트에서서버실행중');
});
