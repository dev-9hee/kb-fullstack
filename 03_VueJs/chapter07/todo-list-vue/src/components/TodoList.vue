<template>
  <ul>
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

<style lang="scss" scoped></style>
