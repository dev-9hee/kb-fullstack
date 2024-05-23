const likePizza = true;
const pizza = new Promise((resolve, reject) => {
  if (likePizza) {
    resolve('피자를 주문 합니다!');
  } else {
    reject('피자를 주문 하지 않습니다');
  }
});

pizza.then((result) => console.log(result)).catch((err) => console.log(err));
