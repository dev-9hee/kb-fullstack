<script setup>
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';
</script>

<template>
  <div style="display: flex; flex-direction: column; align-items: center">
    <h1>JH TodoList</h1>
    <InputTodo @addTodo="addTodo" />
    <!-- todoList라는 props명으로 -->
    <TodoList
      :todoList="todoList"
      @toggleCompleted="toggleCompleted"
      @deleteTodo="deleteTodo"
    />
  </div>
</template>

<script>
export default {
  components: { InputTodo, TodoList },
  data() {
    return {
      todoList: [
        // 객체로 넣음
        { id: 1, todo: 'TodoList 만들기', completed: false },
        { id: 2, todo: '운동 가기', completed: true },
        { id: 3, todo: '코테 풀기', completed: false },
        { id: 4, todo: '복습 하기', completed: false },
      ],
    };
  },
  methods: {
    addTodo(todo) {
      // 할 일 추가
      this.todoList.push({
        id: this.todoList.length + 1,
        todo: todo.todo,
        completed: false,
      });
    },
    toggleCompleted(id) {
      const index = this.todoList.findIndex(function (item) {
        return id === item.id;
      });
      this.todoList[index].completed = !this.todoList[index].completed;
    },
    deleteTodo(id) {
      const index = this.todoList.findIndex((item) => id === item.id);
      this.todoList.splice(index, 1); // 배열함수 / 시작점, 몇개 지울지
    },
  },
};
</script>

<style scoped></style>
