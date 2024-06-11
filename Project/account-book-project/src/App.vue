<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <div>
    <nav>
      <router-link to="/">홈</router-link>
      &nbsp;
      <router-link to="/history">거래 리스트</router-link>
      &nbsp;
      <router-link to="/content">지표</router-link>
      &nbsp;
      <router-link to="/summary">요약(차트)</router-link>
    </nav>
    <RouterView />
  </div>
</template>
