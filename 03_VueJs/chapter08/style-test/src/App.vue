<script setup>
import Child1 from './components/Child1.vue';
import Child2 from './components/Child2.vue';
import Child3 from './components/Child3.vue';
</script>

<template>
  <div>
    <Child1 />
    <Child2 />
    <Child3 />
  </div>
</template>

<!-- Vue 컴포넌트의 스타일은 기본적으로 전역으로 적용
    이는 동일한 클래스명이 다른 컴포넌트에서 사용될 경우, 
    스타일이 충돌하거나 예기치 않게 덮어써지는 문제를 일으킬 수 있다. -->
<!-- 스타일 충돌 문제 해결방법 : <style scoped>를 사용 / Child1, Child2..!!
    스타일이 해당 컴포넌트에만 적용되도록 제한한다.
     Vue는 컴파일 시 해당 스타일이 해당 컴포넌트에만 적용되도록 
     고유한 데이터 속성을 자동으로 추가-->
<!-- 해결방법2 : CSS 모듈 사용 / Child3 -->

<script>
// Vue 컴포넌트는 기본적으로 객체를 export
export default {
  name: 'App', // 컴포넌트의 이름을 지정
  // components 등록 필요 없음, <script setup>에서 이미 import됨
  components: { Child1, Child2, Child3 }, // 이 컴포넌트가 포함하고 있는 자식 컴포넌트들을 지정
};
</script>
