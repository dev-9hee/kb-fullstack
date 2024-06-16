<template>
  <!-- 전달 받은 속성은 보건법 적용 or 바인딩 가능 -->
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>
<script>
export default {
  name: 'CheckboxItem',
  // props 옵션으로 부모 컴포넌트로부터 전달받을 속성 정의
  props: ['name', 'checked'], // 부모 -> 자식 : 속성(props) , 속성명을 배열로 정의
  // 속성명 : name, checked
};
</script>
