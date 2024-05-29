<template>
  <div class="child">
    <h2>Child2</h2>
  </div>
</template>

<script>
export default {
  name: 'Child2',
};
</script>

<!-- scoped 사용해서 스타일 충돌 문제 해결!!  -->
<style scoped>
.child {
  background-color: blue;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
