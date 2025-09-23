SELECT * FROM emp;

SELECT * FROM emp WHERE empno = 7369;	-- where를 사용하면 나머지 열들도 출력 가능
-- where는 조건절이라고 부른다.
SELECT * FROM emp WHERE DEPTNO = 20;
-- where로 데이터를 찾을 경우 대소문자를 구분한다.

SELECT ENAME , JOB  FROM emp WHERE job = 'SALESMAN'; -- 'SALESMAN' 에 해당하는 선택한 열들을 찾음
SELECT *  FROM emp WHERE job = 'SALESMAN'; -- 'SALESMAN' 에 해당하는 모든 열들을 찾음

SELECT ename AS "직원 이름", job  FROM emp WHERE job = 'SALESMAN'; -- 별칭을 사용하는 경우

SELECT * FROM emp WHERE deptno = 30 OR job = 'SALESMAN'; -- OR 조건으로 검색하는 경우(둘 중 하나 만족)
SELECT * FROM emp WHERE deptno = 30 AND job = 'SALESMAN'; -- AND 조건으로 검색하는 경우(둘다 만족)
-- SQL 에서는 같다 : =
SELECT * FROM emp WHERE deptno = 30 AND job = 'SALESMAN' ORDER BY ename desc; -- 순서대로 나오는 경우

-- 이상인 경우
SELECT * FROM emp WHERE sal  >= 3000;
-- 이하인 경우
SELECT * FROM emp WHERE sal  <= 3000;
-- 이상 이하 문자열 처리 알파벳 순서(앞글자 부터)
SELECT * FROM emp WHERE ename >= 'F';
-- 다르다 :  !=,  <>, ^=
SELECT * FROM emp WHERE sal != 3000;
SELECT * FROM emp WHERE sal <> 3000; -- 이거 자주 씀
SELECT * FROM emp WHERE sal ^= 3000; -- 이거는 잘 쓰지 않음

-- Quiz : job이 Manager 이고, SALSEMAN 또는 CLERK
-- or 조건이 여러개 일때는 줄여쓰는게 필요하다.
SELECT * FROM EMP WHERE job = 'MANAGER' OR  job = 'SALESMAN' OR job = 'CLERK';
-- 따라서 in 구문을 씀으로 무분별한 or 사용을 방지 할 수 있음
SELECT * FROM emp WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');
-- 10 30 부서 인원 조회
SELECT * FROM emp WHERE deptno in(10, 30);
SELECT * FROM emp;