let p1 = {
  name: '아이패드',
  price: 200000,
  quantity: 2,
  // 기존 방법
  order: function () {
    // this.amount가 존재하지 않거나 falsy한 값(0, null, undefined, false, NaN, '')인 경우 실행
    // if문은 원래 true면 실행, ! 붙어서 false일 경우 실행
    if (!this.amount) {
      this.amount = this.quantity * this.price;
    }
    console.log('주문금액 : ' + this.amount);
  },
  // ES6의 메서드 선언
  discount(rate) {
    if (rate > 0 && rate < 0.8) {
      this.amount = (1 - rate) * this.price * this.quantity;
    }
    console.log(100 * rate + '% 할인된 금액으로 구매합니다.');
  },
};
p1.discount(0.2); // 20% 할인된 금액으로 구매합니다.
p1.order(); // 주문금액 : 320000
