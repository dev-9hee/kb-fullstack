import { createRouter, createWebHistory } from 'vue-router';
import BoardList from '@/components/BoardList.vue';
import BoardDetail from '@/components/BoardDetail.vue';
import BoardEdit from '@/components/BoardEdit.vue';
import BoardCreate from '@/components/BoardCreate.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'BoardList',
      component: BoardList,
    },
    {
      path: '/detail/:id',
      name: 'BoardDetail',
      component: BoardDetail,
    },
    {
      path: '/create/',
      name: 'BoardCreate',
      component: BoardCreate,
    },
    {
      path: '/edit/:id',
      name: 'BoardEdit',
      component: BoardEdit,
    },
  ],
});

export default router;
