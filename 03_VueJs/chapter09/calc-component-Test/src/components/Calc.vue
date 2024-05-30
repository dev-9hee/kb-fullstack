<template>
  <div>
    <!-- return하는 참조값만 위에서 사용 가능,  -->
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'Calc',
  setup() {
    // 레퍼런스 함수에 의해서 만들어진 반응성 데이터만 수정 가능
    // ref : Proxy객체, Proxy객체의 참조값이 상수 x,y로 들어감
    const x = ref(10); // 10 : 초기값
    const y = ref(20); // 20 : 초기값
    return { x, y };
  },
};
</script>
