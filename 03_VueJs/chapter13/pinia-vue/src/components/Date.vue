<template>
  <div>
    <h1>Date</h1>
    <h1>{{ dateMsg }}</h1>
    <!-- <h1>오늘은 {{ dateMsg }} 입니다!!</h1> -->
    <button @click="getYear">년도 출력</button>
    <button @click="getMonth">월 출력</button>
    <button @click="getDate">일자 출력</button>
  </div>
</template>

<script setup>
import { computed } from 'vue';
import { useDateStore } from '@/stores/date';

const dateStore = useDateStore();
// 구조분해 할당
const { getYear, getMonth, getDate } = dateStore;

// 원시형 데이터는 computed 속성으로
const dateMsg = computed(() => dateStore.dateMsg);
</script>
