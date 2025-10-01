CREATE TABLE dept ( 
	deptno NUMBER(2) CONSTRAINT dept_deptno_pk PRIMARY KEY,
	dname varchar2(14),
	loc varchar2(13)
);

DROP TABLE EMP;

CREATE TABLE emp (
	empno NUMBER(4)	CONSTRAINT emp_empno_pk PRIMARY KEY,	-- 정수 4자리, 제약 사항(primary key -> unique, not null)
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7, 2),
	COMM NUMBER(7, 2),
	DEPTNO NUMBER(2) CONSTRAINT emp_deptno_fk REFERENCES dept(deptno) 	-- 부서번호 외래키
);

CREATE TABLE bonus ( 
	ename varchar2(20), 
	job varchar2(9),
	sal NUMBER,
	comm NUMBER
);

CREATE TABLE salgrade (
	grade NUMBER,
	losal NUMBER,
	hisal NUMBER
);

-- DEPT 테이블 데이터 입력
INSERT INTO dept (deptno, dname, loc) VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO dept VALUES (40, 'OPERATIONS', 'BOSTON');

-- EMP 테이블 데이터 입력
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,to_date('13-JUL-87')-85,3000,NULL,20);
INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,to_date('13-JUL-87')-51,1100,NULL,20);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);

-- SALGRADE 데이터 입력
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

SELECT * FROM EMP;

COMMIT; -- 박제

SELECT * FROM DEPT;

SELECT * FROM SALGRADE;


-- 1. 단일행 함수
SELECT * FROM EMP;
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7369; -- 특정 컬럼만 도출하는 방법(2개의 컬럼과 WHERE 조건에 맞는 인스턴스 도출)
SELECT * FROM EMP WHERE EMPNO = 7369; 
SELECT * FROM EMP WHERE JOB = 'SALESMAN' AND DEPTNO = 30; -- && (AND 조건)
SELECT * FROM EMP WHERE JOB = 'CLERK' OR DEPTNO = 30
ORDER BY DEPTNO, JOB; -- || (OR 조건)

SELECT * FROM EMP WHERE SAL = 3000; -- SAL이 3000인 사람
SELECT * FROM EMP WHERE SAL <= 3000; -- SAL이 3000 이상인 사람 
SELECT * FROM EMP WHERE SAL >= 3000; -- SAL이 3000 이히인 사람
SELECT * FROM EMP WHERE SAL != 3000; -- SAL이 3000 이 아닌 사람 
SELECT * FROM EMP WHERE SAL <> 3000; -- SAL이 3000 이 아닌 사람 != 와 같음
 SELECT * FROM EMP WHERE JOB IN('SALESMAN', 'CLERK', 'MANAGER');

SELECT * FROM EMP WHERE deptno IN(10, 20, 30) ORDER BY deptno, sal desc;
SELECT * FROM EMP WHERE sal >= 2000 AND sal <= 3000;
SELECT * FROM EMP WHERE sal BETWEEN 2000 AND 3000;  --- 위의 부등호 and 조건과 같다.

SELECT * FROM EMP WHERE deptno NOT IN(10, 20, 30) ORDER BY deptno, sal desc;
SELECT * FROM EMP WHERE sal NOT BETWEEN 2000 AND 3000 ORDER BY sal;  --- not을 쓰면서 나머지 인스턴스를 출력할 수 있다.

-- like 글자 매칭
SELECT * FROM emp WHERE ename LIKE 'S%'; -- ename이 S로 시작하는 모든 사람 검색
SELECT * FROM emp WHERE ename LIKE '%S%'; -- ename이 S가 들어가는 모든 사람
SELECT * FROM emp WHERE ename LIKE '_____'; -- ename이 5글자인 사람 검색
SELECT * FROM emp WHERE ename LIKE '____S'; -- ename이 5글자인 사람 검색(특수한 검색 같은 경우는 복잡함)


SELECT * FROM emp WHERE comm IS NULL; -- null 은 = 로 비교 불가
SELECT * FROM emp WHERE comm IS NOT NULL; -- null의 반대인 경우는 not null

-- union intersect (사실 이건 join으로 처리가 가능함)
-- 단일행 function : single row function vs group function 
SELECT  lower(ename) FROM emp;
SELECT  upper(lower(ename)) FROM emp;
SELECT  initcap(ename) FROM emp;


SELECT  lower(ename) AS ename_lower, upper(lower(ename)) AS ename_upper, initcap(ename) AS ename_initcap FROM emp;
SELECT * FROM emp WHERE upper(ename) LIKE upper('%s%'); -- upper를 모두 lower 로 바꿔서 select 할 수 있다.
SELECT ename, length(ename) FROM emp WHERE length(ename) > 5;
SELECT '한글', length('한글'), lengthb('한긓'), length('abc'), lengthb('abc') FROM dual; -- 한글은 1글자에 3바이트 먹음, 영어는 1바이트
SELECT 'oracle', substr('oracle', 1, 2) FROM dual;
SELECT ename, substr(ename, 1, 2) FROM emp; -- 글자를 추출할 떄에는 substr 함수를사용해서 단일행 마다 원하는 자리를 추출할 수 있다.
SELECT substr('210101-1233203', -7) AS birth FROM dual; 		-- 뒤에서 찾는 방법
SELECT substr('210101-1233203', 1, 6) AS birth FROM dual;		-- 앞에서 찾는 방법
SELECT instr('oracle', 'r') FROM dual; ---찾고자 라는 문자의 index, r이 처음 등장하는 자릿수
SELECT instr('hello oracle', 'l', 5) FROM dual;			-- 5번째 글자 이후에 나오는 l의 자릿수
SELECT instr('hello oracle', 'l', -1) FROM dual;			-- 뒤에서 등장하는 자리부터 l을 찾음
SELECT instr('hello oracle', 'ㄹ') FROM dual;			-- 글자를 찾을 떄 없으면 0이 나옴

