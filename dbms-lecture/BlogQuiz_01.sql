--1
SELECT ename, upper(ename) AS UpperName FROM emp;

--2
SELECT ename, lower(ename) AS lowername FROM emp;

--3
-- 첫 문자만 대문자 
SELECT ename, INITCAP(ename) AS initcap FROM emp;

--4
SELECT ename, substr(ename, 1, 2) AS modifyname FROM emp;

--5
SELECT ename, reverse(substr(ename, -2)) AS modifyname FROM emp;

--6
SELECT ename AS includeA FROM emp
WHERE ename LIKE '%A%';
-- 다른 방법 : instr을 사용하는 방법
SELECT * FROM emp WHERE instr(ename, 'A') > 0;

--7 
SELECT ename, REPLACE(ename, 'A', '*') FROM emp;

--8
-- 하나의 컬럼에는 같은 타입의 데이터가 나열된다.
SELECT empno, lpad(empno, 6, '0') AS empno_lpad FROM emp;

--9
SELECT ename, rpad(ename,10, '#') AS ename_rpad FROM emp;

-- 10
SELECT ename, lower(ename) AS lowername FROM emp
WHERE length(ename) >= 5;

--11
SELECT * FROM emp
WHERE ename LIKE '_A%';

SELECT * FROM emp
WHERE instr(ename, 'A', 2) = 2;

--12
SELECT ename, instr(ename, 'E') AS instr FROM  emp;

--13
SELECT * FROM emp
WHERE ename LIKE '%N';

SELECT ename, instr(ename, 'N', -1) FROM emp;

--14
SELECT ename, ltrim(rpad(ename, 10, '*')) AS modifyname FROM emp;

--15
WITH temp AS (
	SELECT ename, REPLACE(ename, 'A', '-') AS modifyname FROM emp
)
SELECT ename, replace(modifyname, 'E', '-') FROM temp;


SELECT ename, REPLACE(replace(ename, 'E', '-'), 'A', '-') FROM emp;

-- translate를 사용하는 방법 (Oracle 버전이 12c 이상일 때만 사용가능)
SELECT ename, translate(ename, 'AE', '--') FROM emp;

-- 16
SELECT empno, lpad(substr(to_char(empno), -2), 
LENGTH(to_char(empno)), '#') AS maskingempno FROM emp;

-- 17
SELECT ename, REVERSE(ename) FROM emp; -- 이건 안알랴줌, 책에는 없다.


-- 18
SELECT ename, REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(ename, 'A'), 'E'), 'I'),'O'),'U') AS modifyname FROM emp;
--SELECT ename, REPLACE(ename IN ('A', 'E', 'I', 'O', 'U')) AS modifyname FROM emp;
SELECT ename, regexp_replace(ename, '[AEIOU]', '') AS regexp_ename FROM emp; -- 개편리하네
SELECT ename, regexp_replace(ename, 'A|E|O|I|U', '') AS regexp_ename FROM emp; -- 다른방법도 있지만 한글자씩 찾을 때는 파이프보다는 []가 편함

-- regexp : 정규 표현식
SELECT 
regexp_replace('oracle database', 'oracle') AS regexp01,
regexp_replace('oracle database', 'database') AS regexp02,
regexp_replace('oracle database', 'sql') AS regexp03 
FROM dual;

SELECT 
regexp_replace('oracle database', 'oracle', 'mysql') AS regexp01,
regexp_replace('oracle database', 'database', 'db') AS regexp02,
regexp_replace('oracle database', 'sql', 'ddsdsds') AS regexp03   -- 찾는게 없으면 바뀌는게 없다.
FROM dual;

SELECT 
-- 1부터 시작해서 제한없이 replace한다라는 의미가 됨.
regexp_replace('oracle database', 'a', '*',1, 0) AS regexp01,  -- 전체적으로 바꾼다.
-- 만약 4번째 인자에 1이라는 값을 쓰면 첫번째만 바꾼다는 의미가 됨.
regexp_replace('oracle database', 'a', '*',1, 2) AS regexp01_1, 
regexp_replace('oracle datAbase', 'a', '*',1, 3) AS regexp01_2,	-- 대소문자 구분
regexp_replace('oracle datAbase', 'a', '*',1, 3, 'i') AS regexp01_3, 	-- 5번쨰 인자에 'i'를 넣으면 대문자를 소문자로 전환한다.(일치옵션)
regexp_replace('Oracle Database 21c', 'Oracle', '******') AS regexp01_4, 
regexp_replace('Oracle Database 21c', '[0-9]', '*') AS regexp01_5,	--숫자를 찾아서 바꾸기
regexp_replace('Oracle Database 21c', '[[:digit:]]', '*') AS regexp01_6, -- [[:didgit:]] 정규 표현식으로 숫자를 찾을 수 있음.
regexp_replace('Oracle Database 21c', '\d', '*') AS regexp01_7,
regexp_replace('Oracle Database 21c', '[A-z]', '*') AS regexp01_8 -- 모든 문자를 찾음[a-zA-z]
FROM dual;

select
regexp_replace('Oracle Database 21c', '[a-zA-z]', '*') AS regexp01_1, -- 모든 문자를 찾음[a-zA-z]
regexp_replace('Oracle Database 21c', '[[:alpha:]]', '*') AS regexp01_2 --[[:alpha:]] 키워드를 사용해서 문자만 찾을 수 있음
FROM dual;

--or 찾기
select
regexp_replace('Oracle Database 21c', 'Ora|base|21', '***') AS regexp01_1 -- 모든 문자를 찾음[a-zA-z]
FROM dual;

-- 한글 치환
select
regexp_replace('오라클 "Oracle Database 23c" 버전', '[가-힣]|[,"]') AS regexp01_1, -- [가-힣]로 쓰면 한글을 찾아서 치환시켜줌, 특수문자도 마찬가지
regexp_replace('오라클 "Oracle Database 23c" 버전', '[가-힣]|[[:punct:]]') AS regexp01_2, -- [[:punct:]] 키워드를 써서 특수문자도 지움 
regexp_replace('오라클 "Oracle Database 23c" 버전', '[^a-zA-Z0-9]') AS regexp01_3,
regexp_replace('오라클 "Oracle Database 23c" 버전', '[^A-z0-9]') AS regexp01_4, 		-- 아무것도 안쓰면 제거
regexp_replace('Oracle Database 23c  버전', ' ') AS regexp01_5,		-- 아무것도 안쓰면 공백 제거
regexp_replace('Oracle Database 23c  버전', '( ){2,}',' ') AS regexp01_6, -- 붙어있는 문자마다 공백을 넣음
regexp_replace('Oracle Database 23c  버전', '\s{2,}',' ') AS regexp01_7  -- 6번과 동일한 동작을 보임
FROM dual;   


-- 19
SELECT ename, job, concat(ename, concat(concat(' (',job), ')')) AS "rename" FROM emp;
SELECT ename, job, ename||'('||job||')' AS "rename" FROM emp;		-- 표준은 아님

-- 20
