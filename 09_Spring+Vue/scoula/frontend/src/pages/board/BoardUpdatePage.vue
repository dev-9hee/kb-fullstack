<script setup>
import boardApi from '@/api/boardApi';
import { ref, reactive } from 'vue';
// import { useAuthStore } from '@/stores/auth';
import { useRoute, useRouter } from 'vue-router';

// const auth = useAuthStore();

const cr = useRoute();
const router = useRouter();

const no = cr.params.no;
const article = reactive({});
const attachments = ref([]);
const orgArticle = ref({});
const files = ref(null);

const back = () => {
  router.push({ name: 'board/detail', params: { no }, query: cr.query });
};

const reset = () => {
  article.no = orgArticle.value.no;
  article.title = orgArticle.value.title;
  article.writer = orgArticle.value.writer;
  article.content = orgArticle.value.content;
  console.log(article);
};

const removeFile = async (no, filename) => {
  if (!confirm(filename + '을 삭제할까요?')) return;
  await boardApi.deleteAttachment(no);

  const ix = attachments.value.findIndex((f) => f.no === no);
  attachments.value.splice(ix, 1);
};

const submit = async () => {
  if (!confirm('수정할까요?')) return;

  if (files.value.files.length > 0) {
    article.files = files.value.files;
  }

  await boardApi.update(article);
  router.push({ name: 'board/detail', params: { no }, query: cr.query });
};

const load = async () => {
  const data = await boardApi.get(no);
  orgArticle.value = { ...data };
  attachments.value = data.attaches;
  reset();
};

load();
</script>

<template>
  <h1><i class="fa-regular fa-pen-to-square"></i> 글 수정</h1>

  <form @submit.prevent="submit">
    <div class="mb-3 mt-3">
      <label for="title" class="form-label"> 제목 </label>
      <input type="text" class="form-control" placeholder="제목" id="title" v-model="article.title" />
      <div class="invalid-feedback">제목은 필수 요소입니다.</div>
    </div>

    <div class="mb-3 mt-3">
      <label class="form-label"> 기존 첨부파일 </label>
      <div v-for="file in attachments" :key="file.no" class="attach">
        <i class="fa-solid fa-paperclip"></i>
        {{ file.filename }}
        <i class="fa-solid fa-trash-can text-danger ms-2" @click="removeFile(file.no, file.filename)"></i>
      </div>
    </div>

    <div class="mb-3 mt-3">
      <label for="files" class="form-label"> 첨부파일 </label>
      <input type="file" class="form-control" placeholder="첨부파일" id="files" ref="files" multiple />
    </div>

    <div class="mb-3 mt-3">
      <label for="content" class="form-label"> 내용 </label>
      <textarea class="form-control" placeholder="내용" id="content" v-model="article.content" rows="10"></textarea>
    </div>

    <div class="my-5 text-center">
      <button type="submit" class="btn btn-primary me-3">
        <i class="fa-solid fa-check"></i>
        확인
      </button>

      <button type="button" class="btn btn-primary me-3" @click="reset">
        <i class="fa-solid fa-undo"></i>
        취소
      </button>

      <button class="btn btn-primary" @click="back">
        <i class="fa-solid fa-arrow-left"></i>
        돌아가기
      </button>
    </div>
  </form>
</template>
<style>
.fa-trash-can {
  cursor: pointer;
}
</style>
