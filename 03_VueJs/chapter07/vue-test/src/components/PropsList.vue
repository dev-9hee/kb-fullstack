<template>
  <div>
    <h2>{{ siteName }}</h2>
    <!-- 속성값에 변수를 바인딩할 때 v-bind: or : -->
    <a :href="siteUrl">{{ siteName }} 링크</a>
    <h2>방문 여부 : {{ visited }}</h2>
    <hr />
  </div>
</template>

<script>
export default {
  name: 'PropsList',
  props: ['siteName', 'siteUrl', 'visited'],
};
</script>

<style lang="scss" scoped></style>
