// 기능별로 라우팅 설정을 모듈화 - 기본 라우팅
import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';
import authRotes from './auth';
import boardRotes from './board';
import travelRoutes from './travel';
import galleryRoutes from './gallery';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    ...authRotes,
    ...boardRotes,
    ...travelRoutes,
    ...galleryRoutes,
  ],
});

export default router;
