<template>
  <ul>
    <!-- "todoItem in todoList"는 todoList 배열의 각 todoItem을 순회하면서 TodoListItem 컴포넌트를 렌더링하겠다는 의미 -->
    <!-- todoItem"은 현재 반복 중인 todoItem 객체를 TodoListItem 컴포넌트의 todoItem prop에 전달하겠다는 의미 -->
    <!-- TodoListItem 컴포넌트에서 발생하는 'toggleCompleted' 이벤트를 상위 컴포넌트로 전달하겠다는 의미 -->
    <!-- $event는 이벤트 객체를 의미하며, 이를 함께 전달 -->
    <TodoListItem
      v-for="todoItem in todoList"
      :todoItem="todoItem"
      :key="todoItem.id"
      @toggleCompleted="$emit('toggleCompleted', $event)"
      @deleteTodo="$emit('deleteTodo', $event)"
    />
  </ul>
</template>

<script>
import TodoListItem from './TodoListItem.vue';

export default {
  name: 'TodoList',
  props: ['todoList'],
  components: { TodoListItem },
};
</script>
