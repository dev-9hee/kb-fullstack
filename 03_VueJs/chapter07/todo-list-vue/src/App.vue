<template>
  <div style="display: flex; flex-direction: column; align-items: center">
    <h1>JH TodoList</h1>
    <!-- InputTodo 컴포넌트에서 'addTodo' 이벤트가 발생하면, 상위 컴포넌트의 addTodo 메서드를 호출하는 역할 -->
    <InputTodo @addTodo="addTodo" />
    <!-- 할 일 목록을 표시하고, 할 일의 완료 상태를 변경하거나 삭제할 수 있는 기능을 제공 -->
    <!-- todoList라는 props명으로 -->
    <!-- 현재 컴포넌트의 todoList 데이터 속성을 TodoList 컴포넌트의 todoList prop에 전달 -->
    <TodoList
      :todoList="todoList"
      @toggleCompleted="toggleCompleted"
      @deleteTodo="deleteTodo"
    />
  </div>
</template>

<script>
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';

export default {
  name: 'App',
  components: { InputTodo, TodoList },
  data() {
    return {
      todoList: [
        // 배열 안에 객체로 넣음
        { id: 1, todo: 'TodoList 만들기', completed: false },
        { id: 2, todo: '운동 가기', completed: true },
        { id: 3, todo: '코테 풀기', completed: false },
        { id: 4, todo: '복습 하기', completed: false },
      ],
    };
  },
  methods: {
    // todo는 이전에 발생한 'addTodo' 이벤트에서 전달된 데이터
    addTodo(todo) {
      // 할 일 추가, push() 메서드를 사용하여 todoList 배열에 새로운 todo 객체를 추가
      this.todoList.push({
        id: this.todoList.length + 1,
        // 새로운 todo 객체의 todo 속성을 설정, 이전에 전달받은 todo 인자의 todo 속성 값
        todo: todo.todo,
        completed: false,
      });
    },
    toggleCompleted(id) {
      // this.todoList 배열의 각 요소를 의미
      // id 변수와 item.id 속성이 같은지를 확인하고, 그 결과를 반환
      const index = this.todoList.findIndex(function (item) {
        return id === item.id;
      });
      this.todoList[index].completed = !this.todoList[index].completed;
    },
    deleteTodo(id) {
      // 콜백 함수로, 각 item의 id 속성이 외부에서 전달받은 id 변수와 같은지 확인
      const index = this.todoList.findIndex((item) => id === item.id);
      this.todoList.splice(index, 1); // 배열함수 / 시작점, 몇개 지울지
    },
  },
};
</script>
