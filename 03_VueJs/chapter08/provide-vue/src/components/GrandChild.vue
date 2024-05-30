<template>
  <div>
    <h1>드디어 도착한 props의 내용은?</h1>
    <h2>{{ drilling }}</h2>
    <h1>한번에 날아온 provide 값은?</h1>
    <h2>{{ fly }}</h2>
  </div>
</template>

<script>
export default {
  name: 'GrandChild',
  props: ['drilling'],
  inject: ['fly'],
};
</script>

<style lang="scss" scoped></style>
