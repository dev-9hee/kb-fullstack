<!-- 최상위 컴포넌트 -->
<script setup>
import NoSlotTest from './components/NoSlotTest.vue'; // 컴포넌트를 import
</script>

<template>
  <div>
    <!-- 템플릿에 포함 -->
    <NoSlotTest />
  </div>
</template>

<script>
export default {
  name: 'App', // 컴포넌트 이름
};
</script>

<!-- 전체 동작 설명 -->
<!-- 
    1. App.vue는 NoSlotTest 컴포넌트를 렌더링합니다.
    2. NoSlotTest.vue는 여러 개의 CheckBox1 컴포넌트를 렌더링하고, 각 컴포넌트에 items 배열의 데이터를 전달합니다.
    3. 각 CheckBox1 컴포넌트는 체크박스를 렌더링하고, 체크박스 상태가 변경되면 check-changed 이벤트를 발생시킵니다.
    4. NoSlotTest.vue는 CheckBox1에서 발생한 check-changed 이벤트를 청취하고, CheckBoxChanged 메서드를 호출하여 items 배열의 해당 항목의 checked 상태를 업데이트합니다. -->
