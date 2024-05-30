<template>
  <div>
    <!-- 받아온 데이터를 보내줌 -->
    <GrandChild :drilling="drilling" />
  </div>
</template>

<script>
import GrandChild from './GrandChild.vue';

export default {
  name: 'Child',
  components: { GrandChild },
  props: ['drilling'], // props 데이터 받아옴
};
</script>
