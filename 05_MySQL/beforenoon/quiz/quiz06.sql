# 첫번째 장
-- 현재 서버에 존재하는 데이터베이스 확인
SHOW DATABASES;
-- 현재 데이터베이스를 employees로 설정하기
USE employees;
-- employees 데이터베이스의 테이블 목록 보기
SHOW TABLES;
-- employees 테이블의 열 목록 출력하기
DESCRIBE employees;
DESC employees;
SHOW COLUMNS FROM employees;

# 두번째 장
-- titles 테이블의 데이터 출력하기
SELECT * FROM titles;
-- employees 테이블에서 first_name 컬럼만 출력하기
SELECT first_name FROM employees;
-- employees 테이블에서 first_name 컬럼, last_name 컬럼, gender 컬럼 출력하기
SELECT first_name, last_name, gender FROM employees;

# 세번째 장
-- employees 테이블 출력시 다음과 같이 나오도록 => 컬럼명 변경, 별칭 사용
SELECT first_name AS 이름, gender AS 성별, hire_date '회사 입사일' FROM employees;

# 네번째 장, 다섯번째 장
-- 배포된 sqldb.sql 파일을 이용하서 sqldb 데이터베이스를 구축
USE sqldb; -- sqldb 데이터베이스를 디폴트로
-- usertbl 테이블에서 이름이 '김경호'인 행을 출력
SELECT * FROM usertbl
WHERE name = '김경호';
-- usertbl 테이블에서 생년이 1970 이상이고 키가 182 이상인 데이터를 출력
SELECT * FROM usertbl
WHERE birthYear >= 1970 AND height >= 182;

# 여섯번째 장
-- usertbl 테이블에서 키가 180~183 범위인 데이터 출력
SELECT * FROM usertbl
WHERE height BETWEEN 180 AND 183;
-- usertbl 테이블에서 주소가 '경남' 또는 '전남' 또는 '경북'인 데이터를 출력
SELECT * FROM usertbl
WHERE addr IN('경남', '전남', '경북');
-- usertbl 테이블에서 이름이 '김'으로 시작하는 데이터를 출력
SELECT * FROM usertbl
WHERE name LIKE '김%';

# 일곱번째 장
-- usertbl에서 김경호보다 큰 사람들의 이름과 키를 출력 => 서브쿼리 이용
SELECT name, height FROM usertbl
WHERE height >
	(SELECT height FROM usertbl
    WHERE name = '김경호');
    
# 여덞번째 장
-- usertbl을 mDate의 오름차순으로 정렬하여 출력
SELECT * FROM usertbl
ORDER BY mDate ASC;
-- usertbl을 mDate의 내림차순으로 정렬하여 출력
SELECT * FROM usertbl
ORDER BY mDate DESC;
-- usertbl을 height의 내림차순으로 정렬하고, 동률인 경우 name의 내림차순으로 정렬하여 출력
SELECT * FROM usertbl
ORDER BY height DESC, name DESC;

# 아홉번째 장
-- usertbl의 주소지를 중복없이 오름차순으로 정렬
SELECT DISTINCT addr FROM usertbl
ORDER BY addr ASC;
