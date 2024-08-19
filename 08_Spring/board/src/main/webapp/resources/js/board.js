// 삭제 버튼의 click 이벤트 핸들러
document.querySelector('.delete').onclick = function() {
    if(!confirm('정말 삭제할까요?')) return;
    document.getElementById('deleteForm').submit();
}