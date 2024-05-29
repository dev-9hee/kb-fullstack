<template>
  <div>
    <ChildScopedSlot v-slot:default="fromChild">
      <p>{{ fromChild.msg }}</p>
    </ChildScopedSlot>
  </div>
</template>

<script>
import ChildScopedSlot from './ChildScopedSlot.vue';
export default {
  name: 'ParentScopedSlot',
  components: { ChildScopedSlot },
};
</script>

<style lang="scss" scoped></style>
