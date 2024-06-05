<template>
  <div>
    <h1>Counter</h1>
    <h1>count : {{ count }}</h1>
    <h1>count x 2 : {{ doubleCount }}</h1>
    <button @click="increment">+1</button>
  </div>
</template>

<script setup>
import { computed } from 'vue'; // 구조분해 할당으로 받아옴
import { useCounterStore } from '@/stores/counter';

const counterStore = useCounterStore(); // 가져와서 변수에 담음
const { increment } = counterStore;

// 원시형 데이터 타입은 이렇게!!
const count = computed(() => counterStore.count);
const doubleCount = computed(() => counterStore.doubleCount);
</script>
