<template>
  <div>
    <select v-model="filterDate">
      <option value="" disabled>월 선택</option>
      <option v-for="m in 12" :key="m" :value="m">{{ m }}월</option>
    </select>
    <div>
      <img
        src="https://wikidocs.net/images/page/92114/pie_chart_00.png"
        alt="차트"
      />
    </div>

    <div>수입 : {{ totalIncome }}</div>
    <div>지출 : {{ totalExpense }}</div>
    <div>순이익 : {{ profit }}</div>
  </div>
</template>

<script setup>
import { useMoneyManageStore } from '@/stores/counter';
import { ref, onMounted, computed } from 'vue';

const filterDate = ref('');
const summaryManage = useMoneyManageStore();
onMounted(() => {
  summaryManage.fetchMoneyManageList();
});

const { states, fetchMoneyManageList } = summaryManage;

const filteredList = computed(() => {
  if (!filterDate.value) return states.manageList;
  return states.manageList.filter(
    (item) => item.month === parseInt(filterDate.value)
  );
});

// 수익 계산
const totalIncome = computed(() => {
  return filteredList.value
    .filter((item) => item.amount > 0)
    .reduce((acc, item) => acc + item.amount, 0);
});

// 지출 계산
const totalExpense = computed(() => {
  return filteredList.value
    .filter((item) => item.amount < 0)
    .reduce((acc, item) => acc + item.amount, 0);
});

// 순이익 계산
const profit = computed(() => {
  return totalIncome.value + totalExpense.value; // 지출이 음수이므로 더하면 됨
});
</script>

<style scoped></style>
