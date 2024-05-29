<template>
  <div>
    <ChildSlot>
      <h1>테스트, 너는 잘 가니??</h1>
      <img
        src="https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/201409/01/htm_20140901111016a600c011.jpg"
        art="헬로키티"
      />
    </ChildSlot>
  </div>
</template>

<script>
import ChildSlot from './ChildSlot.vue';

export default {
  name: 'ParentSlot',
  components: { ChildSlot },
};
</script>

<style lang="scss" scoped></style>
