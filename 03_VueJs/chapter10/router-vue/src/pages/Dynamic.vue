<template>
  <div>
    <h1>오늘의 기분은!? {{ msg }}</h1>
    <img :src="imgSrc" :alt="msg" />
  </div>
</template>

<script setup>
import { ref, computed, watch } from 'vue';
import { useRoute } from 'vue-router';

const currentRoute = useRoute(); // 관련 route를 직접적으로 사용 가능
const mood = ref(currentRoute.params.mood); // 데이터의 변화에 따라 바뀔 수 있게 ref로 감싸줌

// 많이 사용, 익혀두기
watch(
  () => currentRoute.params.mood,
  (newMood) => (mood.value = newMood)
);

const msg = computed(() =>
  mood.value === 'happy' ? '행복합니다!!' : '신납니다!!'
);

const imgSrc = computed(() =>
  mood.value === 'happy'
    ? 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCRvSDPyt0xDSievNE71sfEDcxFPRbVxWdiw&s'
    : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdInSDu91rwLJ5c1KZtXEIrvb7BpHMvF4XMQ&s'
);
</script>
