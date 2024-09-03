<template>
  <div class="container">
    <div v-if="loading" class="loading">로딩 중...</div>
    <div v-else-if="error" class="error">{{ error }}</div>
    <div v-else-if="post" class="post-detail">
      <h1 class="post-title">{{ post.title }}</h1>
      <div class="post-meta">
        <span class="post-author">작성자: {{ post.author }}</span>
        <span class="post-date">작성일: {{ formatDate(post.regDate) }}</span>
      </div>
      <div class="post-content">{{ post.content }}</div>
      <div class="actions">
        <button @click="editPost" class="btn btn-edit">수정</button>
        <button @click="confirmDelete" class="btn btn-delete">삭제</button>
        <router-link :to="{ name: 'BoardList' }" class="btn btn-back">
          목록으로
        </router-link>
      </div>
    </div>
    <div v-else class="not-found">게시글을 찾을 수 없습니다.</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const router = useRouter();

const post = ref(null);
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

function formatDate(timestamp) {
  const date = new Date(timestamp);
  return `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(
    2,
    '0'
  )}-${String(date.getDate()).padStart(2, '0')}`;
}

function editPost() {
  router.push({ name: 'BoardEdit', params: { id: post.value.id } });
}

async function confirmDelete() {
  if (window.confirm('정말로 이 게시글을 삭제하시겠습니까?')) {
    try {
      await axios.post(`${baseUri}/delete?id=${post.value.id}`);
      alert('게시글이 삭제되었습니다.');
      router.push({ name: 'BoardList' });
    } catch (err) {
      error.value = '게시글 삭제에 실패했습니다.';
      console.error('게시글 삭제 실패:', err);
    }
  }
}
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.post-detail {
  background-color: #ffffff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.post-title {
  font-size: 2rem;
  color: #333;
  margin-bottom: 10px;
}

.post-meta {
  display: flex;
  justify-content: space-between;
  color: #666;
  margin-bottom: 20px;
}

.post-content {
  font-size: 1.1rem;
  line-height: 1.6;
  color: #333;
  margin-bottom: 20px;
}

.actions {
  margin-top: 20px;
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

.btn-back {
  background-color: #6c757d;
}

.btn-back:hover {
  background-color: #5a6268;
}

.btn-edit {
  background-color: #28a745;
}

.btn-edit:hover {
  background-color: #218838;
}

.btn-delete {
  background-color: #dc3545;
}

.btn-delete:hover {
  background-color: #c82333;
}

.loading,
.error,
.not-found {
  text-align: center;
  padding: 20px;
  font-size: 1.2rem;
}

.error {
  color: #dc3545;
}
</style>
