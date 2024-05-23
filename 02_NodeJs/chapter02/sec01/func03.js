let getTriangle = (base, height) => (base * height) / 2;
let getCircle = (radius) => radius * radius * Math.PI;

console.log('삼각형의 면적:' + getTriangle(5, 2));
console.log('원의 면적:' + getCircle(5));
