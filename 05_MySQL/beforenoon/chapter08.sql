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
/* 외래 키 생성방법2
ALTER TABLE buytbl (
	num			INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    userID		CHAR(8) NOT NULL,
    prodName	CHAR(6) NOT NULL,
);
*/
-- 회원 테이블 데이터 입력
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-8-8'),
	('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4'),
    ('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');
-- 구매 테이블 데이터 입력
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2),
	(NULL, 'KBS', '노트북', '전자', 1000, 1);
    -- (NULL, 'JYP', '모니터', '전자', 200, 1) -- usertbl의 userID를 참조하고 있는데 usertbl에 없는 userID를 작성함, 에러 발생
-- 기본 키 제약 조건 - 복합키
DROP TABLE IF EXISTS prodTbl;
CREATE TABLE prodTbl(
    prodCode	CHAR(3) NOT NULL,
    prodID		CHAR(4) NOT NULL,
    prodDate	DATETIME NOT NULL,
    prodCur		CHAR(10) NULL,
    CONSTRAINT PK_prodTbl_prodCode_prodID PRIMARY KEY (prodCode, prodID)
    -- CONSTRAINT: 테이블에 대한 제약 조건을 정의할 때 사용하는 키워드
    -- PK_prodTbl_prodCode_prodID: 기본 키 제약 조건의 이름 => 테이블을 관리하거나 변경할 때 유용
	-- PRIMARY KEY: 기본 키 제약 조건을 정의
	-- (prodCode, prodID): 기본 키로 사용할 열을 지정
);
SHOW INDEX FROM prodTbl;
/*
-- default문은 DEFAULT로 설정된 값을 자동 입력
INSERT INTO usertbl VALUES ('LHL', '이해리', default, default, '011', '1234567', default, '2023.12.12');
-- 열 이름이 명시되지 않으면 DEFAULT로 설정된 값을 자동 입력
INSERT INTO usertbl(userID, name) VALUES ('KAY', '김아영');
-- 값이 직접 명기되면  DEFAULT로 설정된 값은 무시됨
INSERT INTO usertbl VALUES ('WB', '원빈', 1982, '대전', '019', '9876543', 176, '2020.5.5');
SELECT * FROM usertbl;
*/
-- 열의 추가
ALTER TABLE usertbl
ADD homepage VARCHAR(30) -- 열추가
DEFAULT 'http://www.hanbit.co.kr' -- 디폴트 값 
NULL; -- NULL 허용함
-- 열의 삭제
ALTER TABLE usertbl
DROP COLUMN mobile1;
SELECT * FROM usertbl;
-- 열의 이름 및 데이터 형식 변경
ALTER TABLE usertbl 
CHANGE COLUMN name uName VARCHAR(20) NULL;
-- 열의 제약 조건 추가 및 삭제
ALTER TABLE usertbl DROP PRIMARY KEY; -- 오류 발생