<template>
  <div>
    <h1>Login</h1>
    아이디 : <input type="text" v-model.trim="userId" />
    <br />
    패스워드 : <input type="password" v-model.trim="userPassword" />
    <br />
    <button @click="login">로그인</button>
    &nbsp;
    <button @click="logout">로그아웃</button>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';

const userId = ref('');
const userPassword = ref('');

async function login() {
  try {
    const url = 'http://localhost:3000/users';
    const loginRes = await axios.get(url); // 로그인에 대한 응답을 이 변수에 담겠다

    // console.log('loginRes', loginRes);
    const userArr = loginRes.data;
    // 배열 함수
    const findedUser = userArr.find((item, index) => item.id === userId.value);

    if (findedUser === undefined) {
      return alert('해당 ID를 가지는 사용자가 없습니다!');
    }

    if (findedUser.password !== userPassword.value) {
      return alert('비밀번호가 일치하지 않습니다!');
    }

    localStorage.setItem('auth', 'true'); // 인가 관련 정보를 넣어줌
    alert('로그인 성공');
  } catch (e) {
    alert('로그인 과정에 문제 발생!');
    console.log(e);
  }
}

async function logout() {
  localStorage.removeItem('auth');
}
</script>
