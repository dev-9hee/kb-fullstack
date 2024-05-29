<script setup>
import FancyPhotoBox from './components/FancyPhotoBox.vue';
import ParentFancyPhotoBox from './components/ParentFancyPhotoBox.vue';
</script>
<template>
  <div>
    <ParentFancyPhotoBox />
  </div>
</template>

<script>
export default {
  name: 'APP',
  components: { FancyPhotoBox, ParentFancyPhotoBox },
};
</script>

<style lang="scss" scoped></style>
