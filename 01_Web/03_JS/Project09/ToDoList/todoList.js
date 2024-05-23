const workInput = document.getElementById('work');
const workAddBtn = document.getElementById('add-btn');
const todoList = document.querySelector('#todolist');

workAddBtn.addEventListener('click', function () {
  const todoli = document.createElement('li'); // li 요소 생성

  // setAttribute() : HTML요소에 속성값 할당
  workInput.setAttribute('placeholder', ''); // placeholder 속성(힌트표시)을 공백으로 설정
  if (workInput.value === '') {
    return workInput.setAttribute('placeholder', '내용을 입력하세요!');
  }

  const checkBtn = document.createElement('input'); // input 요소 생성
  checkBtn.setAttribute('type', 'checkbox');

  checkBtn.addEventListener('click', function () {
    if (checkBtn.checked === true) {
      // checkBtn.style.textDecoration = 'line-through'; 했을 때 적용 안 됨.
      // 보통 취소선은 텍스트에 적용, 텍스트를 포함하는 부모 요소나 해당 항목에 취소선을 적용하는 것이 일반적
      checkBtn.parentNode.style.textDecoration = 'line-through';
    } else {
      checkBtn.parentNode.style.textDecoration = 'none';
    }
  });

  const delBtn = document.createElement('input');

  delBtn.setAttribute('type', 'button');
  delBtn.setAttribute('value', '삭제');
  delBtn.addEventListener('click', function () {
    // delBtn.remove(); 했을 때 버튼만 삭제 됨..
    delBtn.parentNode.remove();
  });

  todoli.append(checkBtn);
  todoli.append(workInput.value);
  todoli.append(delBtn);

  todoList.appendChild(todoli);

  workInput.value = ''; // 입력칸 텍스트 초기화
});
