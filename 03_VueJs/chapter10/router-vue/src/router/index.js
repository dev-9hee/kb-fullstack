import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import Dynamic from '@/pages/Dynamic.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('@/pages/About.vue'),
    },
    {
      // dinamic 주소에 대한 파라미터 설정
      // mode라는 정보로 받겠다!
      path: '/dynamic/:mood',
      name: 'dynamic',
      component: Dynamic,
      props: true,
    },
    {
      path: '/jihee',
      name: 'jihee',
      component: () => import('@/pages/Jihee.vue'),
    },
    {
      path: '/:pathMatch(.*)', // 이 주소로 어떤 값이 들어오면 *이라고 인식
      name: 'notFound',
      component: () => import('@/pages/NotFound.vue'),
    },
  ],
});

export default router;
