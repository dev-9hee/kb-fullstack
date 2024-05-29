<!-- 최상위 컴포넌트 -->
<script setup>
import NamedSlotTest from './components/NamedSlotTest.vue';
import NoSlotTest from './components/NoSlotTest.vue'; // 컴포넌트를 import
import SlotTest from './components/SlotTest.vue';
</script>

<template>
  <div>
    <!-- 템플릿에 포함 -->
    <NoSlotTest />
    <SlotTest />
    <NamedSlotTest />
  </div>
</template>

<script>
export default {
  name: 'App', // 컴포넌트 이름
  // components: { NoSlotTest, SlotTest, NamedSlotTest },
};
</script>
