<template>
  <div>
    <h4 class="calendar-text">이번 달 자산 흐름을 한눈에 확인해보세요</h4>
  </div>
  <div class="calendar-container">
    <div class="calendar-text2">
      수입 :
      <span class="income">{{ totalIncome.toLocaleString() }}</span> 지출 :
      <span class="expense">{{ totalExpense.toLocaleString() }}</span>
    </div>
    <div class="calendar-box">
      <div class="header">
        <button class="removeBtn" @click="previousMonth">&lt;</button>
        <span>{{ currentMonth }}</span>
        <button class="removeBtn" @click="nextMonth">&gt;</button>
      </div>
      <div class="days">
        <div v-for="(day, index) in days" :key="index" class="day">
          {{ day }}
        </div>
        <div
          v-for="(day, index) in previousMonthDays"
          :key="'prev' + index"
          class="day previous-month"
        >
          {{ day }}
        </div>
        <div
          v-for="(day, index) in daysInMonth"
          :key="index"
          :class="{
            date: true,
            today: isToday(day),
            'money-entry': hasMoneyEntry(day),
          }"
        >
          {{ day }}
          <div v-if="hasMoneyEntry(day)">
            <div
              v-for="entry in getMoneyEntries(day)"
              :key="entry.id"
              class="money-amount"
              :style="{
                color: entry.amount > 0 ? 'green' : 'red',
              }"
            >
              {{ entry.amount > 0 ? '+' : '-'
              }}{{ Math.abs(entry.amount).toLocaleString() }}
            </div>
          </div>
        </div>
        <div
          v-for="(day, index) in nextMonthDays"
          :key="'next' + index"
          class="day next-month"
        >
          {{ day }}
        </div>
        <div
          v-for="index in emptyCells"
          :key="'empty' + index"
          class="day empty-cell"
        ></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useMoneyManageStore } from '@/stores/counter';
import '@/asset/calenderpage.css';

const store = useMoneyManageStore();

const currentDate = new Date();
const currentYear = ref(currentDate.getFullYear());
const currentMonthIndex = ref(currentDate.getMonth());

const firstDayOfMonth = computed(() => {
  return new Date(currentYear.value, currentMonthIndex.value, 1).getDay();
});

const daysInMonth = computed(() => {
  const lastDayOfMonth = new Date(
    currentYear.value,
    currentMonthIndex.value + 1,
    0
  );
  const days = [];
  for (let i = 1; i <= lastDayOfMonth.getDate(); i++) {
    days.push(i);
  }
  return days;
});

const previousMonthDays = computed(() => {
  const firstDay = firstDayOfMonth.value;
  if (firstDay === 0) return [];
  const lastDayOfPrevMonth = new Date(
    currentYear.value,
    currentMonthIndex.value,
    0
  ).getDate();
  const days = [];
  for (
    let i = lastDayOfPrevMonth - firstDay + 1;
    i <= lastDayOfPrevMonth;
    i++
  ) {
    days.push(i);
  }
  return days;
});

const nextMonthDays = computed(() => {
  const totalDays = previousMonthDays.value.length + daysInMonth.value.length;
  const nextDaysCount = totalDays % 7 === 0 ? 0 : 7 - (totalDays % 7);
  const days = [];
  for (let i = 1; i <= nextDaysCount; i++) {
    days.push(i);
  }
  return days;
});

const currentMonth = computed(() => {
  const options = { month: 'long', year: 'numeric' };
  return new Date(
    currentYear.value,
    currentMonthIndex.value
  ).toLocaleDateString(undefined, options);
});

const emptyCells = computed(() => {
  const totalCells = 42;
  return (
    totalCells -
    (previousMonthDays.value.length +
      daysInMonth.value.length +
      nextMonthDays.value.length)
  );
});

function previousMonth() {
  if (currentMonthIndex.value === 0) {
    currentYear.value--;
    currentMonthIndex.value = 11;
  } else {
    currentMonthIndex.value--;
  }
}

function nextMonth() {
  if (currentMonthIndex.value === 11) {
    currentYear.value++;
    currentMonthIndex.value = 0;
  } else {
    currentMonthIndex.value++;
  }
}

function isToday(day) {
  const todayDate = new Date();
  return (
    day === todayDate.getDate() &&
    currentMonthIndex.value === todayDate.getMonth() &&
    currentYear.value === todayDate.getFullYear()
  );
}

const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

function hasMoneyEntry(day) {
  const entries = store.states.manageList.filter((entry) => {
    const entryDate = new Date(entry.date);
    return (
      entryDate.getDate() === day &&
      entryDate.getMonth() === currentMonthIndex.value &&
      entryDate.getFullYear() === currentYear.value
    );
  });
  return entries.length > 0;
}

function getMoneyEntries(day) {
  return store.states.manageList.filter((entry) => {
    const entryDate = new Date(entry.date);
    return (
      entryDate.getDate() === day &&
      entryDate.getMonth() === currentMonthIndex.value &&
      entryDate.getFullYear() === currentYear.value
    );
  });
}

const totalIncome = computed(() => {
  return store.states.manageList.reduce((sum, entry) => {
    const entryDate = new Date(entry.date);
    if (
      entryDate.getMonth() === currentMonthIndex.value &&
      entryDate.getFullYear() === currentYear.value &&
      entry.amount > 0
    ) {
      return sum + entry.amount;
    }
    return sum;
  }, 0);
});

const totalExpense = computed(() => {
  return store.states.manageList.reduce((sum, entry) => {
    const entryDate = new Date(entry.date);
    if (
      entryDate.getMonth() === currentMonthIndex.value &&
      entryDate.getFullYear() === currentYear.value &&
      entry.amount < 0
    ) {
      return sum + entry.amount;
    }
    return sum;
  }, 0);
});
</script>
