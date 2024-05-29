<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은?(첫번째:Slot사용(X))</h3>
    <!-- v-for 디렉티브를 사용
      items 배열의 각 항목에 대해 CheckBox1 컴포넌트를 생성 -->
    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    >
    </CheckBox1>
    <!-- CheckBoxChanged 메서드는 자식 컴포넌트에서 
      check-changed 이벤트가 발생할 때 호출 -->
  </div>
</template>

<script>
import CheckBox1 from './CheckBox1.vue'; // 자식 모듈 가져옴
export default {
  name: 'NoSlotTest',
  components: { CheckBox1 }, // 자식 컴포넌트 가져옴
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' }, // 초기값 Vue만 체크
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      let item = this.items.find((item) => item.id === e.id);
      item.checked = e.checked;
    },
  },
};
</script>
