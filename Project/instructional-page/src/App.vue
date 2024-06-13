<script setup></script>

<template>
  <div class="body">
    <div>
      <nav>
        <router-link to="/">홈페이지</router-link>
        &nbsp;
        <RouterLink to="/1">권오현</RouterLink>
        &nbsp;
        <RouterLink to="/2">정지희</RouterLink>
        &nbsp;
        <RouterLink to="/3">최규찬</RouterLink>
        &nbsp;
        <RouterLink to="/4">최호진</RouterLink>
      </nav>
    </div>
    <div style="display: flex; justify-content: center">
      <RouterView />
    </div>
  </div>
</template>

<style scoped>
* {
  -webkit-tap-highlight-color: transparent;
  text-decoration: none;
  font-family: 'DOSPilgiMedium';
  font-weight: 400;
  font-style: normal;
}
@font-face {
  font-family: 'DOSPilgiMedium';
  src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/DOSPilgiMedium.woff2') format('woff2');
  font-weight: normal;
  font-style: normal;
}
.body {
  width: 100vw;
  height: 100vh;
  background-color: pink;
}
nav {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 40px;
  gap: 20px;
  font-weight: bold;
  width: 100vw;
  height: 200px;
  font-size: 30px;
}
nav > a {
  /* color: #3aa6b9; */
  color: white;
  text-shadow: 2px 2px 5px rgba(0, 0, 0, 1);
  transition: transform 0.3s;
}
a:focus {
  color: rgb(226, 115, 133);
  transform: scale(1.1) translate(10px, -10px);
}
</style>
