<template lang="">
  <div style="border: solid 1px gray; margin: 5px; padding: 5px">
    <h2>Receiver</h2>
    <hr />
    <h3>전송된 텍스트: {{ textMessage }}</h3>
  </div>
</template>

<script>
export default {
  name: 'Receiver',
  // 이 메서드는 컴포넌트가 생성되고 초기화된 직후에 호출
  created() {
    // Mitt 라이브러리를 사용하여 "message" 이벤트를 수신하는 부분, "message" 이벤트를 수신하는 코드
    // 'message': 이벤트 이름, "message" 이벤트를 수신하겠다는 의미
    // 이벤트가 발생했을 때 실행될 콜백 함수, 이 경우 this.receiveHandler라는 메서드가 콜백 함수로 사용
    // 즉, 이 코드는 "message" 이벤트가 발생하면 this.receiveHandler 메서드가 실행되도록 등록하는 것
    this.emitter.on('message', this.receiveHandler);
  },
  data() {
    return {
      textMessage: '',
    };
  },
  methods: {
    receiveHandler(msg) {
      this.textMessage = msg;
    },
  },
};
</script>
