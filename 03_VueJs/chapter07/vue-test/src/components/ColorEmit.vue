<template>
  <!-- 자식요소에서 emit으로 데이터 부모요소로 올려보냄 -->
  <div>
    <!-- trim : 공백제거 -->
    <input type="text" v-model.trim="color" />
    <!-- 문자열 이름, 전달할 데이터(객체로 보냄) -->
    <button @click="$emit('colorChange', { color })">색상 전달</button>
  </div>
</template>

<script>
export default {
  name: 'ColorEmit',
  data() {
    return {
      color: '',
    };
  },
};
</script>

<style lang="scss" scoped></style>
