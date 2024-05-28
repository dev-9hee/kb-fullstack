<template>
  <div>
    <!-- 선언한 props를 바로 사용 -->
    <h2>{{ todo }}</h2>
    <hr />
  </div>
</template>

<script>
export default {
  name: 'TodoProps',
  props: ['todo'], // 부모로부터 받아올 props를 전부 배열에 넣어서 선언
};
</script>

<style lang="scss" scoped></style>
