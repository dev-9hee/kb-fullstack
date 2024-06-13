import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import HistoryPage from '@/views/HistoryPage.vue';
import AddContent from '@/views/AddContent.vue';
import SummaryPage from '@/views/SummaryPage.vue';
import CalenderPage from '@/views/CalenderPage.vue';
import CategoryModal from '@/views/CategoryModal.vue';

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
      path: '/add',
      name: 'addcontent',
      component: AddContent,
    },

    {
      path: '/summary',
      name: 'summarypage',
      component: SummaryPage,
    },
    {
      path: '/category',
      name: 'categoryModal',
      component: CategoryModal,
    },
    {
      path: '/calendar',
      name: 'CalenderPage',
      component: CalenderPage,
    },
  ],
});

export default router;
