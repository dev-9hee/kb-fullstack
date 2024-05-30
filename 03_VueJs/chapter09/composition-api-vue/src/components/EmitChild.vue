<template>
  <div>
    <input type="text" v-model.trim="inputMsg" />
    <button @click="sendMsg">부모님께 전송</button>
  </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue';

const inputMsg = ref('');
const emit = defineEmits(['send-msg']);

function sendMsg() {
  emit('send-msg', inputMsg.value);
  inputMsg.value = '';
}
</script>
