// 가변 파라미터 사용
function foodReport(name, age, ...favoriteFoods) {
  console.log(`${name}, ${age}`);
  console.log(favoriteFoods);
}

foodReport('이몽룡', 20, '짜장면', '냉면', '불고기'); // name은 '이몽룡', age는 20, 그리고 favoriteFoods에는 '짜장면', '냉면', '불고기'가 배열 형태로 전달
foodReport('홍길동', 16, '초밥'); // name은 '홍길동', age는 16, 그리고 favoriteFoods에는 '초밥'이 배열 형태로 전달

// 출력
// 이몽룡, 20
// [ '짜장면', '냉면', '불고기' ]
// 홍길동, 16
// [ '초밥' ]

// [ '짜장면', '냉면', '불고기' ] : 배열 리터럴 표기법에 따른 것, 배열 내부에 문자열 값이 포함되어 있을 때, 해당 문자열은 '(작은따옴표) 또는 "(큰따옴표)로 감싸짐
// 이몽룡, 20 : console.log() 함수는 변수나 값을 출력할 때, 해당 값의 타입에 따라 자동으로 적절한 형식으로 출력
