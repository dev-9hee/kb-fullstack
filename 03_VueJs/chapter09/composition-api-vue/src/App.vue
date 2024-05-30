<template>
  <div class="main">
    <button @click="showModal">모달 열기</button>
    <ModalComponent :visible="isModalVisible" @close-modal="hideModal">
      <h1>잘 내려가니?</h1>
    </ModalComponent>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import ModalComponent from './components/ModalComponent.vue';

const isModalVisible = ref(false);

function showModal() {
  isModalVisible.value = true;
}

function hideModal() {
  isModalVisible.value = false;
}
</script>

<style scoped>
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
