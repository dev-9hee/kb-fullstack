<script setup>
import SendNameComponent from './components/SendNameComponent.vue';
</script>

<template>
  <div>
    <h1>너의 이름은 {{ name }}</h1>
    <SendNameComponent v-on:nameChange="nameChangeHandler" />
  </div>
</template>

<script>
export default {
  name: 'APP',
  data() {
    return {
      name: '',
    };
  },
  methods: {
    nameChangeHandler(e) {
      this.name = e.name;
    },
  },
};
</script>
