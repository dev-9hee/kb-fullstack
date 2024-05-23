// Node 내장 모듈인 http 모듈 불러오기
const http = require('http');
// Node 내장 모듈인 file-system 불러오기
const fs = require('fs').promises;

// 서버에 요청이 들어온 경우 콜백으로 실행되는 익명 함수에 async 를 붙여서, 해당 콜백 내부에서 await 를 쓸 수 있도록 설정
const server = http.createServer(async (req, res) => {
  res.setHeader('Content-Type', 'text/html'); // 응답 헤더 설정, html 파일을 보낼 것이므로 text/html 로 전달

  // file-system 을 통해 같은 폴어데 있는 01_index.html 파일을 읽어서 변수에 담기
  const html = await fs.readFile(__dirname + '/index.html', 'utf8');

  // 요청에 대한 응답으로 읽어드린 html 파일을 클라이언트에 전송
  res.write(html);
  // 응답을 종료
  res.end();
});

// 서버 실행
server.listen(3000, () => {
  console.log('3000번포트에서서버실행중');
});
