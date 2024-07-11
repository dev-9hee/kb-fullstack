-- DB 생성, mydb 스키마 생성
CREATE SCHEMA `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE mydb; -- 이렇게 써도 되고 옆에 SCHEMAS에서 데이터베이스 더블 클릭

-- 테이블 생성
CREATE TABLE user (
	`id_pk` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- PRIMARY KEY : 중복 불가, 빈 값 불가 / AUTO_INCREMENT : 숫자 1씩 자동증가, 실패해도 1 증가
    `name` VARCHAR(10) NOT NULL, -- NOT NULL : 빈 값 입력 불가
    `user_id` VARCHAR(10) NOT NULL UNIQUE, -- UNIQUE : 중복 입력 불가
    `password` VARCHAR(10) NOT NULL,
    `age` TINYINT UNSIGNED, -- TINYINT : 작은 정수형 데이터 타입 (1바이트) / UNSIGNED : (숫자일시) 양수만 가능
    `membership` TINYINT DEFAULT 0, -- 기본값 0
    `register_date` DATETIME DEFAULT CURRENT_TIMESTAMP, -- DATETIME : 날짜와 시간 데이터 타입 / DEFAULT CURRENT_TIMESTAMP : 기본값은 현재 시간
    `update_date` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 업데이트가 될 때 현재시간을 기록시켜라'
    -- ON UPDATE CURRENT_TIMESTAMP : 행이 업데이트될 때 현재 시간으로 자동 업데이트
);

-- 생성한 TABLE에 DATA 삽입!
INSERT INTO user (name, user_id, password, age)
	VALUES ('정지희', 'jihee2', '1234', 25);
    
-- 데이터 삭제..!
DELETE FROM user WHERE id_pk = 4;

-- 데이터 수정..!
UPDATE user SET age = age + 1 WHERE id_pk = 1;