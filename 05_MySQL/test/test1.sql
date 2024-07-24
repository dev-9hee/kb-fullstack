# DML : SELECT(조회), INSERT(삽입), UPDATE(갱신), DELETE(삭제)

USE world;
SELECT * FROM city;

########## SELECT 구문 연습 ##########
# binary 함수 연습
-- 대소문자 구분없이 검색
SELECT * FROM city
WHERE Name = 'KABUL';
-- 대소문자 구분해서 검색
SELECT * FROM city
WHERE binary(Name) = "Kabul";

##### 별칭 사용 연습 #####
-- 별칭 사용해서 검색 출력
SELECT Name AS 이름, CountryCode AS 나라, Population AS 인구수
FROM city;
SELECT Name 이름, CountryCode 나라, Population 인구수
FROM city;
SELECT Name '이름', CountryCode '나라', Population '인구수'
FROM city;
-- 별칭에 공백이 있을 경우 '' 필수
SELECT Name '이름', CountryCode '나라', Population '인구 수'
FROM city;
SELECT Name '이름', CountryCode '나라', Population AS '인구 수'
FROM city;

##### 조건, 정렬 연습 #####
# 정렬에서 ORDER BY population DESC, id ASC 라면 인구수를 기준으로 내림차순 정렬하고 같은 값이 있을 때 id를 기준으로 오름차순

-- city 테이블에서 population이 200000 이상인 데이터를 population으로 내림차순 정렬하여 모든 항목 출력
SELECT * FROM city
WHERE population >= 200000
ORDER BY population DESC;

-- city 테이블에서 countrycode가 kor인 데이터를 population으로 내림차순 정렬하여 모든 항목 출력
SELECT * FROM city
WHERE CountryCode = 'kor'
ORDER BY population DESC;

###### 조건, and(이고, 이며 ...) / or(이거나, 또는 ...) #####

-- city 테이블에서 countrycode가 kor 이고 population이 300000 이상인 데이터를 population으로 내림차순 정렬하여
-- Name이랑 Population만 출력, 각각 별칭을 사용하여 지역, 인구수로 출력
SELECT Name 지역, population 인구수
FROM city
WHERE CountryCode = 'kor' AND population >= 300000
ORDER BY population DESC;

##### where 절 문법 #####
# 컬럼 like '패턴' 사용
-- city 테이블에서 countrycode가 kor 이고 district가 c로 시작하는 컬럼을 찾아 Name이랑 district, population이 각각 별칭으로 도시명, 지역, 인구수로 나오게 출력
SELECT name 도시명, district 지역, population 인구수
FROM city
WHERE countrycode='kor' AND district like 'c%'; -- 대소문자 구분 상관 없음
-- WHERE countrycode='kor' AND binary(district) like 'C%'; -- 대소문자 구분, 이 구문에서 c를 소문자로 쓸 경우 해당 조건에 맞는 값 없음
-- 컬럼 like '패턴' => 패턴 %c% : c가 들어간 모든 것 (%는 0개 이상 문자열 일치) ( _는 특정 위치의 한 개의 문자와 일치)
-- district LIKE 'c%' : 'c'로 시작하는 문자열
-- district LIKE '%c%' : 중간에 'c'가 포함된 문자열
-- district LIKE '_c%' : 두 번째 글자가 'c'인 문자열
-- district LIKE 'c_%' : 'c'로 시작하고 두 번째 글자가 있는 문자열
-- district LIKE 'c__%' : 'c'로 시작하고 세 번째 글자가 있는 문자열
-- district LIKE '%c' : 'c'로 끝나는 문자열
-- district LIKE '%c_' : 'c'가 마지막에서 두 번째 글자인 문자열
-- district NOT LIKE '%c%': c 문자가 포함되지 않은 모든 행을 반환

# 컬럼 between a and b
-- city 테이블에서 countrycode가 kor 이고 population 이 90000 보다 크거나 같고 120000 보다 작거나 같은 필드를
-- Name이랑 district, population이 각각 별칭으로 도시명, 지역, 인구수로 나오게 출력
SELECT name AS 도시명, district AS 지역, population AS '인구 수'
FROM city
WHERE countrycode = 'kor' AND population BETWEEN 90000 AND 120000;
-- WHERE countrycode = 'kor' AND 90000 <= population AND population <= 120000; -- 위랑 같은 뜻

