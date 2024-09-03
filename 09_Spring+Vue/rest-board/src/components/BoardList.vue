<template>
  <div class="container">
    <div class="board">
      <h1>게시판</h1>
      <div class="board-header">
        <router-link :to="{ name: 'BoardCreate' }" class="btn btn-create">
          글 작성
        </router-link>
      </div>
      <div v-if="loading" class="loading">로딩 중...</div>
      <div v-else-if="error" class="error">{{ error }}</div>
      <div v-else>
        <ul class="post-list" v-if="posts.length > 0">
          <li v-for="post in posts" :key="post.id" class="post-item">
            <div class="post-header">
              <h3 class="post-title">
                <router-link
                  :to="{ name: 'BoardDetail', params: { id: post.id } }"
                >
                  {{ post.title }}
                </router-link>
              </h3>
              <span class="post-date">{{ formatDate(post.regDate) }}</span>
            </div>
            <p class="post-content">{{ post.content }}</p>
            <div class="post-footer">
              <span class="post-author">작성자: {{ post.author }}</span>
            </div>
          </li>
        </ul>
        <div v-else class="no-posts">게시글이 없습니다.</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const posts = ref([]);
const loading = ref(false);
const error = ref(null);

const baseUri = 'http://localhost:8080/rest/board/list';

onMounted(fetchPosts);

async function fetchPosts() {
  loading.value = true;
  error.value = null;
  try {
    const response = await axios.get(baseUri);
    posts.value = response.data;
  } catch (err) {
    error.value = '게시글 목록을 불러오는데 실패했습니다.';
    console.error('게시글 목록 불러오기 실패:', err);
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
</script>

<style scoped>
.container {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.board {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  color: #333;
  font-size: 2rem;
  margin-bottom: 20px;
}

.board-header {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 20px;
}

.btn-create {
  background-color: #28a745;
  color: white;
  padding: 10px 20px;
  border-radius: 5px;
  text-decoration: none;
  transition: background-color 0.3s;
}

.btn-create:hover {
  background-color: #218838;
}

.post-list {
  list-style: none;
  padding: 0;
}

.post-item {
  background-color: white;
  margin-bottom: 15px;
  padding: 15px;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.post-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.post-title {
  margin: 0;
  font-size: 1.2rem;
  color: #333;
}

.post-title a {
  color: #333;
  text-decoration: none;
}

.post-title a:hover {
  text-decoration: underline;
}

.post-date {
  color: #777;
  font-size: 0.9rem;
}

.post-content {
  color: #333;
  margin-bottom: 10px;
}

.post-footer {
  color: #777;
  font-size: 0.9rem;
}

.loading,
.error,
.no-posts {
  text-align: center;
  padding: 20px;
  font-size: 1rem;
  color: #666;
}

.error {
  color: #d9534f;
}
</style>
