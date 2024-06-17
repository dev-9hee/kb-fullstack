import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  // 프록시 서버를 구성
  // 매번 긴 주소를 쓰기 귀찮으므로 /api라고 설정
  // /api 라고 주소를 호출하면 자동으로 http://localhost:3000 호출
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:3000/',
        changeOrigin: true, // 프록시 서버가 클라이언트의 오리진(origin)을 변경
        rewrite: (path) => path.replace(/^\/api/, ''), // 'rewrite' 옵션은 요청 경로에서 '/api' 부분을 제거, 실제 API 서버에는 '/api' 없이 요청이 전달
      },
    },
  },
});
