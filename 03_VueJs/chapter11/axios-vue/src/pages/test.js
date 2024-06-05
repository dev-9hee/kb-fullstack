const todo = {
  id: '1',
  todo: '오브젝트 이해하기',
  done: false,
};

// 얕은 복사 : const copyTodo = todo;
// 깊은 복사
const copyTodo = {
  id: todo.id,
  todo: todo.todo,
  done: true,
};

// 비교연산자에 넣었을 때 false 나오면 깊은 복사
console.log(todo === copyTodo);
console.log(copyTodo);
