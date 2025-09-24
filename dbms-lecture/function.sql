-- 함수 (오라클 내장 함수)

-- 1. 문자열관련 함수
SELECT ename, upper(ename) FROM emp; -- 대문자 출력
SELECT ename, lower(ename) FROM emp; -- 소문자 출력
SELECT ename, initcap(ename) FROM emp; -- 앞 문자만 대문자 

SELECT * FROM emp WHERE upper(ename) = upper('smith');

-- s로 시작하는 이름을 다 찾아보기
SELECT * FROM emp WHERE upper(ename) LIKE upper('s%');
-- s가 포함되어 있는 문자의 이름을 찾기
SELECT * FROM emp WHERE upper(ename) LIKE upper('%s%');


-- 2. length 길이
SELECT ename, length(ename) AS "이름 길이" FROM emp;

-- 이름이 5글자 이상인 사람
-- 주의점은 한글과 영어는 길이가 다름
SELECT ename, length(ename) AS "이름 길이" FROM emp WHERE length(ename) >= 5;
SELECT ename, length(ename) AS "이름 길이" FROM emp 
WHERE length(ename) >= 5 -- 조건절에는 alias(별칭)를 사용할 수 없다.
ORDER BY "이름 길이";	-- order by는 연산을 마치므로 alias를 사용할 수 있다.

-- dual이라는 가상테이블 : length는 문자열 길이, length : 바이트 길이
-- UTF-8 기준 : 전 세계 기준으로 쓰이는 포멧
-- Oracle에서 한글은 글자 당 3바이트씩 처리됨, 영어는 1바이트
SELECT LENGTH('한글'), lengthb('한글자씩') FROM dual;
SELECT LENGTH('ABC'), lengthb('ABC') FROM dual;

-- 3. substr(값, 시작 1부터, 끝) : 주의할 점은 1부터 시작
SELECT ename, substr(ename, 1, 2) me FROM emp;
SELECT ename, substr(ename, 1, 2)||'**' AS anonmy FROM emp; -- Oracle에서 별칭이나 익명성을 보장하기 위해 씀

SELECT ename, 
substr(ename, 1, 2)||'**' ,
substr(ename, 1)||'**',
substr(ename, 3)||'**',
substr(ename, -3, 2)		-- 음수는 뒤에서 부터 센다 뒤에서 3번째 인덱스 이후 2글자만 끊어서 데이터 출력
FROM emp; -- Oracle에서 별칭이나 익명성을 보장하기 위해 씀


-- oracle이란 글자에서 cl만 출력 음수 양수인 경우 출력
SELECT substr('oracle', 4, 2), substr('oracle', -3, 2) FROM dual;
-- quiz '9103040-1234567'
SELECT substr('910304-1234567', 1, 6) FROM dual; -- 생년 월일
-- 뒤의 자리부터 시작해서 출력
SELECT substr('01011112222', -4) FROM dual;		-- 전화번호 뒷자리


-- 4. instr(문자열, 찾을 문자열) : String에서 index 찾기
SELECT 
instr('HELLO ORACLE!', 'L') AS instr01,
-- 3번째 파라미터에는 지정한 인덱스 부터 찾기
instr('HELLO ORACLE!', 'L', 4) AS instr02,
instr('HELLO ORACLE!', 'L', 5) AS instr03,
-- 4번째 파라미터는 몇 번째 나오는 지를 출력 
instr('HELLO ORACLE!', 'L', 3, 1) AS instr04_01,
instr('HELLO ORACLE!', 'L', 3, 2) AS instr04_02,
instr('HELLO ORACLE!', 'L', 3, 3) AS instr04_03,
-- 뒤에서 부터 찾는 경우
instr('HELLO ORACLE!', 'L', -1) AS instr05_01,
instr('HELLO ORACLE!', 'L', -1, 2) AS instr05_02, -- 04_02와 같은 값 출력
instr('HELLO ORACLE!', 'X') AS instr06 -- 찾고자 하는 문자가 없는 경우 0을 반환한다.
FROM dual;

-- 서버에서 database또는 DATABASE가 넘어올지 모를 때 위치
-- quiz 'Oracle DataBase 21c Release'
SELECT INSTR(upper('Oracle DataBase 21c Release'), upper('database')) FROM dual;
SELECT INSTR(upper('Oracle DataBase 21c Release'), upper('DATABASE')) FROM dual;
SELECT INSTR(upper('Oracle DataBase 21c Release'), upper('DaTaBaSe')) FROM dual;

-- quiz 21c 버전 이상인지 확인
-- with라는 구문을 쓴다. -- 가상 테이블을 만들 때 사용
WITH temp AS ( -- temp라는 가상테이블이 나옴
	SELECT 'Oracle DataBase 21c Release' AS alias FROM dual
)
SELECT * FROM temp WHERE instr(alias, '21c') > 0;
-- with 구문은 테스트 할때 많이 사용

-- 이름중에 s가 포함되어 있으면 출력 like 쓰지 않고
WITH temp AS ( -- temp라는 가상테이블이 나옴
	SELECT * FROM emp
)
SELECT * FROM temp WHERE instr(ename, 'S') > 0; -- 가상 테이블로 만들면 pk가 없어짐


