use world;

SELECT *
FROM city;
SELECT *
FROM country;



# CRUD
# CREATE
INSERT INTO `city` (Name, CountryCode, District, Population)
VALUES ('TETZ', 'KOR', 'TETZ', 1);

SELECT *
FROM city
WHERE Name = 'TETZ';

# UPDATE
UPDATE `city`
SET Population= 0
WHERE Name = 'TETZ';


# DELETE
DELETE
FROM city
WHERE NAME = 'TETZ';


# 정렬 (오름차순)
SELECT Name, CountryCode, Population
FROM city
ORDER BY Population ASC;


# 정렬 (내림차순)
SELECT Name, CountryCode, Population
FROM city
ORDER BY Population DESC;


# 함수
SELECT *
FROM country;
-- NULL > 독립연도없음으로 넣어라
SELECT Name, IFNULL(IndepYear, "독립 연도 없음")
FROM country;

-- 대문자를 소문자로 변경
SELECT LOWER(Code)
FROM country;

-- 소문자를 대문자로 변경
SELECT UPPER(Code)
FROM country;

-- 이름을 대문자나라로 변경
SELECT UPPER(Name) AS '대문자나라'
FROM country;

-- 데이터 보기 힘들 때 / 추가
SELECT *
FROM city;
SELECT CONCAT(ID, "/", Name, "/", Population)
FROM city;

SELECT *
FROM city;
SELECT CONCAT_WS("/", ID, Name, Population)
FROM city;

-- 아시아라고 나오면 아시아당으로 변경
SELECT *
FROM country;
SELECT REPLACE(Continent, 'Asia', '아시아당')
FROM country;

-- 숫자 관련 소수점 버리기
-- CEILING >  소수점 올림
SELECT Name, CEILING(LifeExpectancy)
FROM country;

-- FLOOR > 소수점 버림
SELECT Name, FLOOR(LifeExpectancy)
FROM country;

-- ROUND> 소수점 반올림
SELECT Name, ROUND(LifeExpectancy)
FROM country;

-- 날짜 이름의 길이
SELECT Name, LENGTH(Name)
FROM country;

-- 가장 큰 값 검색
SELECT MAX(city.Population)
FROM city;
-- 가장 작은 값 검색
SELECT MIN(city.Population)
FROM city;
-- 전체 테이블 평균 값
SELECT AVG(city.Population)
FROM city;

-- city 테이블에서 각 나라의 총 인구를 계산
SELECT CountryCode, SUM(Population)
FROM city
GROUP BY CountryCode;


#JOIN
SELECT co.Code, ci.Name, co.Name
FROM city ci
         INNER JOIN country co ON ci.CountryCode = co.Code;

-- 언어가 없는 사람은 null 값이 나와야하고
SELECT *
FROM countrylanguage;
SELECT co.Code, co.Name, cl.Language
FROM country co
         LEFT JOIN countrylanguage cl
                   ON co.Code = cl.CountryCode;


#JOIN 함수
-- city 테이블과 country 테이블을 조인하여 각 국가의 총 도시 인구를 계산
SELECT ci.CountryCode, co.Name, SUM(ci.Population)
FROM city ci
         INNER JOIN country co
                    ON ci.CountryCode = co.Code
GROUP BY ci.CountryCode;

-- city 테이블과 country 테이블을 조인하여 각 국가의 평균 도시 인구를 계산
SELECT ci.CountryCode, co.Name, AVG(ci.Population)
FROM city ci
         INNER JOIN country co
                    ON ci.CountryCode = co.Code
GROUP BY ci.CountryCode;

--  'Amsterdam' 도시의 인구 수보다 인구가 많은 모든 도시의 데이터 포함하는 테이블
-- 반환되는 데이터는 city 테이블의 모든 열을 포함하며, 조건에 맞는 행만 포함
SELECT *
FROM city;

SELECT *
FROM city
WHERE Population > (SELECT Population FROM city WHERE Name = 'Amsterdam');