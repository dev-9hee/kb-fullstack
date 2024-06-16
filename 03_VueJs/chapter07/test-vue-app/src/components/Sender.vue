<template>
  <div style="border: solid 1px gray; margin: 5px; padding: 5px">
    <h2>Sender</h2>
    <button @click="sendMessage">이벤트 발신</button>
  </div>
</template>
<script>
export default {
  name: 'Sender',
  methods: {
    sendMessage() {
      // this.emitter 인스턴스의 emit 메서드를 호출하여 이벤트를 발신하는 것
      // 'message': 이벤트 이름 , Date.now() + '에 발신된 메시지': 이벤트와 함께 전달되는 데이터
      this.emitter.emit('message', Date.now() + '에 발신된 메시지');
    },
  },
};
</script>
