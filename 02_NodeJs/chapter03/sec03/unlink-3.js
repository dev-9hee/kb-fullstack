const fs = require('fs');

if (!fs.existsSync('./text-2.txt')) {
  console.log('file does not exist'); // 파일이 없다면
} else {
  fs.unlinkSync('./text-2.txt', (err) => {
    // 파일이 있다면
    if (err) {
      return console.error(err);
    }
    console.log('file deleted');
  });
}
