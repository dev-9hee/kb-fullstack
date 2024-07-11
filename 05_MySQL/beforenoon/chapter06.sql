USE employees;

SELECT * FROM employees
WHERE first_name = 'georgi'; -- 대소문자 구분하지 않고 동등성 비교 
-- WHERE binary(first_name) = 'georgi'; -- 대소문자 맞아야 되는 동등성 비교

SELECT first_name AS 이름, gender AS 성별, hire_date '회사 입사일'
FROM employees; -- 별칭을 각각 이름, 성별, 회사 입사일 로 설정 / 공백이 있으면 '' 필수

USE world;
SELECT * FROM city
WHERE countrycode = 'kor' -- countrycode가 kor
ORDER BY population DESC; -- population으로 내림차순 정렬

-- 우리나라에서 제주의 인구수보다 작은 도시를 찾아 인구수를 내림차순으로 도시명, 인구수를 출력
SELECT name AS 도시명, population AS 인구수
FROM city
WHERE 
countrycode = 'kor' AND
Population < (
SELECT population
FROM city
WHERE id = '2358')
ORDER BY population DESC;
-- WHERE contrycode = 'kor' AND district like 'c%';

USE employees;
CREATE TABLE users
(SELECT first_name AS name, gender FROM employees);

SELECT * FROM users;

-- world 데이터베이스
USE world;

select * from city
where countrycode = 'kor';

create table kor_city
(select id, name, district, population from city
where countrycode = 'kor');

select * from kor_city;

-- city 테이블을 사용해서, 국가별 총 인구수 출력 => ~별 : 그룹핑 하라
use world;
select countrycode, sum(population) as 인구수 
from city
group by countrycode
having sum(population) > 100000000 -- 인구 합계가 1억 이상인거
order by sum(population) desc; -- 집계함수를 그대로 표현 해줘야 함

-- 출력하는 개수를 제한하는 LIMIT
USE employees;
SELECT emp_no, hire_date FROM employees
ORDER BY hire_date ASC
LIMIT 5;
-- 페이지네이션
SELECT emp_no, hire_date FROM employees
ORDER BY hire_date ASC
LIMIT 0, 5; -- LIMIT 5 OFFSET 0과 동일