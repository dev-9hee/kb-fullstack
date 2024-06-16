<!-- todo 입력 컴포넌트 -->
<template>
  <div>
    <input type="text" v-model.trim="todo" placeholder="할 일을 여기에 입력!" />
    <!-- 버튼 클릭 시 상위 컴포넌트에게 'addTodo' 이벤트를 발생시키고, { todo }라는 데이터를 함께 전달하는 역할 -->
    <!-- 'addTodo'는 이벤트 이름, { todo }는 이벤트와 함께 전달되는 데이터 -->
    <!-- 데이터는 꼭 객체로 보냄 -->
    <button @click="$emit('addTodo', { todo }), reset()">추가</button>
  </div>
</template>

<script>
export default {
  name: 'InputTodo',
  data() {
    return {
      todo: '', // input으로 받은 데이터를 씀
    };
  },
  methods: {
    reset() {
      this.todo = '';
    },
  },
};
</script>
