const p1 = { name: 'john', age: 20 };
p1.age = 22;
console.log(p1); // {name: 'john', age: 22}

// const(상수)로 설정돼있음, p1이 참조하는 메모리 주소가 바뀌는 것이므로 허용 안 함, 오류
p1 = { name: 'lee', age: 25 };
