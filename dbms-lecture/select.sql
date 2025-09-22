-- select 이걸 정말 많이 사용함
DESC emp; -- DBbeaver에서는 안됨.
SELECT * FROM emp; -- 해당하는 테이블에 모든 데이터를 조회
SELECT empno AS "사원 번호", ename AS "사원 이름", job AS 직책 FROM emp; -- 해당하는 테이블에 원하는 데이터를 조회
-- as를 생략할 수는 있어도, as는 생략을 거의 안함
SELECT deptno FROM emp;	-- slelect 컬럼명 from 테이블 명

--- delete,
---- update
-- insert into


-- 처리속도는 DB가 제일 빠르다.
-- DB에서 가공할 수 있는 것들은 DB에서 가공하는 것이 좋다
SELECT DISTINCT deptno FROM emp;	--- 중복 제거 (하나의 열에서는 완벽히 중복을 제거해 줄 수 있는데)
SELECT DISTINCT job, deptno FROM emp;	--- 중복 제거 (두개 이상의 열에서는 중복을 완벽히 제거할 수 없다.)
SELECT all job, deptno FROM emp;	--- 중복 제거하지 않고 출력된다.

-- 연봉을 출력 * 12;
SELECT ename, sal, sal*12 as annualsal FROM emp; 	-- 연산하고 나서 as로 컬럼명을 쓰면 annualsal로 변경된다.
SELECT ename, sal, sal*12 + nvl(comm, 0) as annualsal FROM emp; 	-- comm 자체에 null이 있을 수 있다. 
--이를 해결하기 위해 nvl함수를 쓸 수 있다. ->  Null이면 0으로 초기화

-- 구조조정
SELECT ename, sal as annualsal FROM emp; 	-- comm 자체에 null이 있을 수 있다. 

SELECT ename, sal as annualsal FROM emp ORDER BY sal; 	-- 해당하는 열의 순서
SELECT ename, sal as annualsal FROM emp ORDER BY sal DESC; 	-- 순서 역순(내림차순)


-- 부서 번호를 오름 차순 연봉을 내림차순
SELECT ename, deptno, sal as annualsal FROM emp ORDER BY deptno, sal DESC; 
SELECT * FROM emp ORDER BY deptno asc, sal DESC;  -- Ascending(오름차순) : 기본 설정, Descending(내림차순)
-- 위 처럼 해당하는 열의 집합안에 순서를 다시 정할 수 있다.

-- 문제풀이
SELECT DISTINCT job FROM emp;
SELECT * FROM emp;

SELECT empno AS EMPLOYEE_NO, ename AS EMPLOYEE_NAME, mgr AS MANAGER, sal AS SALARY, comm AS COMMISSION, deptno AS DEPARTMENT_NO
, job, hiredate
FROM emp ORDER BY DEPARTMENT_NO DESC, EMPLOYEE_NAME ASC;		-- 1순위는 department이고, 2순위는 ename

-- 각 타입 설명 
-- empno, mgr, sal, comm, deptno 는 각각 NUMBER 타입으로 저장 만약(7,2)로 저장된 경우 최대 7, 최소 2로 적어야함
-- Date 년월일, VARCHAR2 문자 만약 VARCHAR2(10)으로 되어있으면 10글자 까지 제한됨





