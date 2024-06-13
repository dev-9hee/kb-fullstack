import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/1',
      name: '권오현',
      component: () => import('@/pages/01_OH.vue'),
    },
    {
      path: '/2',
      name: '정지희',
      component: () => import('@/pages/02_JEONG.vue'),
    },
    {
      path: '/3',
      name: '최규찬',
      component: () => import('@/pages/03_CHOI.vue'),
    },
    {
      path: '/4',
      name: '최호진',
      component: () => import('@/pages/04_CHOI.vue'),
    },
  ],
});

export default router;
