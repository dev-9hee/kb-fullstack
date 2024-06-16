<!-- TodoList 뼈대 만들기 -->
<template>
  <div>
    <h1>Todo List</h1>
    <!-- Todo 입력 파트 -->
    <div>
      <!-- todo 데이터에 todo 입력 값 받기 -->
      <input type="text" v-model.trim="todo" />
      <!-- todo 추가를 수행하는 비동기 함수 addTodo 바인딩 -->
      <button @click="addTodo">추가</button>
    </div>
    <br />
    <!-- 투두 리스트 -->
    <ol>
      <!-- v-for로 TodoList 그리기 -->
      <!-- :key="todoItem.id => 꼭 적어주는게 좋음, key 값을 안 주면 렌더링이 많이 일어남 -->
      <li v-for="todoItem in states.todoList" :key="todoItem.id">
        <!-- 투두 항목 -->
        <!-- span 태그에 toggleTodo 함수를 걸어서 해당 todo의 done을 토글하는 기능 추가 -->
        <span
          :style="
            todoItem.done
              ? { textDecoration: 'line-through' }
              : { textDecoration: 'none' }
          "
          @click.stop="toggleTodo(todoItem.id)"
        >
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        <!-- 수정모드 -->
        <div v-if="todoItem.editing">
          <input type="text" v-model.trim="todoEdit" />
          <button @click.stop="confirmEditTodo(todoItem.id)">확인</button>
          <button @click.stop="cancelEditTodo(todoItem.id)">취소</button>
        </div>
        &nbsp;
        <!-- 수정 및 삭제 버튼 -->
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
import axios from 'axios'; // Axios는 HTTP 클라이언트 라이브러리, 비동기 방식으로 서버와 통신할 수 있게 해줌
import { reactive, ref } from 'vue'; // reactive는 객체를 반응형, reactive는 객체를 반응형으로 만들어줌

// todoList는 중요한 데이터(=상태)이므로 states라는 객체로 관리
const states = reactive({
  // states는 반응형 객체를 참조하는 변수, states.todoList의 값이 변경되면 관련된 UI 부분이 자동으로 업데이트
  todoList: [],
});

const todo = ref(''); // 초기값 빈 문자열
const todoEdit = ref('');

// Todo 컴포넌트는 todos로만 요청을 보낼 것이므로 BASEURL로 설정
const BASEURL = '/api/todos';

// todoList를 json-server에서 받아오는 비동기 통신 함수인 fetchTodoList 선언
// todoList 데이터를 가져오는 역할
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

// 추가
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

// 삭제
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

// 완료
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
