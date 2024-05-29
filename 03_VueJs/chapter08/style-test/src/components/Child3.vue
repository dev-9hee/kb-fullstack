<template>
  <!-- 추가 -->
  <!-- 동적으로 클래스 이름을 할당 -->
  <div :class="$style.child">
    <!-- <div class="child"> -->
    <h2>Child3</h2>
  </div>
</template>

<script>
export default {
  name: 'Child3',
  // 컴포넌트 인스턴스가 생성된 후 호출(특정 작업 수행)
  created() {
    // 추가
    console.log(this.$style); // 변환된 클래스 이름을 확인
  },
};
</script>

<!-- CSS 모듈로 문제 해결 -->
<!-- 스타일을 모듈화하여 컴포넌트 내에서만 유효하도록 함 -->
<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
