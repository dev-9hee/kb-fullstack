USE sqldb;

-- 첫 번째 실습, 문제1
CREATE TABLE tbl1 (
	a INT PRIMARY KEY, -- 클러스터형 인덱스 자동 생성 
    b INT,
    c INT
);

SHOW INDEX FROM tbl1;

-- 두 번째 실습, 문제2
CREATE TABLE tbl2 (
	a INT PRIMARY KEY, -- 클러스터형 인덱스 자동 생성 
    b INT UNIQUE, -- 보조 인덱스 자동 생성
    c INT UNIQUE, -- 보조 인덱스 자동 생성
    d INT
);
SHOW INDEX FROM tbl2;

-- 세 번째 실습, 문제3
CREATE TABLE tbl3 (
	a INT UNIQUE, -- 보조 인덱스 자동 생성
    b INT UNIQUE, -- 보조 인덱스 자동 생성
    c INT UNIQUE, -- 보조 인덱스 자동 생성
    d INT
);
SHOW INDEX FROM tbl3;

-- 네 번째 실습, 문제4
CREATE TABLE tbl4 (
	a INT UNIQUE NOT NULL, -- 클러스터형 인덱스로 생성
    b INT UNIQUE, -- 보조 인덱스 자동 생성
    c INT UNIQUE, -- 보조 인덱스 자동 생성
    d INT
);
SHOW INDEX FROM tbl4;

-- 다섯번째 실습, 문제5
CREATE TABLE tbl5 (
	a INT UNIQUE NOT NULL, -- 클러스터형 인덱스로 생성
    b INT UNIQUE, -- 보조 인덱스 자동 생성
    c INT UNIQUE, -- 보조 인덱스 자동 생성
    d INT PRIMARY KEY -- 클러스터형 인덱스 자동 생성 
);
SHOW INDEX FROM tbl5;

-- 문제6
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;
-- 테이블 생성
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl (
	userID		CHAR(8) NOT NULL PRIMARY KEY,
    name		VARCHAR(10) NOT NULL,
    birthYear	INT NOT NULL,
    addr 		NCHAR(2) NOT NULL
);

-- 문제7
-- 데이터 추가
INSERT INTO usertbl(userID, name, birthYear, addr)
VALUES('LSG', '이승기', 1987, '서울'),
		('KBS', '김범수', 1979, '경남'),
        ('KKH', '김경호', 1971, '전남'),
        ('JYP', '조용필', 1950, '경기'),
        ('S나', '성시경', 1979, '서울');
SELECT * FROM usertbl;
SHOW INDEX FROM usertbl; -- 클러스터형 인덱스의 테이블 내용을 확인

-- 문제8
-- ALTER를 사용하여 usertbl에서 PRIMARY KEY 제약조건을 제거하고, name 컬럼에 pk_name 이라는 제약조건명으로 기본키를 설정
ALTER TABLE usertbl DROP PRIMARY KEY; -- PRIMARY KEY 제약조건을 제거
ALTER TABLE usertbl
ADD CONSTRAINT pk_name PRIMARY KEY(name);

-- 문제9
-- usertbl의 내용을 출력하여, 새로운 클러스터형 인덱스를 확인
SELECT * FROM usertbl;
SHOW INDEX FROM usertbl;

-- 추가 실습...
USE sqldb;
SELECT * FROM usertbl;
SHOW INDEX FROM usertbl; -- 자동 생성된 인덱스 보기

-- 인덱스의 크기 확인
SHOW TABLE STATUS LIKE 'usertbl';

-- addr 컬럼에 인덱스 만들기 
CREATE INDEX idx_usertbl_addr -- 인덱스 이름 : idx_usertbl_addr, 인덱스 생성
ON usertbl(addr); -- usertbl에 addr 컬럼에
SHOW INDEX FROM usertbl; -- 인데스 보기

-- 인덱스 크기 확인
SHOW TABLE STATUS LIKE 'usertbl'; -- Index_length 가 0
-- 생성한 인덱스를 실제 사용하려면 ANALYZE TABLE 문으로 먼저 테이블을 분석/처리 해줘야 함
ANALYZE TABLE usertbl;
SHOW TABLE STATUS LIKE 'usertbl';

-- 출생년도(birthYear)에 보조 인덱스 생성, 중복값이 있어 인덱스 생성 에러 발생
CREATE UNIQUE INDEX idx_usertbl_birthYear
ON usertbl(birthYear);
-- 이름(name)에 보조 인덱스 생성
CREATE UNIQUE INDEX idx_usertbl_name
ON usertbl(name);
SHOW INDEX FROM usertbl;

-- 이름(name)에 보조 인덱스 삭제
DROP INDEX idx_usertbl_name ON usertbl;

-- name, birthYear 조합으로 보조 인덱스 생성
CREATE UNIQUE INDEX idx_usertbl_name_birthYear
ON usertbl(name, birthYear);
SHOW INDEX FROM usertbl;

-- 인덱스 삭제
SHOW INDEX FROM usertbl;

DROP INDEX idx_usertbl_addr ON usertbl;
DROP INDEX idx_usertbl_name_birthYear ON usertbl;
-- OR
ALTER TABLE usertbl DROP INDEX idx_usertbl_addr;
ALTER TABLE usertbl DROP INDEX idx_usertbl_name_birthYear;