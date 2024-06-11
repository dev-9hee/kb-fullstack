<template>
  <div>
    <h1>총 금액 출력</h1>
    <div>
      <img
        src="https://img.freepik.com/premium-vector/homeless-people-concept-poor-bum-male-character-dirty-ragged-clothes-sleeping-bench-covered-with-newspaper-city-park-drunk-man-pauper-live-street-outdoors-cartoon-vector-illustration_87771-14706.jpg"
        alt="그림? 넣기"
      />
    </div>
    <h1>{{ totalMoney }}</h1>
    <div>들어온돈 : {{ totalAmountPlus }}</div>
    <div>나간 돈 : {{ totalAmountMinus }}</div>
  </div>
</template>

<script setup>
import { useMoneyManageStore } from '@/stores/counter';
import { ref, onMounted } from 'vue';

const totalAmountPlus = ref(0);
const totalAmountMinus = ref(0);
const totalMoney = ref(0);
const totalManage = useMoneyManageStore();

const calculateTotals = () => {
  totalAmountPlus.value = 0;
  totalAmountMinus.value = 0;

  states.manageList.forEach((item) => {
    if (item.amount > 0) {
      totalAmountPlus.value += item.amount;
      totalMoney.value += item.amount;
    } else if (item.amount < 0) {
      totalAmountMinus.value += item.amount;
      totalMoney.value += item.amount;
    }
  });
};

// ??
onMounted(async () => {
  await fetchMoneyManageList();
  calculateTotals();
});

const { states, fetchMoneyManageList } = totalManage;
</script>
