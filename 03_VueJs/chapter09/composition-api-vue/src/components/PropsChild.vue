<template>
  <div>
    <h1>{{ msg }}</h1>
  </div>
</template>

<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  msg: {
    type: String,
    required: true,
  },
}); // 객체로 전달
</script>
