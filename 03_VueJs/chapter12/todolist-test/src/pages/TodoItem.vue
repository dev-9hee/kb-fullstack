<template>
  <li>
    <span
      :style="
        todoItem.done
          ? { textDecoration: 'line-through' }
          : { textDecoration: 'none' }
      "
      @click="toggleTodo(todoItem.id)"
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
</template>

<script setup>
import { ref } from 'vue';

const todoEdit = ref('');

const props = defineProps({
  todoItem: {
    type: Object,
    required: true,
  },
});

const emit = defineEmits([
  'delete-todo',
  'toggle-todo',
  'edit-todo',
  'confirm-edit-todo',
  'cancel-edit-todo',
]);

function deleteTodo(id) {
  emit('delete-todo', id);
}

function toggleTodo(id) {
  emit('toggle-todo', id);
}

function editTodo(id) {
  todoEdit.value = props.todoItem.todo;
  emit('edit-todo', id);
}

function confirmEditTodo(id, todo) {
  emit('confirm-edit-todo', id, todo);
}

function cancelEditTodo(id) {
  emit('cancel-edit-todo', id);
}
</script>
