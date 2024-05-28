<template>
  <div>
    <input type="text" v-model="name" />
    <button @click="$emit('nameChange', { name })">이름 전달!!</button>
    <!-- <button v-on:click="$emit">이름 전달!!</button> -->
  </div>
</template>

<script>
export default {
  name: 'SendNameComponent',
  data() {
    return {
      name: '',
    };
  },
};
</script>

<style lang="scss" scoped></style>
