<template>
  <div>
    <input type="text" v-model.number="inputNum" />
    <button @click="sendResult">정답!!</button>
  </div>
</template>

<script setup>
import { ref, defineEmits, defineProps } from 'vue';

const inputNum = ref(0);

// props 받기
const props = defineProps({
  randNum: {
    type: Number,
    required: true,
  },
});

const emit = defineEmits(['send-result']);

function sendResult() {
  let msg = '';
  if (props.randNum === inputNum.value) {
    msg = '정답입니다';
  } else if (props.randNum > inputNum.value) {
    msg = 'DOWN';
  } else {
    msg = 'UP';
  }
  emit('send-result', msg);
}

// const checkResult = () => {
//   if (props.randNum === inputNum.value) return '정답입니다!';
//   if (props.randNum > inputNum.value) {
//     return 'UP';
//   } else {
//     return 'DOWN';
//   }
// };

// const emit = defineEmits(['send-result']);

// const sendResult = () => {
//   emit('send-result', checkResult());
// };
</script>
