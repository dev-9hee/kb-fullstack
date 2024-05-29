<!-- 체크박스 상태가 변경될 때 부모에게 이벤트 발생 시킴 -->
<template>
  <div>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 체크박스의 change 이벤트가 발생할 때,
       $emit을 사용하여 check-changed 이벤트를 발생시키고, 
       체크박스의 상태(id와 checked 값)를 부모 컴포넌트로 전달 -->
    <!-- $event.target.checked : 체크박스의 현재 체크상태 -->

    <!-- 체크박스가 체크된 상태에 따라 label의 스타일이 변경 -->
    <span
      v-if="checked === true"
      style="color: blue; text-decoration: underline"
    >
      <i>{{ label }}</i>
    </span>
    <span v-else style="color: gray">{{ label }}</span>
  </div>
</template>
<script>
export default {
  name: 'CheckBox1',
  props: ['id', 'checked', 'label'], // props를 통해 부모로부터 id, checked, label을 받음
};
</script>
