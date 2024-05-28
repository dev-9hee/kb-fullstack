<script setup>
import ColorEmit from './components/ColorEmit.vue';
</script>

<template>
  <div :style="{ backgroundColor: color }">
    <h1>색상 선택 : {{ color }}</h1>
    <ColorEmit v-on:colorChange="colorChangeHandler" />
  </div>
</template>

<script>
export default {
  name: 'APP',
  data() {
    return {
      color: '',
    };
  },
  // emit으로 올려보낸 데이터를 e로 받음
  methods: {
    // 변수는 내가 설정 : e말고 payload도 많이 사용
    colorChangeHandler(e) {
      this.color = e.color;
    },
  },
};
</script>
