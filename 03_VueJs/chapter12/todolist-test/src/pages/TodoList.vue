<template>
  <div>
    <h1>Todo List</h1>
    <TodoItem
      v-for="todoItem in todoList"
      :key="todoItem.id"
      :todoItem="todoItem"
      @delete-todo="deleteTodo"
      @toggle-todo="toggleTodo"
      @edit-todo="editTodo"
      @confirm-edit-todo="confirmEditTodo"
      @cancel-edit-todo="cancelEditTodo"
    />
    <div>
      <input type="text" v-model.trim="todo" />
      <button @click="addTodo">추가</button>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'; // Axios는 HTTP 클라이언트 라이브러리, 비동기 방식으로 서버와 통신할 수 있게 해줌
import { reactive, ref } from 'vue'; // reactive는 객체를 반응형, reactive는 객체를 반응형으로 만들어줌
import TodoItem from './TodoItem.vue';

// todoList는 중요한 데이터(=상태)이므로 states라는 객체로 관리
const states = reactive({
  // states는 반응형 객체를 참조하는 변수, states.todoList의 값이 변경되면 관련된 UI 부분이 자동으로 업데이트
  todoList: [],
});
const todo = ref('');

const BASEURL = '/api/todos';

// 할일 목록 가져오기 로직
async function fetchTodoList() {
  try {
    const getTodoRes = await axios.get(BASEURL); // 데이터 요청이므로 GET 방식으로 todoList 요청

    states.todoList = getTodoRes.data; // 받아온 데이터를 states에서 관리중인 todoList에 업데이트 -> 컴포넌트가 리렌더링
    // states는 앞서 정의한 반응형 객체이므로, todoList 속성이 변경되면 관련된 UI가 자동으로 업데이트
    console.log(states.todoList);
  } catch (error) {
    alert('TodoList 데이터 통신 ERR 발생');
    console.log(error);
  }
}

// 할 일 추가 로직
async function addTodo() {
  // input에 입력 값이 없을 경우 입력이 필요하다는 메시지를 띄우고 할 일 추가 함수 종료
  if (todo.value === '') return alert('할 일을 입력해 주세요!');

  // 새로운 할 일 todo는 input으로부터 받은 todo.value를 넣고 완료 여부는 false로 추가
  try {
    const newTodo = { todo: todo.value, done: false };
    const addTodoRes = await axios.post(BASEURL, newTodo); // Axios의 post 메서드를 사용하여 서버에 데이터를 보냄

    // 할 일 추가가 성공하면 201번 응답이 발생하므로 해당 응답이 아니라면 추가 실패 메시지를 띄우고 종료
    if (addTodoRes.status !== 201) return alert('Todo 추가 실패');

    todo.value = ''; // 인풋 값 초기화
    fetchTodoList(); // 인풋의 입력 값을 초기화 한 뒤 fetchTodoList를 실행해서 서버에 데이터를 다시 받아오기 -> 추가된 데이터까지 받아옴
  } catch (error) {
    alert('todolist 추가 작업 중, ERR 빌셍');
    console.log(error);
  }
}

// 할 일 삭제 로직
async function deleteTodo(id) {
  try {
    const delTodoRes = await axios.delete(`${BASEURL}/${id}`); // Axios를 사용하여 서버에서 특정 Todo 항목을 삭제하는 비동기 요청
    // const delTodoRes = await axios.delete(BASEURL + `/${id}`);
    // const delTodoRes = await axios.delete(`/api/todos/${id}`);

    if (delTodoRes.status !== 200) return alert('Todo 삭제 실패');

    fetchTodoList();
  } catch (error) {
    alert('Todolist 삭제 작업 중, ERR 발생');
    console.log(error);
  }
}

// 할 일 완료 토글 로직
async function toggleTodo(id) {
  try {
    // states.todoList는 Todo 항목들의 배열을 나타냄, find() 메서드는 배열에서 조건에 맞는 첫 번째 요소를 반환
    const targetTodo = states.todoList.find((todo) => todo.id === id); // todoList 항목 중에서 id값이 같은 todo 항목 찾기
    // todoItem 의 값 중에서 done 부분만 기존의 done의 부정 값으로 변경
    const payload = { ...targetTodo, done: !targetTodo.done }; //  기존 targetTodo 객체를 복사하고, done 속성의 값을 반대로 변경하는 것
    // 변경한 todo 를 json-server 에 수정 요청, 어떤 todo 를 수정할 지는 id 를 전달
    const toggleTodoRes = await axios.put(BASEURL + `/${id}`, payload); // Axios의 put 메서드를 사용하여 서버에 데이터 업데이트 요청
    // 성공하면 200번 응답이 발생하므로 200번이 아닌 경우 변경 실패 메시지와 함께 종료
    if (toggleTodoRes.status !== 200) return alert('Todo toggle 실패');
    fetchTodoList(); // 서버에 수정된 데이터를 다시 받아서 화면에 출력!
  } catch (error) {
    alert('TodoList 토글 작업 중, ERR 발생');
    console.log(error);
  }
}

// 중요순위 낮음
// 데이터 수정이 안 일어나기 때문에 async 사용할 필요 없음
// 할 일 수정모드 전환 로직
function editTodo(id) {
  const targetTodo = states.todoList.find((todo) => todo.id === id);
  targetTodo.editing = true;
}

// 할 일 수정 취소 로직
function cancelEditTodo(id) {
  const targetTodo = states.todoList.find((todo) => todo.id === id);
  targetTodo.editing = false;
}

// 할 일 수정 확인 로직
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

fetchTodoList(); // 목록 얻기, 새로고침 눌렀을 때도 이걸 이용해서 목록 update
</script>