SELECT * FROM emp WHERE instr(ename, 'S') > 0; -- 원본 테이블에서 where로 찾으면 pk를 보유한 상태에서 데이터를 찾음

-- .pdf 확장자 출력 subquery를 사용해도 됨. (WITh를 사용하는 경우)
WITH temp AS ( -- temp라는 가상테이블이 나옴
	SELECT 'rerrer.sdasee.sadsa.rtrewe.pdf' AS filename FROM dual
)
SELECT substr(filename, instr(filename, '.', -1) + 1, 3) FROM temp; -- 가상 테이블로 만들면 pk가 없어짐

-- 쿼리 안의 쿼리를 재작성 하는것을 서브쿼리라고 한다
SELECT substr(filename, instr(filename, '.', -1) + 1, 3)
FROM (SELECT 'rerrer.sdasee.sadsa.rtrewe.pdf' AS filename FROM dual);

-- replace
SELECT 
'010-1111-1111' AS replace_before,
REPLACE('010-1111-1111', '-', '/') AS replace_after01,	-- 기호 대체
REPLACE('010-1111-1111', '-', ' ') AS replace_after02,	-- 공백 대체	
REPLACE('010-1111-1111', '-') AS replace_after03		-- 붙여서 적용
FROM dual;

--lpad rpad masking 
SELECT 'Oracle' AS original,
lpad('Oracle', 10, '#') AS lpad01,
rpad('Oracle', 10, '#') AS rpad01,
-- 아무것도 작성하지 않으면 공백이 채워짐
lpad('Oracle', 10) AS lpad02,
rpad('Oracle', 10) AS rpad02
FROM dual;

-- 250101-1234567 -> 250101-*******
SELECT rpad('250101-', 14, '*') FROM dual;

-- 
SELECT rpad('250101-1', 14, '*') FROM dual; -- 이게 아님 ;; 
SELECT rpad(substr('250101-1234567', 1, 8), LENGTH('250101-1234567'), '*') FROM dual;

SELECT ename FROM emp; -- 앞에 2글자를 뺀 나머지 글자를 마스킹
SELECT ename, rpad(substr(ename, 1, 2), LENGTH(ename), '*') AS maskname FROM emp;

-- concat 이어 붙이기
SELECT concat('oracle', 'db') FROM dual;-- 표준(ansi) 문자열 연결
SELECT 'oracle' || 'db' FROM dual; -- oracle 전용


-- s***h, a***n, w***d
-- rpad로 별 마스킹을 이름의 길이에서 -1 만큼만 마스킹 하고 나머지 이름의 끝자리에서 문자를 concat
SELECT ename, concat (rpad(substr(ename, 1, 1), LENGTH(ename) - 1, '*'), substr(ename, -1)) FROM EMP ;
SELECT ename, rpad(substr(ename, 1, 1), LENGTH(ename) - 1, '*') || substr(ename, -1) FROM EMP ; -- 비표준
SELECT ename, concat (rpad(substr(ename, 1, 2), LENGTH(ename) - 2, '*'), substr(ename, -2)) FROM EMP ;

-- trim
SELECT '  ___oracle___  ' AS original FROM dual;
SELECT '  ___oracle___  ' AS original,
trim(LEADING FROM'	___oracle___  ') AS trim01, -- 앞의 공백 자름  -- 표준
trim(TRAILING FROM'  ___oracle___  ') AS trim02, -- 뒤의 공백 자름
trim(BOTH FROM'  ___oracle___  ') AS trim03, -- 뒤의 공백 자름
ltrim('  ___oracle___  ') AS trim04, -- 뒤의 공백 자름 -- 표준 아님
rtrim('  ___oracle___  ') AS trim05, -- 뒤의 공백 자름
trim('  ___oracle___  ') AS trim06 -- 뒤의 공백 자름
FROM dual;

SELECT '000123000' AS original,
trim(LEADING '0' FROM '000123000') AS trim01,
trim(TRAILING '0' FROM '000123000') AS trim02,
trim(BOTH '0' FROM '000123000') AS trim03,
ltrim('000123000', '0') AS trim04,
rtrim('000123000', '0') AS trim05,
trim('000123000') AS trim06 -- 3번처럼 적용해야함
FROM dual;

-- quiz
--WITH temp AS (
--	SELECT * FROM emp
--)
--SELECT REPLACE(empno, ',') AS EMPNO, rpad(substr(empno, 1, 2), LENGTH(empno), '*') AS MASKING_EMPNO, 
--ename, rpad(substr(ename, 1, 1), LENGTH(ename), '*') AS MASKING_ENAME FROM temp 
--WHERE length(ename) >= 5 AND length(ename) < 6;

SELECT REPLACE(empno, ',') AS EMPNO, rpad(substr(empno, 1, 2), LENGTH(empno), '*') AS MASKING_EMPNO, 
ename, rpad(substr(ename, 1, 1), LENGTH(ename), '*') AS MASKING_ENAME FROM emp 
WHERE length(ename) >= 5 AND length(ename) < 6;
 


SELECT * FROM emp;