<script setup>
import ParentScopedSlot from './components/ParentScopedSlot.vue';
</script>
<template>
  <div>
    <ParentScopedSlot />
  </div>
</template>

<script>
export default {
  name: 'APP',
  components: { ParentScopedSlot },
};
</script>

<style lang="scss" scoped></style>
