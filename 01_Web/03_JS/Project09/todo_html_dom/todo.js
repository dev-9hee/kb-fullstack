const taskInput = document.querySelector('#task');
const taskBtn = document.querySelector('#task-btn');
const todoList = document.querySelector('#todo-list');

taskBtn.addEventListener('click', () => {
  const todo = document.createElement('li');

  taskInput.setAttribute('placeholder', '');

  if (taskInput.value !== '') {
    return taskInput.setAttribute('placeholder', '할 일을 입력하세요!');
  }

  const checkBtn = document.createElement('input');
  checkBtn.setAttribute('type', 'checkbox');

  checkBtn.addEventListener('click', function () {
    if (checkBtn.checked === true) {
      checkBtn.parentNode.style.textDecoration = 'line-through';
    } else {
      checkBtn.parentNode.style.textDecoration = 'none';
    }
  });

  const deleteBtn = document.createElement('input');

  deleteBtn.setAttribute('type', 'button');
  deleteBtn.setAttribute('value', '삭제');
  deleteBtn.setAttribute('onclick', 'deleteTask(this);');

  todo.append(checkBtn);
  todo.append(taskInput.value);
  todo.append(deleteBtn);

  todoList.appendChild(todo);

  taskInput.value = '';
});

function deleteTask(t) {
  t.parentNode.remove();
}
