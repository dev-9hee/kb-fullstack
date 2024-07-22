CREATE DATABASE user_ex; -- 데이터베이스 생성
USE user_ex; -- 디폴트 데이터베이스 설정

CREATE TABLE users ( -- users 테이블 생성
	id INT AUTO_INCREMENT PRIMARY KEY, -- 숫자, 자동 생성 및 자동 숫자 증가, 기본 키
    email VARCHAR(100) UNIQUE NOT NULL, -- 최대 100자의 문자, 종복 허용 안 함, 필수 값
    password VARCHAR(100) NOT NULL -- 최대 100자의 문자, 필수 값
);
SELECT * FROM users;

-- 회원 데이터 추가, id 값은 자동으로 생성되므로 전달 필요 없음
INSERT INTO users(email, password) VALUES('tetz', '1234'), ('siwan', '1234'), ('na', '1234');
SELECT * FROM users;

# user_info 테이블 생성, 해당 테이블은 제2 정규형을 위배
# 해당 테이블은 user 테이블의 id를 외래키(FOREIGN KEY)로 가지며 회원 id를 가지고
# 회원의 이름을 알 수 있는 목적을 가지는 테이블
CREATE TABLE user_info (
	id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    # users 테이블의 id와 user_info 의 id  가 서로 참조하는 관계임을 외래키로 설정
    FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
);

# 데이터 삽입
INSERT INTO user_info (id, name) 
VALUES ('1', '이효석'),
		('2', '김시완'),
        ('3', '나건우');
										