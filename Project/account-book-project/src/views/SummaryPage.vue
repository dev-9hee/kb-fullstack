<template>
  <div class="subcontainer">
    <div id="subtitle">거래 요약</div>
    <hr />
    <div class="summary-filter-container">
      <select v-model="filterYear" class="styled-select">
        <option class="summaryopt" value="" disabled>년도</option>
        <option class="summaryopt" v-for="y in years" :key="y" :value="y">
          {{ y }}년
        </option>
      </select>
      <select v-model="filterDate" class="styled-select">
        <option class="summaryopt" value="" disabled>월</option>
        <option class="summaryopt" v-for="m in 12" :key="m" :value="m">
          {{ m }}월
        </option>
      </select>
    </div>

    <div class="chart-container">
      <ChartComponent
        :totalIncome="totalIncome"
        :totalExpense="totalExpense"
        :profit="profit"
      ></ChartComponent>
    </div>
    <div class="moneyType label">
      수입
      <span class="amount incomeAmount"> {{ formattedTotalIncome }}</span>
    </div>
    <div class="moneyType label">
      지출
      <span class="amount expenseAmount"> {{ formattedTotalExpense }}</span>
    </div>
    <div class="moneyType label">
      순이익 <span class="amount profitAmount"> {{ formattedProfit }}</span>
    </div>
  </div>
</template>

<script setup>
import { useMoneyManageStore } from '@/stores/counter';
import { ref, onMounted, computed } from 'vue';
import ChartComponent from '@/views/ChartComponent.vue';
import '@/asset/summarypage.css';

const filterYear = ref('');
const filterDate = ref('');
const summaryManage = useMoneyManageStore();

onMounted(() => {
  summaryManage.fetchMoneyManageList();
});

const { states, fetchMoneyManageList } = summaryManage;

// 연도 목록 생성 (예: 최근 5년)
const years = Array.from({ length: 5 }, (_, i) => new Date().getFullYear() - i);

const filteredList = computed(() => {
  return states.manageList.filter((item) => {
    const matchesYear = filterYear.value
      ? item.year === parseInt(filterYear.value)
      : true;
    const matchesMonth = filterDate.value
      ? item.month === parseInt(filterDate.value)
      : true;
    return matchesYear && matchesMonth;
  });
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

// 숫자 포맷팅 함수
const formatCurrency = (amount) => {
  const formattedAmount = Math.abs(amount).toLocaleString('ko-KR');
  if (amount > 0) {
    return `+${formattedAmount}`;
  } else if (amount < 0) {
    return `-${formattedAmount}`;
  } else {
    return formattedAmount;
  }
};

// 포맷팅된 금액 반환
const formattedTotalIncome = computed(() => formatCurrency(totalIncome.value));
const formattedTotalExpense = computed(() =>
  formatCurrency(totalExpense.value)
);
const formattedProfit = computed(() => formatCurrency(profit.value));
</script>
