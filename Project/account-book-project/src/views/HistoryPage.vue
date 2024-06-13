<template>
  <div class="subcontainer">
    <div class="filter-container">
      <select class="yearselect" v-model="filterYear">
        <option value="" disabled>년도 선택</option>
        <option value="">전체</option>
        <option v-for="year in 4" :key="year" :value="2020 + year">
          {{ 2020 + year }}년
        </option>
      </select>

      <select class="monthselect" v-model="filterDate">
        <option value="" disabled>월 선택</option>
        <option value="">전체</option>
        <option v-for="m in 12" :key="m" :value="m">{{ m }}월</option>
      </select>

      <select class="contentselect" v-model="filterAmountType">
        <option value="all">전체</option>
        <option value="income">수입</option>
        <option value="expense">지출</option>
      </select>

      <select
        class="categoryselect"
        v-if="filterAmountType == 'income'"
        v-model="filterCategory"
      >
        <option value="" disabled>카테고리</option>
        <option value="월급">월급</option>
        <option value="용돈">용돈</option>
        <option value="구걸">구걸</option>
      </select>

      <select
        class="categoryselect"
        v-if="filterAmountType == 'expense'"
        v-model="filterCategory"
      >
        <option value="" disabled>카테고리</option>
        <option value="공과금">공과금</option>
        <option value="병원비">병원비</option>
        <option value="식비">식비</option>
      </select>
    </div>

    <ul class="list">
      <li class="listitem" v-for="item in filteredManageList" :key="item.id">
        <div class="content">
          <div class="left">
            <div class="historydate">{{ item.date }}</div>
            <div class="historycategory">
              [ {{ item.category }} ] : {{ item.memo }}
            </div>
          </div>
          <div
            class="amount-right"
            :class="{ income: item.amount >= 0, expense: item.amount < 0 }"
          >
            {{ formatAmount(item.amount) }}
          </div>
          <!-- 삭제버튼 -->
          <div class="delete-button" @click="deleteItem(item.id)">
            <img class="icon-delete" src="../icons/erase.png" alt="Delete" />
          </div>
        </div>
      </li>
    </ul>

    <button class="add-button" @click="navigateToContent">
      <img class="icon-add" src="../icons/add.png" alt="Add" />
      <div class="add-text">거래 내역 추가</div>
    </button>
  </div>
</template>

<script setup>
import { useMoneyManageStore } from '@/stores/counter';
import { ref, onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import '@/asset/historypage.css';

const router = useRouter();

function navigateToContent() {
  router.push('/add');
}

const filterList = useMoneyManageStore();
onMounted(() => {
  filterList.fetchMoneyManageList();
});

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

const deleteItem = async (id) => {
  try {
    const moneyManageStore = useMoneyManageStore();
    await moneyManageStore.deleteMoneyManageItem(id);
  } catch (e) {
    alert('삭제 작업 중 오류 발생');
    console.log(e);
  }
};

const { states, fetchMoneyManageList } = filterList;

const filterCategory = ref('');
const filterDate = ref('');
const filterYear = ref('');
const filterAmountType = ref('all');

// 필터 매서드 ??
const filteredManageList = computed(() => {
  return filterList.states.manageList.filter((item) => {
    const matchesYear =
      filterYear.value === '' || item.year === parseInt(filterYear.value);
    const matchesCategory =
      filterCategory.value === '' || item.category === filterCategory.value;
    const matchesMonth =
      filterDate.value === '' || item.month === parseInt(filterDate.value);
    const matchesAmountType =
      filterAmountType.value === 'all' ||
      (filterAmountType.value === 'income' && item.amount >= 0) ||
      (filterAmountType.value === 'expense' && item.amount < 0);

    return matchesYear && matchesCategory && matchesMonth && matchesAmountType;
  });
});
</script>
