<!-- 부모 컴포넌트 -->
<template>
  <div>
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터 : {{ parentName }}</h3>
  </div>
</template>
<script>
// 지역 컴포넌트로 사용, 컴포넌트 옵션에 해당 컴포넌트 지정
import InputName from '@/components/InputName.vue';
export default {
  name: 'App',
  components: { InputName },
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    nameChangedHandler(e) {
      this.parentName = e.name;
    },
  },
};
</script>
