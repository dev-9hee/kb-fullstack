CREATE
DATABASE user_ex; -- 데이터베이스 생성
USE
user_ex; -- 디폴트 데이터베이스 설정

CREATE TABLE users
(                                            -- users 테이블 생성
    id       INT AUTO_INCREMENT PRIMARY KEY, -- 숫자, 자동 생성 및 자동 숫자 증가, 기본 키
    email    VARCHAR(100) UNIQUE NOT NULL,   -- 최대 100자의 문자, 종복 허용 안 함, 필수 값
    password VARCHAR(100)        NOT NULL    -- 최대 100자의 문자, 필수 값
);
SELECT *
FROM users;

-- 회원 데이터 추가, id 값은 자동으로 생성되므로 전달 필요 없음
INSERT INTO users(email, password)
VALUES ('tetz', '1234'),
       ('siwan', '1234'),
       ('na', '1234');
SELECT *
FROM users;