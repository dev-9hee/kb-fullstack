<template>
  <div class="fancy">
    <slot name="title"></slot>
    <slot name="photo"></slot>
  </div>
</template>

<script>
export default {
  name: 'FancyPhotoBox',
};
</script>

<style>
.fancy {
  text-align: center;
  padding: 30px;
  border-radius: 30px;
  border: 10px solid palevioletred;
  background-color: pink;
  margin: 30px 0;
}
</style>
