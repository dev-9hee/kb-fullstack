<script setup>
import ParentSlot from './components/ParentSlot.vue';
</script>

<template>
  <div>
    <ParentSlot />
  </div>
</template>

<script>
export default {
  name: 'APP',
  components: { ParentSlot },
};
</script>
<style scoped></style>
