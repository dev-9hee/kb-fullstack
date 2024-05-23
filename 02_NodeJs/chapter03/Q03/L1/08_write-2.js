fs = require('fs');
const data = fs.readFileSync('./example.txt', 'utf8');
if (fs.existsSync('text-1.txt')) {
  // text-1.txt 파일이있다면
  console.log('파일이 존재합니다!');
} else {
  // text-1.txt파일이없다면
  fs.writeFileSync('./text-1.txt', data);
}
