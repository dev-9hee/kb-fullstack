import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import Login from '@/pages/Login.vue';
import Todo from '@/pages/Todo.vue';
import TodoMain from '@/pages/TodoMain.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
    },
    {
      path: '/todo',
      name: 'todo',
      component: Todo,
      // 인가받은 사용자만 true
      meta: { requiresAuth: true },
    },
    {
      path: '/todomain',
      name: 'todomain',
      component: TodoMain,
    },
  ],
});

// router가 정상적으로 실행되기 전에 얘를 꼭 실행해주세요...
// next : 기능 / 통과시킬거면 next 부름...
// matched() : 한번 더 비교
// some : 배열함수, 배열 안의 조건 중 하나라도 참이면 true
router.beforeEach((to, from, next) => {
  // to.matched[0].path === './todo'
  if (to.matched.some((item) => item.meta.requiresAuth)) {
    if (localStorage.getItem('auth') !== 'true') {
      alert('로그인이 필요합니다!');
      next({ name: 'login' });
    } else {
      // todo로 가세요!
      next();
    }
  } else {
    next();
  }
});

export default router;
