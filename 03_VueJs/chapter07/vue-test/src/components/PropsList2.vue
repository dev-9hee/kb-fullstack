<template>
  <div>
    <h2>{{ siteInfo.siteName }}</h2>
    <a :href="siteInfo.siteUrl">{{ siteInfo.siteName }} 링크</a>
    <h2>방문 여부 : {{ siteInfo.visited }}</h2>
    <hr />
  </div>
</template>

<script>
export default {
  name: 'PropsList2',
  props: ['siteInfo'],
};
</script>

<style lang="scss" scoped></style>
