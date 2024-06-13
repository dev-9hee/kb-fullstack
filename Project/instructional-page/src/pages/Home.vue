<template>
  <div class="body">
    <h1>서 울 사 라ㅇ 들</h1>
    <img src="../imgs/haecher.png" alt="패럿" class="img" />
  </div>
</template>

<script></script>
<style>
body {
  /* position: relative; */
  /* display: flex; */
  /* width: 100px; */
  display: flex;
  justify-content: center;
}
h1 {
  font-size: 70px;

  text-align: center;
}

.img {
  width: 340px;
  height: 350px;
  animation: jump 5s infinite, moveRight 7s infinite;
  transition: transform 0.3s;
}
@keyframes jump {
  0%,
  100% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-50px);
  }
}

@keyframes moveRight {
  0%,
  100% {
    transform: translateX(0);
  }
  50% {
    transform: translateX(700px);
  }
}
</style>
