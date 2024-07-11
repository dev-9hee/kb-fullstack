DROP DATABASE tabledb;
CREATE DATABASE tabledb;
USE tabledb;
-- IF EXISTS : 이 옵션은 지정된 테이블이 존재하지 않을 때 발생할 수 있는 오류를 방지
DROP TABLE IF EXISTS usertbl; -- usertbl 이라는 테이블이 존재하는 경우 해당 테이블을 삭제
-- usertbl 테이블 생성
CREATE TABLE usertbl(
	userID		CHAR(8) NOT NULL PRIMARY KEY, -- 길이 8의 문자열, 빈값 허용 안 함, 기본키로 설정(각 행을 고유하게 식별)
    name		VARCHAR(10) NOT NULL, -- 최대 10자의 가변 길이 문자열, 빈값 허용 안 함
    birthYear	INT NOT NULL, -- 정수형
    addr		CHAR(2) NOT NULL, -- 빈 값 허용 안 함
    mobile1		CHAR(3) NULL, -- 빈 값 허용
    mobile2		CHAR(8) NULL, -- 빈 값 허용
    height		SMALLINT NULL, -- 작은 정수형, 빈 값 허용
    mDate		DATE NULL -- DATE 타입, 빈 값 허용
);
-- buytbl 테이블 생성
DROP TABLE IF EXISTS buytbl; -- buytbl 이라는 테이블이 존재하는 경우 해당 테이블을 삭제
CREATE TABLE buytbl(
	num			INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    userID		CHAR(8) NOT NULL,
    prodName	CHAR(6) NOT NULL,
    groupName	CHAR(4) NULL,
    price		INT NOT NULL,
    amount		SMALLINT NOT NULL,
    FOREIGN KEY(userid) REFERENCES usertbl(userID)
);
-- 회원 테이블 데이터 입력
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-8-8'),
	('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4'),
    ('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');
-- 구매 테이블 데이터 입력
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2),
	(NULL, 'KBS', '노트북', '전자', 1000, 1);
    -- (NULL, 'JYP', '모니터', '전자', 200, 1) -- usertbl의 userID를 참조하고 있는데 usertbl에 없는 userID를 작성함, 에러 발생
