-- 01.
-- 모든 사원의 이름(ENAME)과 부서번호(DEPTNO), 부서명(DNAME)을 출력하세요.
SELECT
	e.ename,
	d.deptno,
	d.dname
FROM
	emp e
JOIN dept d ON
	(e.deptno = d.deptno)
ORDER BY
	e.ename ASC;
--02.
--사원 이름(ENAME)과 상사의 이름(MGR_ENAME)을 출력하세요. (SELF JOIN)
SELECT
	e1.ename,
	e1.mgr,
	e2.empno,
	e2.ename AS mgr_ename
FROM
	emp e1
JOIN emp e2 ON
	(e1.mgr = e2.empno);
--03.
--모든 사원(ENAME)과 그 사원이 속한 부서명(DNAME), 부서위치(LOC)를 출력하세요.
SELECT
	e.ename,
	d.dname,
	d.loc
FROM
	emp e
JOIN dept d ON
	(e.deptno = d.deptno)
ORDER BY
	e.ename ASC;
--04.
--부서에는 존재하지만, 해당 부서에 소속된 사원이 없는 경우도 포함하여 부서명 + 사원명을 출력하세요. (OUTER JOIN)
SELECT
	d.deptno,
	d.dname,
	e.ename
FROM
	emp e
RIGHT OUTER JOIN dept d ON
	(e.deptno = d.deptno)
ORDER BY
	d.deptno ASC,
	e.ename ASC;
--05.
--모든 사원의 이름(ENAME), 급여(SAL), 급여등급(GRADE)을 출력하세요. (NON-EQUI JOIN)
SELECT
	e.deptno,
	e.sal,
	s.grade
FROM
	emp e
JOIN salgrade s ON
	e.sal BETWEEN s.losal AND s.hisal;
--06.
--부서별 평균 급여를 구하고, 부서명(DNAME)과 함께 출력하세요. (GROUP BY + JOIN)
SELECT
	d.dname,
	floor(avg(e.sal) * 100)/100 AS avg_sal
FROM
	emp e
JOIN dept d ON
	e.deptno = d.deptno
GROUP BY
	d.dname;
--07.
--사원 이름(ENAME), 부서명(DNAME), 상사 이름(MGR_NAME)을 한 번에 출력하세요.
SELECT
	e1.ename,
	d.dname,
	e2.ename
FROM
	emp e1
JOIN dept d ON
	e1.deptno = d.deptno
LEFT OUTER JOIN emp e2 ON
	e1.mgr = e2.empno;
--08.
--사원이 없는 부서를 출력하세요.
SELECT
	d.dname,
	count(ename)
FROM
	dept d
LEFT OUTER JOIN emp e ON
	d.DEPTNO = e.DEPTNO
GROUP BY
	d.dname
HAVING
	count(ename) = 0;

-- 다른 방법
SELECT
	d.dname
FROM
	dept d
LEFT OUTER JOIN emp e ON
	d.DEPTNO = e.DEPTNO
WHERE e.empno IS NULL;

--09.
--부서별 최고 급여를 받는 사원의 이름, 급여, 부서명을 출력하세요.
WITH temp AS 
(
SELECT d.dname, max(e.sal) AS max_sal
FROM emp e
JOIN dept d ON e.DEPTNO = d.DEPTNO
GROUP BY d.dname
)
SELECT e.ename, e.sal, t.dname
FROM emp e
JOIN temp t ON (e.sal = max_sal)
ORDER BY t.dname;

-- 다른 방법
SELECT e.ename, e.sal, d.dname
FROM emp e JOIN dept d ON e.deptno = d.deptno
WHERE e.sal = (SELECT max(sal) FROM emp WHERE deptno = e.deptno)
ORDER BY d.dname;

SELECT
	max(sal)
FROM
	emp;
--10.
--모든 사원과 모든 부서를 카테시안 곱(CROSS JOIN)으로 출력하세요.
SELECT
	*
FROM
	emp
CROSS JOIN dept;