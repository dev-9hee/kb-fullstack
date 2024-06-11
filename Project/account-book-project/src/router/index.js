import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import HistoryPage from '@/views/HistoryPage.vue';
import AddContent from '@/views/AddContent.vue';
import SummaryPage from '@/views/SummaryPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/history',
      name: 'historypage',
      component: HistoryPage,
    },

    {
      path: '/content',
      name: 'addcontent',
      component: AddContent,
    },

    {
      path: '/summary',
      name: 'summarypage',
      component: SummaryPage,
    },
  ],
});

export default router;
