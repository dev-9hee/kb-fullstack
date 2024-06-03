<script setup></script>

<template>
  <!-- 주소 변화가 뽀인트!! -->
  <div>
    <nav>
      <router-link to="/">홈페이지</router-link>
      <!-- &nbsp : 스페이스바 한칸 의미 -->
      &nbsp;
      <RouterLink to="/about">라우터란!?</RouterLink>
      &nbsp;
      <RouterLink to="/dynamic/happy">행복하다!!</RouterLink>
      &nbsp;
      <RouterLink to="/dynamic/exciting">신난다!!</RouterLink>
      &nbsp;
      <RouterLink to="/jihee">이름 : 정지희</RouterLink>
    </nav>
    <!-- 라우팅에 대응하는 컴포넌트를 어디에 배치할건지를 설정 -->
    <!-- <router-view /> -->
    <RouterView />
  </div>
</template>

<style scoped>
@font-face {
  font-family: 'DOSPilgiMedium';
  src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/DOSPilgiMedium.woff2')
    format('woff2');
  font-weight: normal;
  font-style: normal;
}

div {
  font-family: 'DOSPilgiMedium';
  font-weight: 400;
  font-style: normal;
}
</style>
