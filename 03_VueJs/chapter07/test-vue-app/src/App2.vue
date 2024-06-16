<!-- 속성을 이용해 객체 전달 -->
<template>
  <div>
    <h2>관심있는 K-POP 가수?</h2>
    <hr />
    <ul>
      <!-- v-for 디렉티브를 이용해 반복 렌더링하며 name 속성과 checked 속성 전달 -->
      <!-- 속성 전달 방법 => :name="idol.name" 과 같이 v-bind 디렉티브를 이용-->
      <!-- :idol = 자식에게 선언되는 props의 변수명, idol = 넣어줄 값 -->
      <CheckboxItem v-for="idol in idols" :key="idol.id" :idol="idol" />
    </ul>
  </div>
</template>
<script>
// 지역 컴포넌트로 사용, 컴포넌트 옵션에 해당 컴포넌트 지정
import CheckboxItem from '@/components/CheckboxItem2.vue';
export default {
  name: 'App',
  components: { CheckboxItem }, // 여러 개의 컴포넌트 등록 가능
  data() {
    return {
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
        { id: 4, name: 'ITZY', checked: false },
      ],
    };
  },
};
</script>
