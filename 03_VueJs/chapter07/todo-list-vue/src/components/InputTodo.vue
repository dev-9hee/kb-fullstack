<template>
  <div>
    <input type="text" v-model.trim="todo" />
    <!-- 데이터는 꼭 객체로 보냄 -->
    <button @click="$emit('addTodo', { todo })">추가</button>
  </div>
</template>

<script>
export default {
  name: 'InputTodo',
  data() {
    return {
      todo: '', // input으로 받은 데이터를 씀
    };
  },
};
</script>

<style lang="scss" scoped></style>
