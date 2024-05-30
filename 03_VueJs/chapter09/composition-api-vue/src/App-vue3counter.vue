<template>
  <div>
    <h1>Vue3 Counter</h1>
    <p>Count : {{ count }}</p>
    <!-- <p>x = {{ obj.x }} / y = {{ obj.y }}</p> -->
    <p>두배로! {{ double }}</p>
    <p>지금까지 계산한 횟수 : {{ totalClicked }}</p>
    <button @click="increment">Increment</button>
    <button @click="decrement">Decrement</button>
  </div>
</template>

<script setup>
import { ref, reactive, computed } from 'vue'; // reactive : 객체 사용

const count = ref(2); // 초기값 : 0
// const obj = reactive({ x: 0, y: 0, result: 0 });
const double = computed(() => {
  totalClicked.value++;
  return count.value * 2;
});
const totalClicked = ref(0);

function increment() {
  count.value++;
  // totalClicked.value++;
}
function decrement() {
  count.value--;
  // totalClicked.value++;
}
</script>
