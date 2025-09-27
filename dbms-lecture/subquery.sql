SELECT
	SAL
FROM
	EMP
WHERE
	ENAME = 'JONES';

SELECT
	ename,
	sal
FROM
	emp
WHERE
	sal >= (
	SELECT
		sal
	FROM
		emp
	WHERE
		ename = 'JONES');
-- 2975
-- 조건절에 쓴 subquery를 여러가지 경우의 수가 있음.
-- sllen보다 커미션을 많이 받는사람
SELECT
	ename,
	comm
FROM
	emp
WHERE
	comm > (
	SELECT
		comm
	FROM
		emp
	WHERE
		ename = 'ALLEN');

SELECT
	comm
FROM
	emp
WHERE
	ename = 'ALLEN';

SELECT
	HIREDATE
FROM
	emp
WHERE
	ename = 'SCOTT';
-- scott보다 일찍 입사한 사람
SELECT
	ename,
	hiredate
FROM
	emp
WHERE
	HIREDATE < (
	SELECT
		HIREDATE
	FROM
		emp
	WHERE
		ename = 'SCOTT');
-- 20번 부서의 근무하는 사원 중 전체 사원의 평균 급여보다 많이 받는 사람의 이름과, 부서번호, JOB, 부서이름까지 출력
SELECT
	AVG(SAL)
FROM
	EMP
	-- 결과가 하나
WHERE
	DEPTNO = 20;

SELECT
	E.ENAME,
	D.DEPTNO,
	D.DNAME,
	E.JOB,
	E.SAL
FROM
	EMP E
JOIN DEPT D ON
	(D.DEPTNO = E.DEPTNO)
WHERE
	D.DEPTNO = 20
	AND E.SAL > (
	SELECT
		AVG(SAL)
	FROM
		EMP);
-- 20, 30번 부서 
SELECT
	AVG(SAL)
FROM
	EMP
	-- 결과가 하나
WHERE
	DEPTNO IN (20, 30);

SELECT
	E.ENAME,
	D.DEPTNO,
	D.DNAME,
	E.JOB,
	E.SAL
FROM
	EMP E
JOIN DEPT D ON
	(D.DEPTNO = E.DEPTNO)
WHERE
	D.DEPTNO IN (20, 30)
	AND E.SAL > (
	SELECT
		AVG(SAL)
	FROM
		EMP
		-- 결과가 하나
	WHERE
		DEPTNO IN (20, 30));

-- 부서별 최고 급여
SELECT * FROM EMP E WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO); -- 복수의 열이 있는 경우는 IN으로 처리가 가능하다.
SELECT MAX(SAL) AS MAX_SAL FROM EMP GROUP BY DEPTNO;

-- ANY, SOME: 다중행을 반환했을 때 하나라도 참이면 결과를 출력
SELECT * FROM EMP E WHERE SAL = ANY (SELECT MAX(SAL) AS MAX_SAL FROM EMP GROUP BY DEPTNO);
SELECT * FROM EMP E WHERE SAL = SOME (SELECT MAX(SAL) AS MAX_SAL FROM EMP GROUP BY DEPTNO);

-- 30번 부서의 최대 급여보다 작은 사람 출력
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP E WHERE SAL < ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);
SELECT * FROM EMP E WHERE SAL < ANY (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);
-- 30번 부서의 최대 급여보다 큰 사람 출력
SELECT * FROM EMP E WHERE SAL > ANY (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);
-- 30번 부서의 최소 급여보다 큰 사람 출력
SELECT * FROM EMP E WHERE SAL > ANY (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- ALL은 모두 만족하는 경우
-- 30번 부서의 최소급여보다 적게 받는 사람
SELECT * FROM EMP E WHERE SAL < ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 해당하는 급여만 찾음
-- 30번 부서의 최대급여 보다 많이 받는 사람
SELECT * FROM EMP E WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 해당하는 급여만 찾음	

-- EXISTS(존재 여부) : 하나라도 전부 있으면 TRUE, 아니면 FALSE
SELECT * FROM EMP WHERE EXISTS(SELECT DNAME FROM DEPT WHERE DEPTNO = 10);
SELECT DNAME FROM DEPT WHERE DEPTNO = 20;
-- 부서 번호가 없으면 출력하지 않음
SELECT * FROM EMP WHERE EXISTS(SELECT DNAME FROM DEPT WHERE DEPTNO = 100);

-- FROM 절에 쓰는 SUBQUERY : INLINE VIEW라고 한다. (한 줄 짜리)
-- EX) 고객데이터 중 민감한 정보
-- 10번 부서에 근무하는 사원 이름과 10번부서의 loc 출력
SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC FROM
(SELECT * FROM EMP WHERE DEPTNO = 10) E10 -- 하나의 테이블 중에 마스킹해서 보여주는 영역을 VIEW라고 한다.
JOIN (SELECT * FROM DEPT) D ON E10.DEPTNO = D.DEPTNO;

WITH E10 AS (SELECT * FROM EMP WHERE DEPTNO = 10),
	D AS (SELECT * FROM DEPT)
SELECT E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC 
FROM E10, D
WHERE E10.DEPTNO = D.DEPTNO;

