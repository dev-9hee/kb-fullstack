// 모듈 내보내기
const hello = (name) => console.log(`${name}님, 안녕하세요?`);

module.exports = hello; // hello 함수 내보내기

// 또 다른 방법
exports.hello = (name) => console.log(`${name}님, 안녕하세요?`);
