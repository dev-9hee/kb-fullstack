<template>
  <div>
    <h1>Todo List</h1>
    <!-- 입력 파트 -->
    <div>
      <input type="text" v-model.trim="todo" />
      <button @click="addTodo">추가</button>
    </div>
    <br />
    <!-- 리스트 파트 -->
    <ol>
      <!-- 투두 항목 -->
      <!-- :key="todoItem.id => 꼭 적어주는게 좋음, key 값을 안 주면 렌더링이 많이 일어남 -->
      <li v-for="todoItem in states.todoList" :key="todoItem.id">
        <span
          v-bind:style="
            todoItem.done
              ? { textDecoration: 'line-through' }
              : { textDecoration: 'none' }
          "
          @click="toggleTodo(todoItem.id)"
          >{{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}</span
        >
        <!-- 수정모드 -->
        <div v-if="todoItem.editing">
          <input type="text" v-model.trim="todoEdit" />
          <button @click.stop="confirmEditTodo(todoItem.id)">확인</button>
          <button @click.stop="cancelEditTodo(todoItem.id)">취소</button>
        </div>
        &nbsp;
        <span v-if="!todoItem.editing">
          <!-- 버블링을 막기 위해서 stop 붙여줌 -->
          <button @click.stop="editTodo(todoItem.id)">수정</button>
          /
          <button @click.stop="deleteTodo(todoItem.id)">삭제</button>
        </span>
      </li>
    </ol>
  </div>
</template>

<script setup>
import axios from 'axios';

import { ref, reactive } from 'vue';

const states = reactive({
  todoList: [],
});

const todo = ref('');
const todoEdit = ref('');

// BASEURL : 모두 다 대문자로 작성, 바뀌지 않는 값이라고 생각
// localhost:3000
const BASEURL = '/api/todos';

async function fetchTodoList() {
  try {
    const fetchTodoRes = await axios.get(BASEURL);

    states.todoList = fetchTodoRes.data;
    console.log(states.todoList);
  } catch (error) {
    alert('TodoList 데이터 통신 Err 발생');
    console.log(error);
  }
}

async function addTodo() {
  if (todo.value === '') return alert('할 일을 입력해 주세요!');

  try {
    const newTodo = { todo: todo.value, done: false };
    const addTodoRes = await axios.post(BASEURL, newTodo);

    if (addTodoRes.status !== 201) return alert('Todo 추가 실패');

    todo.value = '';
    fetchTodoList();
  } catch (error) {
    alert('todolist 추가 작업 중, ERR 빌셍');
    console.log(error);
  }
}

async function deleteTodo(id) {
  try {
    const delTodoRes = await axios.delete(`${BASEURL}/${id}`);
    // const delTodoRes = await axios.delete(BASEURL + `/${id}`);
    // const delTodoRes = await axios.delete(`/api/todos/${id}`);

    if (delTodoRes.status !== 200) return alert('Todo 삭제 실패');

    fetchTodoList();
  } catch (error) {
    alert('Todolist 삭제 작업 중, ERR 발생');
    console.log(error);
  }
}

async function toggleTodo(id) {
  try {
    const targetTodo = states.todoList.find((todo) => todo.id === id);
    const payload = { ...targetTodo, done: !targetTodo.done };

    const toggleTodoRes = await axios.put(BASEURL + `/${id}`, payload);

    if (toggleTodoRes.status !== 200) return alert('Todo toggle 실패');
    fetchTodoList();
  } catch (error) {
    alert('TodoList 토글 작업 중, ERR 발생');
    console.log(error);
  }
}

// 데이터 수정이 안 일어나기 때문에 async 사용할 필요 없음
function editTodo(id) {
  const targetTodo = states.todoList.find((todo) => todo.id === id);
  targetTodo.editing = true;
}

function cancelEditTodo(id) {
  const targetTodo = states.todoList.find((todo) => todo.id === id);
  targetTodo.editing = false;
}

async function confirmEditTodo(id) {
  if (todoEdit.value === '') return alert('수정 내용을 입력하세요!');
  try {
    const targetTodo = states.todoList.find((todo) => todo.id === id);
    const payload = { ...targetTodo, todo: todoEdit.value, editing: false };

    // put : 수정 => payload : 대체될 데이터
    const editTodoRes = await axios.put(BASEURL + `/${id}`, payload);

    if (editTodoRes.status !== 200) return alert('Todo edit 실패');
    todoEdit.value = '';
    fetchTodoList();
  } catch (error) {
    alert('TodoList 수정 작업 중, ERR 발생');
    console.log(error);
  }
}
fetchTodoList();
</script>
