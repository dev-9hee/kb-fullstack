<template>
  <div class="container">
    <div v-if="loading" class="loading">로딩 중...</div>
    <div v-else-if="error" class="error">{{ error }}</div>
    <form v-else @submit.prevent="updatePost" class="edit-form">
      <div class="form-group">
        <label for="author">작성자</label>
        <input
          type="text"
          id="author"
          v-model="post.author"
          required
          class="form-control"
        />
      </div>
      <div class="form-group">
        <label for="title">제목</label>
        <input
          type="text"
          id="title"
          v-model="post.title"
          required
          class="form-control"
        />
      </div>
      <div class="form-group">
        <label for="content">내용</label>
        <textarea
          id="content"
          v-model="post.content"
          required
          class="form-control"
          rows="10"
        ></textarea>
      </div>
      <div class="actions">
        <button type="submit" class="btn btn-primary">수정 완료</button>
        <button @click.prevent="cancelEdit" class="btn btn-secondary">
          취소
        </button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const router = useRouter();

const post = ref({
  title: '',
  content: '',
  author: '',
});
const loading = ref(true);
const error = ref(null);

const baseUri = 'http://localhost:8080/rest/board';

onMounted(fetchPost);

async function fetchPost() {
  const postId = route.params.id;
  loading.value = true;
  error.value = null;

  try {
    const response = await axios.get(`${baseUri}/detail/${postId}`);
    post.value = response.data;
  } catch (err) {
    error.value = '게시글을 불러오는데 실패했습니다.';
    console.error('게시글 불러오기 실패:', err);
  } finally {
    loading.value = false;
  }
}

async function updatePost() {
  loading.value = true;
  error.value = null;

  try {
    await axios.post(`${baseUri}/update`, post.value);
    alert('게시글이 성공적으로 수정되었습니다.');
    router.push({ name: 'BoardDetail', params: { id: post.value.id } });
  } catch (err) {
    error.value = '게시글 수정에 실패했습니다.';
    console.error('게시글 수정 실패:', err);
  } finally {
    loading.value = false;
  }
}

function cancelEdit() {
  router.push({ name: 'BoardDetail', params: { id: post.value.id } });
}
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

.edit-form {
  background-color: #ffffff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

.form-control {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 16px;
}

.actions {
  display: flex;
  justify-content: flex-start;
  gap: 10px;
}

.btn {
  display: inline-block;
  padding: 10px 20px;
  color: #fff;
  text-decoration: none;
  border-radius: 4px;
  transition: background-color 0.3s;
  border: none;
  cursor: pointer;
}

.btn-primary {
  background-color: #28a745;
  color: #fff;
}

.btn-primary:hover {
  background-color: #218838;
}

.btn-secondary {
  background-color: #6c757d;
  color: #fff;
}

.btn-secondary:hover {
  background-color: #5a6268;
}

.loading,
.error {
  text-align: center;
  padding: 20px;
  font-size: 1.2rem;
}

.error {
  color: #dc3545;
}
</style>
