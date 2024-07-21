use jdbc_ex; -- jdbc_ex 데이터베이스 기본으로 사용

CREATE TABLE todo_user -- 사용자 정보를 담고 있는 테이블 생성
(
    user_id    VARCHAR(50) PRIMARY KEY, -- user_id를 기본키로 설정(고유하게 식별), 문자열 데이터를 최대 50자까지 저장
    name       VARCHAR(50)  NOT NULL UNIQUE, -- 빈값이면 안되고, 유일한 값이여야 함(중복된 값 안 됨)
    password   VARCHAR(255) NOT NULL, -- 빈 값이면 안 됨
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 날짜와 시간을 저장하는 TIMESTAMP 데이터 타입, 행이 삽입될 때 현재 시간을 기본값으로 설정
);

SELECT * FROM todo_user;

INSERT INTO todo_user (user_id, name, password) -- 데이터 삽입, created_at 은 디폴트 값이 들어감
VALUES ('tetz', '이효석', '1234'),
       ('siwan', '김시완', '1234'),
       ('na', '나건우', '1234');


CREATE TABLE todo2 -- 투두 목록 테이블 생성
(
    id           INT AUTO_INCREMENT PRIMARY KEY, -- 정수형, 1부터 자동으로 1씩 증가, 기본키
    user_id      VARCHAR(50)  NOT NULL, -- 빈 값이면 안 됨
    todo         VARCHAR(255) NOT NULL, -- 빈 값이면 안 됨
    is_completed BOOLEAN   DEFAULT FALSE, -- 완료 여부, true or false, 디폴트 값 : false(미완료 상태)
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES todo_user (user_id) ON DELETE CASCADE
    -- todo2 테이블의 user_id 항목을 외래키로 설정, 이 키는 todo_user 테이블의 user_id를 참조하고 있으며,
    -- 참조된 테이블 (todo_user)의 행이 삭제될 때, 해당 외래 키를 가지고 있는 모든 행도 자동으로 삭제
);

INSERT INTO todo2 (user_id, todo) -- 데이터 삽입, 디폴트 값이 있는 항목은 빼고 데이터 추가
VALUES ('tetz', 'PPT 찍기'),
       ('tetz', '금요일에 쉬기 :)'),
       ('siwan', '다트 패자 부활전 우승 하기'),
       ('siwan', '강사님~'),
       ('na', '다트 우승하기'),
       ('na', 'RM 활동하기');

SELECT * FROM todo2;