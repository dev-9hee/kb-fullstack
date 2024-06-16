<template>
  <li>
    <span
      @click="$emit('toggleCompleted', todoItem.id)"
      :style="
        todoItem.completed
          ? { textDecoration: 'line-through' }
          : { textDecoration: 'none' }
      "
      >{{ todoItem.id }} {{ todoItem.todo }}
      {{ todoItem.completed ? '(완료)' : '' }}</span
    >
    <button @click="$emit('deleteTodo', todoItem.id)">삭제</button>
  </li>
</template>

<script>
export default {
  name: 'TodoListItem',
  props: ['todoItem'],
};
</script>
