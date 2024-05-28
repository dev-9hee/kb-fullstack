<script setup>
import PropsList from './components/PropsList.vue';
import PropsList2 from './components/PropsList2.vue';
</script>

<template>
  <div class="siteName siteUrl visited">
    <PropsList siteName="네이버" siteUrl="https://naver.com" visited="방문" />
    <PropsList siteName="다음" siteUrl="https://daum.net" visited="미방문" />
    <PropsList2 :siteInfo="siteData" />
  </div>
</template>

<script>
export default {
  name: 'APP',
  data() {
    return {
      siteData: {
        siteName: '페이스북',
        siteUrl: 'http://facebook.com',
        visited: '방문',
      },
    };
  },
};
</script>
