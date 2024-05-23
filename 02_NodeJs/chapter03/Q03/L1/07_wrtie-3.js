fs = require('fs');
fs.readFile('./example.txt', 'utf8', (err, data) => {
  if (err) {
    console.log(err);
  }
  fs.writeFile('./text-2.txt', data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log('text-2.txt is saved!');
  });
});
