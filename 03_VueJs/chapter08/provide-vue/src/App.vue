<script setup>
import Child from './components/Child.vue';
</script>

<template>
  <div>
    <!-- Child에 v-bind 이용해서 Props로 보내줌 -->
    <Child :drilling="drilling" />
  </div>
</template>

<script>
export default {
  name: 'APP',
  data() {
    return {
      drilling: '그만 내려가!!!!',
    };
  },
  provide() {
    return {
      fly: '훗, 한번에 와버렸슈',
    };
  },
};
</script>
