<template>
  <div>
    <nav>
      <router-link to="/">홈페이지</router-link>
      &nbsp;
      <router-link to="/login">로그인</router-link>
      &nbsp;
      <router-link to="/todo">Todolist</router-link>
      <!-- &nbsp;
      <router-link to="/todomain">TodoMain</router-link> -->
    </nav>
    <router-view />
  </div>
</template>

<script setup>
// localStorage.setItem('name', '정지희');
// localStorage.setItem('stophee', '스탑희에요');
// localStorage.setItem('pororo', '뽀로로에요');
// // const name = localStorage.getItem('name');
// console.log(localStorage);
// // removeItem() : 하나만 삭제 / clear() : 전부 삭제
</script>
