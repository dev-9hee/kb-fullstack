<template>
  <div>
    <h1>{{ msg }}</h1>
    <!-- <h1>{{ resultMsg }}</h1> -->
    <ChildComponent :randNum="randNum" @send-result="changeMsg" />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import ChildComponent from './components/ChildComponent.vue';

// const resultMsg = ref('랜덤 숫자 맞추기 게임🤗');
const msg = ref('랜덤 숫자 맞추기 게임🤗');

const randNum = ref(parseInt(Math.random() * 20));

function changeMsg(payload) {
  msg.value = payload;
}

// const changeMsg = (value) => {
//   resultMsg.value = value;
// };
</script>