# 컬럼 IN(값1, 값2, ...) : 포함된 경우 / 컬럼 NOT IN(값1, 값2, ...) : 포함되지 않은 경우
-- city 테이블에서 countrycode에 kor, nld가 포함된 레코드를 출력
-- 이때 countrycode는 국가, population은 인구 수 로 출력한다.
SELECT DISTINCT countrycode 국가, population '인구 수'
FROM city
WHERE countrycode IN ('kor', 'nld');
-- WHERE countrycode NOT IN ('kor', 'nld'); -- 포함되지 않은 경우

# 컬럼 IS NULL / 컬럼 IS NOT NULL
-- city 테이블에서 population 값이 빈 값이 아닌 경우 name이랑 district, population이 각각 별칭으로 도시명, 지역, 인구수로 나오게 출력
-- but, city 테이블에는 인구수가 null 값인 경우는 없어서 전부 다 출력되는게 맞음..! IS NULL 일 때는 하나도 출력 안 됨
SELECT name 도시명, district 지역, population 인구수
FROM city
WHERE population IS NOT NULL; -- population 값이 빈 값이 아닌 경우
-- WHERE population IS NULL; -- population 값이 빈 값인 경우

# 조건1 AND 조건2 / 조건1 OR 조건2 / NOT 조건 ( 조건에 해당 X)
# 조건, and(이고, 이며 ...) / or(이거나, 또는 ...)
-- city 테이블에서 countrycode가 kor 이고 population이 300000 이상인 데이터를 population으로 내림차순 정렬하여
-- Name이랑 Population만 출력, 각각 별칭을 사용하여 지역, 인구수로 출력
SELECT Name 지역, population 인구수
FROM city
WHERE CountryCode = 'kor' AND population >= 300000
ORDER BY population DESC;

-- city 테이블에서 countrycode가 kor 이거나 district 가 buenos aires 인 레코드를 id 로 내림차순 정렬하여 출력
-- id는 번호로 Name이랑 Population은 각각 별칭을 사용하여 지역, 인구수로 출력
SELECT id 번호, name 지역, population 인구수
FROM city
WHERE countrycode = 'kor' OR district = 'buenos aires'
ORDER BY id DESC;

-- city 테이블에서 countrycode가 kor이 아닌 레코드를 id 로 내림차순 정렬하여 출력
-- id는 번호로 countrycode랑 Population은 각각 별칭을 사용하여 국가, 인구수로 출력
SELECT id 번호, countrycode 국가, population 인구수
FROM city
WHERE NOT countrycode = 'kor'
ORDER BY id DESC;

##### 서브쿼리 연습 #####
-- city 테이블을 사용하여 우리나라에서 제주의 인구수보다 작은 도시를 찾아 인구수를 내림차순으로 Name이랑 population 출력
-- Name이랑 population이 각각 별칭으로 도시명, 인구수로 나오게 출력
SELECT name 도시명, population 인구수
FROM city
WHERE
countrycode = 'kor'
AND
population < (
	SELECT population
    FROM city
	WHERE name = 'Cheju'
    )
ORDER BY population DESC;

-- city 테이블을 사용하여 우리나라에서 ID가 2358인 인구수보다 작은 도시를 찾아 인구수를 내림차순으로 Name이랑 population 출력
-- Name이랑 population이 각각 별칭으로 도시명, 인구수로 나오게 출력
SELECT name AS 도시명, population AS 인구수
FROM city
WHERE 
countrycode = 'kor' AND
Population < (
SELECT population
FROM city
WHERE id = '2358')
ORDER BY population DESC;

-- 서브쿼리의 결과가 둘 이상이 되면 에러 발생
-- 이때 ANY, SOME(서브쿼리의 여러 개의 결과 중 한 가지만 만족해도 가능), '= ANY(서브쿼리' 는 'IN(서브쿼리)' 와 동일 의미
-- ALL ( 서브쿼리의 결과 중 여러 개의 결과를 모두 만족해야 함 ) / 예시로 height > ALL(서브쿼리) : 서브쿼리를 만족하는 모든 결과보다 키가 커야 함

