<template>
  <div class="container">
    <img src="../imgs/CHOI-2.jpg" alt="호랑이" />

    <div class="main">
      <div class="item">
        <h2>이름: 최호진</h2>
        <h2>MBTI: INFJ</h2>
        <h2>고향: SEOUL</h2>
        <h2>띠: 소띠</h2>
        <h2>혈액형: A형</h2>
        <h2>좋아하는 연예인: 리즈, 레이</h2>
      </div>
    </div>
  </div>
</template>

<script></script>
<style>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 50px;
  border-radius: 30px;
  background-color: rgb(253, 246, 166);
  width: 900px;
  height: 600px;
  gap: 40px;
}
img {
  width: 350px;
  height: 470px;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}
.main {
  border-radius: 30px;
  width: 350px;
  height: 470px;
}
.name {
  display: flex;
  justify-self: center;
  align-items: center;
}
.item {
  display: flex;
  flex-direction: column;
  gap: 10px;
  font-size: bold;
}
</style>
