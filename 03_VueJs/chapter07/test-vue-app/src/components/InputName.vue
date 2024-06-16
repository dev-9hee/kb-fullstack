<!-- 자식 컴포넌트 -->
<template>
  <div style="border: solid 1px gray; padding: 5px">
    이름 : <input type="text" v-model="name" />
    <!-- 자식 컴포넌트에서 인스턴스의 $emit() 메서드를 이용해 이벤트를 발신 -->
    <!-- 'nameChanged'는 이벤트 이름, 이 이벤트를 통해 부모 컴포넌트에게 알림을 보냄 -->
    <!-- { name }은 이벤트와 함께 전달되는 데이터 -->
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>

<script>
export default {
  name: 'InputName',
  data() {
    return { name: '' };
  },
};
</script>
