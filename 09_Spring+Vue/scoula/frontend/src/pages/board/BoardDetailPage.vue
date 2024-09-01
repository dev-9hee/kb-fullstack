<script setup>
import { useRoute, useRouter } from 'vue-router';
import api from '@/api/boardApi';
import { ref } from 'vue';
import moment from 'moment';
import { useAuthStore } from '@/stores/auth';
import { downloadFile } from '@/util/download';

const auth = useAuthStore();
const cr = useRoute();
const router = useRouter();

const no = cr.params.no;
const article = ref({});

const back = () => {
  router.push({ name: 'board/list', query: cr.query });
};

const update = () => {
  router.push({ name: 'board/update', params: { no: no }, query: cr.query });
};

const download = async (no) => {
  const URL = '/api/board/download/' + no;
  console.log(URL);
  await downloadFile(URL);
};

const remove = async () => {
  if (!confirm('삭제할까요?')) return;
  await api.delete(no);
  router.push({ name: 'board/list', query: cr.query });
};

const load = async () => {
  article.value = await api.get(no);
  console.log('DETAIL', article.value);
};

load();
</script>

<template>
  <h1>{{ article.title }}</h1>
  <div class="my-3 d-flex justify-content-between">
    <div>
      <i class="fa-solid fa-user"></i>
      {{ article.writer }}
    </div>
    <div>
      <i class="fa-regular fa-clock"></i>
      {{ moment(article.updateDate).format('YYYY-MM-DD HH:mm') }}
    </div>
  </div>

  <hr />

  <div class="text-end">
    <div v-for="file in article.attaches" :key="file.no" class="attach">
      <span @click="download(file.no)">
        <i class="fa-solid fa-paperclip"></i>
        {{ file.filename }}
      </span>
    </div>
  </div>

  <div class="content">{{ article.content }}</div>

  <div class="my-5">
    <button class="btn btn-primary me-2" @click="back"><i class="fa-solid fa-list"></i> 목록</button>

    <!-- 로그인 사용자와 작성자가 같은 경우 -->
    <template v-if="auth.username == article.writer">
      <button class="btn btn-primary me-2" @click="update"><i class="fa-regular fa-pen-to-square"></i> 수정</button>
      <button class="btn btn-danger" @click="remove"><i class="fa-solid fa-trash-can"></i> 삭제</button>
    </template>
  </div>
</template>

<style scoped>
.attach {
  font-size: 0.8rem;
  cursor: pointer;
}
.content {
  white-space: pre-line;
}
</style>