-- SELECT 절에 쓰는 서브쿼리 (스칼라 서브쿼리) 단일행 단일 값을 반환해야 한다.
SELECT EMPNO, ENAME, JOB, SAL, (SELECT GRADE FROM SALGRADE WHERE E.SAL BETWEEN LOSAL AND HISAL) AS SAGRADE 
, DEPTNO, (SELECT DNAME FROM DEPT D WHERE E.DEPTNO = D.DEPTNO) AS DANME
FROM EMP E;

SELECT EMPNO, ENAME, JOB, SAL, S.GRADE, D.DNAME
FROM EMP E
JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
JOIN DEPT D ON E.DEPTNO = D.DEPTNO;

-- BOOK QUIZ
-- 1. ALLEN 과 같은 직책(JOB)
SELECT JOB FROM EMP WHERE ENAME = 'ALLEN';

SELECT E.JOB, E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME
FROM EMP E
JOIN DEPT D ON D.DEPTNO = E.DEPTNO
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'ALLEN');

--2.
--전체 사원의 평균 급여(SAL)
SELECT AVG(SAL) FROM EMP;

SELECT E.EMPNO, E.ENAME, D.DNAME, E.HIREDATE, D.LOC, E.SAL, S.GRADE
FROM EMP E
JOIN DEPT D ON E.DEPTNO = D.DEPTNO
JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE E.SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY E.SAL DESC, E.EMPNO ASC;

---3.
SELECT * FROM DEPT WHERE DEPTNO = 10;
SELECT JOB FROM EMP E JOIN DEPT D ON D.DEPTNO = E.DEPTNO WHERE E.DEPTNO = 30;


SELECT E.EMPNO, E.ENAME, E.JOB, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E
JOIN DEPT D ON D.DEPTNO = E.DEPTNO
WHERE E.DEPTNO = 10 AND E.JOB != ALL (SELECT JOB FROM EMP E WHERE E.DEPTNO = 30);
-- 다른 방법
SELECT E.EMPNO, E.ENAME, E.JOB, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E
JOIN DEPT D ON D.DEPTNO = E.DEPTNO
WHERE E.DEPTNO = 10 AND E.JOB NOT IN (SELECT DISTINCT JOB FROM EMP WHERE DEPTNO = 30);
SELECT DISTINCT JOB FROM EMP WHERE DEPTNO = 30;

---4.
--- 직책이 SALESMANDLS 사람의 최고 급여
SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN';

-- 일반
SELECT E.EMPNO, E.ENAME, E.SAL, S.GRADE
FROM EMP E
JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE E.SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN')
ORDER BY E.EMPNO;

-- 다른 방법
SELECT E.EMPNO, E.ENAME, E.SAL, S.GRADE
FROM EMP E
JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE E.SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
ORDER BY E.EMPNO;

-- 또 다른 방법
SELECT E.EMPNO, E.ENAME, E.SAL
, (SELECT GRADE FROM SALGRADE WHERE E.SAL BETWEEN LOSAL AND HISAL) AS GRADE
FROM EMP E
WHERE E.SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
ORDER BY E.EMPNO;

SELECT a.empno
     , a.ename
     , a.deptno
     , (SELECT dd.dname
          FROM dept dd
         WHERE dd.deptno = a.deptno) AS dept_name
  FROM emp a
 WHERE a.sal >= 3000
 
 SELECT a.deptno
     , a.dname
     , CASE WHEN a.deptno IN (SELECT DISTINCT aa.deptno
                                FROM emp aa
                               WHERE aa.job = 'MANAGER')
            THEN 'Y' END AS manager_yn
  FROM dept a
  
  SELECT a.empno
     , a.ename
     , a.job
     , b.mgr_name
     , b.mgr_dept
  FROM emp a
 INNER JOIN (SELECT a.empno AS mgr_no
                  , a.ename AS mgr_name
                  , b.dname AS mgr_dept
               FROM emp a
                  , dept b
              WHERE a.deptno = b.deptno) b
    ON (a.mgr = b.mgr_no)
 WHERE a.deptno = 10;
 
 SELECT a.empno AS mgr_no
                  , a.ename AS mgr_name
                  , b.dname AS mgr_dept
               FROM emp a
                  , dept b
              WHERE a.deptno = b.deptno;
 
 SELECT a.empno
     , a.ename
     , a.deptno
     , b.dname
  FROM emp a
 INNER JOIN dept b
    ON (a.deptno = b.deptno)
 WHERE a.job = 'CLERK'
   AND a.deptno IN (SELECT DISTINCT aa.deptno
                      FROM emp aa
                     WHERE aa.job = 'MANAGER')
 ORDER BY a.deptno;
 
 SELECT * FROM emp;
 SELECT * FROM dept;
 
SELECT e.ename, d.dname
FROM emp e
JOIN dept d ON e.deptno = d.deptno
WHERE d.dname = 'SALES';

SELECT deptno FROM dept WHERE dname = 'SALES';

SELECT ename
FROM emp
WHERE deptno IN (SELECT deptno FROM dept WHERE dname = 'SALES');


