<template>
  <div class="container">
    <!-- 위에 고정 상단 바 -->
    <div class="top-container">
      <img
        class="icon-menu"
        src="./icons/menu.png"
        alt="Menu"
        @click="openModal"
      />
      <div>버디의 가계부</div>
      <img
        class="icon-home"
        src="./icons/home.png"
        alt="Home"
        @click="navigateTo('/')"
      />
    </div>

    <!-- 모달창에서 페이지 선택 -->
    <div v-if="showModal" class="modalcontainer">
      <div class="modal-box">
        <img
          class="icon-close"
          src="./icons/close.png"
          alt="Close"
          @click="closeModal"
        />
        <button class="historyBtn" @click="navigateTo('/history')">
          거래 내역
        </button>
        &nbsp;
        <button class="contentAddBtn" @click="navigateTo('/add')">
          거래 추가
        </button>
        &nbsp;
        <!-- <button @click="navigateTo('/content')">새로운 거래</button> -->
        <button class="summaryBtn" @click="navigateTo('/summary')">
          거래 요약
        </button>
        &nbsp;
        <button class="calendarBtn" @click="navigateTo('/calendar')">
          캘린더
        </button>
      </div>
    </div>
    <RouterView />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { RouterView, useRouter } from 'vue-router';
import '@/asset/main.css';

const showModal = ref(false);
const router = useRouter();

function openModal() {
  showModal.value = true;
}

function closeModal() {
  showModal.value = false;
}

function navigateTo(path) {
  closeModal();
  router.push(path);
}
</script>
