const order = (menu, callback) => {
  console.log(`${menu} 주문 접수`);
  setTimeout(() => {
    callback(menu);
  }, 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};

order('아메리카노', display);
