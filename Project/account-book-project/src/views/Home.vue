<template>
  <div class="subcontainer">
    <div class="homeContainer">
      <div class="homeContent">
        <div class="contentItem">
          이번 달 저금액이 쌓이면
          <br />
          puppy에게 {{ itemMessage }}을 선물 할 수 있어요
        </div>
        <div class="contentItem">
          <ImageComponent :totalMoney="totalMoney" />
        </div>
        <div class="contentItem">지난 1개월간의 거래내역을 확인해보세요</div>
        <h1 class="contentItem">{{ formatAmount(totalMoney) }}</h1>
        <div class="amountBoxContainer">
          <div class="amountBox" :class="{ greenText: totalAmountPlus > 0 }">
            <!-- <div style="color: black">들어온돈</div> -->
            <img class="icon-plus" src="../icons/plus.png" alt="Plus" />
            <br />
            <span>{{ formatAmount(totalAmountPlus) }}</span>
          </div>
          <div class="amountBox" :class="{ redText: totalAmountMinus < 0 }">
            <!-- <div style="color: black">나간 돈</div> -->
            <img class="icon-minus" src="../icons/minus.png" alt="Minus" />
            <br />
            <span>{{ formatAmount(totalAmountMinus) }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useMoneyManageStore } from '@/stores/counter';
import { ref, computed, onMounted } from 'vue';
import ImageComponent from '@/views/ImageComponent.vue';
import '@/asset/homepage.css';

const totalAmountPlus = ref(0);
const totalAmountMinus = ref(0);
const totalMoney = ref(0);
const totalManage = useMoneyManageStore();
const { states, fetchMoneyManageList } = totalManage;

// 콤마(,) 추가
function formatAmount(amount) {
  // 금액이 정수인 경우 소수점 이하 표시 생략
  if (amount % 1 === 0) {
    return amount >= 0
      ? '+' + amount.toFixed(0).replace(/\B(?=(\d{3})+(?!\d))/g, ',')
      : amount.toFixed(0).replace(/\B(?=(\d{3})+(?!\d))/g, ',');
  } else {
    return amount >= 0
      ? '+' + amount.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ',')
      : amount.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ',');
  }
}

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

const itemMessage = computed(() => {
  if (totalMoney.value > 5000000) {
    return '집'; // 500만원 이상
  } else if (totalMoney.value > 1500000) {
    return '옷'; // 150만원 초과 500만원 이하
  } else {
    return '아이템'; // 150만원 이하
  }
});
//
onMounted(async () => {
  await fetchMoneyManageList();
  calculateTotals();
});
</script>
