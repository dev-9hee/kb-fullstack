<template>
  <div>
    <FancyPhotoBox>
      <template v-slot:title>
        <h1>귀여운 헬로키티</h1>
      </template>
      <template v-slot:photo>
        <img
          src="https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/201409/01/htm_20140901111016a600c011.jpg"
          art="헬로키티"
        />
      </template>
    </FancyPhotoBox>
  </div>
</template>

<script>
import FancyPhotoBox from './FancyPhotoBox.vue';
export default {
  name: 'ParentFancyPhotoBox',
  components: { FancyPhotoBox },
};
</script>