-- sdaabcd.pdf에서 파일내임만 출력
SELECT substr('sdaabcd.pdf', 1, instr('sdaabcd.pdf', '.') - 1) AS filename FROM dual;		-- 파일 네임
SELECT substr('sdaabcd.pdf', -3, instr('sdaabcd.pdf', '.') - 1) FROM dual;		-- 확장자
SELECT substr('sdaabcd.pdf', 1, instr('sdaabcd.pdf', '.') - 1) AS filename,
substr('sdaabcd.pdf', instr('sdaabcd.pdf', '.') + 1) AS extension FROM dual;		-- 확장자

-- lpad, rpad 문자 채우기
SELECT rpad('250306-', 14, '*') FROM dual; -- 지정된 자리수에서 뒤(오른쪽)로 채우기
SELECT lpad('250306-', 14, '*') FROM dual; -- 지정된 자리수에서 앞(왼쪽)으로 채우기
--SELECT lpad('250306-', 14) FROM dual; -- 없으면 공백으로 채움 (잘쓰지 않음)
SELECT concat(empno, ename), empno||ename FROM emp; -- 글자 합치기 단, ||는 오라클에서만 사용할 수 있으므로 주의
SELECT '   abc        ' , ltrim('   abc        '), rtrim('   abc        ' ), trim('   abc        ' ) FROM dual; -- 공백 지우기 이것도 표준은 아님
SELECT '   abc        ', 
		trim(LEADING FROM  '   abc        ' ), 		-- ltrim 처럼 왼쪽 공백 지우기
		trim(TRAILING FROM  '   abc        ' ), 	-- rtrim 처럼 오른쪽 공백 지우기
		trim(BOTH FROM  '   abc        ' )			-- 양쪽 공백 지우기 BOTH FROM 붙이는 거 까지 표준
FROM dual; -- 표준 공백 지우기


--- 
SELECT round(1234.5678) FROM dual;
SELECT round(1234.5678, 1) FROM dual;
SELECT round(1234.5678, 2) FROM dual;
SELECT round(1234.5678, -1) FROM dual; -- -1은 1의 자리에서 반올림 진행
SELECT ceil(1234.5678) FROM dual; --  올림
SELECT floor(1234.5678) FROM dual; -- - 버림
SELECT mod(99, 4) FROM dual; -- 나머지

SELECT sysdate AS today, sysdate + 1 AS tomorrow, sysdate - 1 AS yesterday FROM dual;
SELECT sysdate, sysdate + 30 AS month_later FROM dual;
SELECT sysdate, add_months(sysdate, 1) FROM dual;
-- 날짜 데이터를 문자열로 전환
SELECT to_char(sysdate, 'YYYY-MM-DD DAY HH:MI:SS', 'NLS_DATE_LANGUAGE=KOREAN') AS "DATE" FROM dual;
-- 문자열을 날짜 데이터로 전환
SELECT TO_DATE('2025-10-01', 'YYYY-MM-DD') FROM DUAL;
SELECT TO_DATE('2025/10/01', 'YYYY/MM/DD') FROM DUAL;

--- NULL 처리 함수 NVL(), NVL2()
SELECT ENAME, COMM, NVL(COMM, 0), NVL2(COMM, 'O','X') FROM EMP;
-- NVL(): NULL이면 초기값으로 수정, NVL2는 NULL이면 왼쪽 파라미터 치환 아니면 오른쪽 파라미터로 치환
SELECT EMPNO, ENAME, JOB, SAL,
FLOOR (CASE JOB
 WHEN 'MANAGER' THEN SAL * 1.1
 WHEN 'CLERK' THEN SAL * 1.5
 ELSE SAL * 1.25
END) AS UPSAL
FROM EMP;

-- 다중행 함수 -> 여러개의 결과를 하나로 압축해서 쓰기 위함.
SELECT SUM(SAL) AS SUM FROM EMP;

SELECT SUM(COMM) AS SUM FROM EMP; -- NULL이 있으면 제외된 값을 더함
SELECT COUNT(SAL) AS COUNT FROM EMP;
SELECT COUNT(COMM) AS COUNT FROM EMP; -- 마찬가지로 COMM도 NULL인 값을 제외하고 카운팅

SELECT MAX(SAL) MAX_SAL, MIN(SAL) MIN_SAL, MAX(SAL) - MIN(SAL) DIFF_SAL FROM EMP;
SELECT ROUND(AVG(SAL), 2) AVG_SAL FROM EMP;

-- GROUP BY 일 떄에는 WHERE 절을 사용할 수 없다. 오로지 HAVING을 사용할 수 밖에 없다.
SELECT DEPTNO, SUM(SAL), MAX(SAL), MIN(SAL), AVG(SAL) FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO; -- GROUP BY는 항상 ASC가 기본

SELECT SUM(SAL), MAX(SAL), MIN(SAL), AVG(SAL) FROM EMP
WHERE SAL >= 2000; -- SAL이 2000이상인 경우에서만 조회











