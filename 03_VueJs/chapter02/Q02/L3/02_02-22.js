const promise = new Promise((resolve, reject) => {
  resolve('first!');
});

promise
  .then((msg) => {
    console.log(msg);
    return 'second';
  })
  .then((msg) => {
    console.log(msg);
    return 'third';
  })
  .then((msg) => {
    console.log(msg);
  })
  .catch((error) => {
    console.log('오류 발생 ==>  ' + error);
  });