-- city 테이블에서 인구수(population)가 countrycode 가 kor 인 모든 도시의 인구수(population)보다 큰 레코드를 출력
-- name은 도시명으로 population은 인구수로 나오게 별칭 사용해서 출력
SELECT name 도시명, population 인구수
FROM city
WHERE population > ALL (SELECT population FROM city WHERE countrycode = 'KOR'); -- ALL 안 하면 에러 남!

-- city 테이블에서 인구수(population)가 countrycode 가 kor 인 어떤 도시의 인구수(population)보다 큰 레코드를 출력
-- name은 도시명으로 population은 인구수로 나오게 별칭 사용해서 출력
SELECT name 도시명, population 인구수
FROM city
WHERE population > ANY (SELECT population FROM city WHERE countrycode = 'KOR');
-- WHERE population > SOME (SELECT population FROM city WHERE countrycode = 'KOR'); -- 같음

-- city 테이블에서 인구수(population)가 countrycode 가 nld 이거나 district(지역)이 noord-holland 인
-- 어떤 도시의 인구수(population)랑 같은 레코드를 출력
-- name 필드는 도시명으로, population은 인구수로, district는 지역으로 출력
SELECT name 도시명, population 인구수, district 지역
FROM city
WHERE population = ANY (SELECT population FROM city WHERE countrycode = 'nld' OR district = 'noord-holland');

##### GROUP BY, HAVING ##### ~별 : 그룹핑 하라
# HAVING 은 그룹에 대한 조건
-- city 테이블에서 countrycode 가 kor, nld 인 국가별 최대 인구수를 출력
-- countrycode랑 최대 인구수 출력, countrycode는 별칭 사용해서 국가로 출력
-- SELECT countrycode AS 국가, ROUND(AVG(population)) AS '평균 인구 수'
SELECT countrycode AS 국가, MAX(population) AS '최대 인구 수'
FROM city
WHERE countrycode IN ('KOR', 'NLD')
-- WHERE countrycode = 'kor' OR countrycode = 'nld' -- 같은 거임
GROUP BY countrycode;

-- city 테이블을 사용해서 인구 합계가 1억 이상인 국가별 총 인구수 출력
-- 총 인구수로 내림차순 정렬하고 표시함 필드는 countrycode와 총 인구수
-- countrycode 는 국가로 출력하고 총 인구수도 별칭으로 출력
SELECT countrycode AS 국가, sum(population) AS '총 인구수' 
FROM city
GROUP BY countrycode
HAVING sum(population) > 100000000 -- 인구 합계가 1억 이상인거
ORDER BY sum(population) desc; -- 집계함수를 그대로 표현 해줘야 함
-- 다른 풀이 법
SELECT countrycode AS 국가, sum(population) AS t
FROM city
GROUP BY countrycode WITH ROLLUP -- 총합 또는 중간 합계가 필요한 경우
HAVING t > 100000000 -- 인구 합계가 1억 이상인거
ORDER BY t desc; -- 집계함수를 그대로 표현 해줘야 함

##### 집계함수 #####
# GROUP BY 절 집계함수와 함께 사용 => 효율적인 데이터 그룹화
# AVG() : 평균 / MIN() : 최소값 / MAX() : 최대값 / COUNT() : 행의 개수, NULL 값 제외하고 카운트 / COUNT(DISTINCT) : 행의 개수, 중복은 1개만 인정
# COUNT(*) : 행의 개수, NULL 값 포함하여 전부 카운트, STDEV() : 표준편차 / VAR_SAMP() : 분산 
# 상황에 맞게 쓸줄만 알면 될 것 같음

##### 참고 #####
create table kor_city
(select id, name, district, population from city
where countrycode = 'kor');
select * from kor_city;

##### LIMIT : 출력 개수를 제한 #####
-- 출력하는 개수를 제한하는 LIMIT
USE employees;
SELECT emp_no, hire_date FROM employees
ORDER BY hire_date ASC
LIMIT 5;
-- 페이지네이션 => LIMIT 시작, 개수
SELECT emp_no, hire_date FROM employees
ORDER BY hire_date ASC
LIMIT 0, 5; -- LIMIT 5 OFFSET 0과 동일
