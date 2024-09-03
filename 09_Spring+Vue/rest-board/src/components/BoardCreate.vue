<template>
  <div class="container">
    <form @submit.prevent="createPost" class="create-form">
      <div class="form-group">
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
        <button type="submit" class="btn btn-primary">게시글 작성</button>
        <button @click.prevent="cancelCreate" class="btn btn-secondary">
          취소
        </button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const router = useRouter();

const post = ref({
  title: '',
  content: '',
  author: '',
});

const baseUri = 'http://localhost:8080/rest/board';

async function createPost() {
  try {
    const response = await axios.post(`${baseUri}/create`, post.value);
    alert('게시글이 성공적으로 작성되었습니다.');
    router.push({ name: 'BoardList' });
  } catch (err) {
    alert('게시글 작성에 실패했습니다.');
    console.error('게시글 작성 실패:', err);
  }
}

function cancelCreate() {
  router.push({ name: 'BoardList' });
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

.create-form {
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
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s;
}

.btn-primary {
  background-color: #007bff;
  color: #fff;
}

.btn-primary:hover {
  background-color: #0056b3;
}

.btn-secondary {
  background-color: #6c757d;
  color: #fff;
}

.btn-secondary:hover {
  background-color: #5a6268;
}
</style>
