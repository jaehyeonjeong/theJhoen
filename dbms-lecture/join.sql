-- join 테이블 합치기
SELECT
	*
FROM
	emp;
-- 모든 데이터 베이스는 아래로 확장하는게 편하다.
-- 문제는 옆으로 확장하는게 불편하다. -> 그래서 사용하는 키워드가 join이다.
SELECT
	*
FROM
	emp,
	dept;
-- 모든 경우의 수를 출력하는 꼴이됨.
SELECT
	count(*)
FROM
	emp,
	dept;
-- 모든 경우의 수를 출력하는 꼴이됨.
-- 카테시안 곱(많이 씀) : 단순 조합(행 x 행), 데카르트 곱

SELECT
	*
FROM
	dept;
-- join 도 2개임..

SELECT
	*
FROM
	emp,
	dept
WHERE
	emp.deptno = dept.deptno
	--ORDER BY emp.deptno;
ORDER BY
	empno;
-- deptno는 어느 테이블에 있는지 햇갈림
-- 중복 컬럼을 출력하는 경우에는 테이블을 명시해야한다.
SELECT
	empno,
	ename,
	job,
	emp.deptno
FROM
	emp,
	dept
WHERE
	emp.deptno = dept.deptno
	--ORDER BY emp.deptno;
ORDER BY
	empno;
-- 겹치는 열만 alias를 붙여주면 된다.
SELECT
	empno,
	ename,
	job,
	d.deptno
FROM
	emp e,
	dept d
	-- from에 alias를 작성하면, as 안붙임 as는 컬럼에다가만 사용한다.
WHERE
	e.deptno = d.deptno
	-- where에도 alias를 작성해야한다.
	--ORDER BY emp.deptno;
ORDER BY
	deptno;
-- deptno도 테이블의 alias를 표시해줘야 한다.
-- 위에 있는 join들은 다 Oracle에서 제공하는 것들이다.
-- join의 종류에는 
--1. 등가 조인(equi join, inner join) (같다, 두 개의 공통 컬럼값이 있는 행만 반환하는 join)
--2. 비등가 조인(non-equi join) : 범위를 한정
SELECT
	*
FROM
	salgrade;
-- 특정 범위내의 데이터를 맞춰서 검색
SELECT
	*
FROM
	emp e,
	salgrade s
WHERE
	e.sal BETWEEN s.losal AND s.hisal
ORDER BY
	hiredate DESC;
-- 3. self 조인은 자기테이블을 한번 더 사용
-- 많이 쓰지 않지만 가끔 사용하는 경우
SELECT
	e1.empno,
	e1.ename,
	e1.mgr,
	e2.empno AS mgr_empno,
	e2.ename AS mgr_ename
FROM
	emp e1,
	emp e2
WHERE
	e1.mgr = e2.empno;
-- 4. 조건에 맞지 않더라도 출력해야하는 경우 외부 조인(outter join) 
SELECT
	e1.empno,
	e1.ename,
	e1.mgr,
	e2.empno AS mgr_empno,
	e2.ename AS mgr_ename
FROM
	emp e1,
	emp e2
WHERE
	--	e1.mgr(+) = e2.empno;
	e1.mgr = e2.empno(+);
-- 오라클에서는 +만 넣어줘서 KING도 출력이 됨
-- left outter join 이라고 함 : 왼쪽의 테이블의 내용을 전부 출력
-- 매니저가 없는 사람 출력


SELECT
	e1.empno,
	e1.ename,
	e1.mgr,
	e2.empno AS mgr_empno,
	e2.ename AS mgr_ename
FROM
	emp e1,
	emp e2
WHERE
	e1.mgr(+) = e2.empno;
-- e2.empno가 없어도 출력
-- 즉 empno와 mgr번호가 같지않아도 모두 출력하라는 의미였음.

SELECT
	*
FROM
	emp;
-- 문제는 이게 다 오라클 join이다.
-- 여기서 부터 ansi join(표준 join)이다.
-- 1. natural join
SELECT
	*
FROM
	emp e
NATURAL JOIN dept d;
-- 겹치는 컬럼명은 alias를 붙이지 않는다.
SELECT
	e.empno,
	e.ename,
	deptno,
	d.loc,
	d.dname
FROM
	emp e
NATURAL JOIN dept d;
-- using을 사용하는 방법도 있다.(만약 join만 쓴다면 using keyword를 사용)
SELECT
	e.empno,
	e.ename,
	deptno,
	d.loc,
	d.dname
FROM
	emp e
JOIN dept d
		USING(deptno);
-- on키워드를 사용하는 경우(이 경우를 제일 많이 씀)
SELECT
	e.empno,
	e.ename,
	e.deptno,
	d.loc,
	d.dname
FROM
	emp e
JOIN dept d ON
	(e.deptno = d.deptno);
-- inner는 기본임으로 붙이지 않아도 상관없음(보통은 inner를 붙이지 않아도 된다.)
--FROM emp e INNER JOIN dept d ON(e.deptno = d.deptno); 
-- 외부 조인을 사용하는 경우 되도록이면 ANSI를 사용하는 것이 좋다.(표준이니까)
SELECT
	e1.empno,
	e1.ename,
	e1.mgr,
	e2.empno AS mgr_empno,
	e2.ename AS mgr_ename
FROM
	--	emp e1 FULL OUTER JOIN emp e2 ON (e1.mgr = e2.empno); -- 전체 외부 조인 left, right 둘 다
	emp e1
RIGHT OUTER JOIN emp e2 ON
	(e1.mgr = e2.empno);
-- 오른쪽 외부 조인
--	emp e1 LEFT OUTER JOIN emp e2 ON (e1.mgr = e2.empno); -- 왼쪽 외부 조인
--emp e1 INNER JOIN emp e2 ON (e1.mgr = e2.empno);
-- quiz
-- 1.
-- ansi --99 방식 
SELECT
	d.deptno,
	d.dname,
	e.empno,
	e.ename,
	e.sal
FROM
	emp e
INNER JOIN dept d ON
	(e.deptno = d.deptno)
WHERE
	e.sal > 2000;

SELECT
	deptno,
	d.dname,
	e.empno,
	e.ename,
	e.sal
FROM
	emp e
NATURAL JOIN dept d
WHERE
	e.sal > 2000;

SELECT
	deptno,
	d.dname,
	e.empno,
	e.ename,
	e.sal
FROM
	emp e
JOIN dept d
		USING (deptno)
WHERE
	e.sal > 2000;
-- oracle -- 99이전 방식
SELECT
	d.deptno,
	dname,
	empno,
	ename,
	sal
FROM
	emp e,
	dept d
WHERE
	e.deptno = d.DEPTNO
	AND e.SAL > 2000;
--- 2.
-- ansi
SELECT
	d.deptno,
	d.dname,
	floor(avg(e.sal)) AS avg_sal,
	max(e.sal) AS max_sal,
	min(e.sal) AS min_sal,
	count(*) AS cnt
FROM
	emp e
JOIN dept d ON
	(e.deptno = d.deptno)
GROUP BY
	d.deptno,
	d.dname;
-- Oracle
SELECT
	d.deptno,
	d.dname,
	floor(avg(e.sal)) AS avg_sal,
	max(e.sal) AS max_sal,
	min(e.sal) AS min_sal,
	count(*) AS cnt
FROM
	emp e,
	dept d
WHERE
	e.DEPTNO = d.DEPTNO
GROUP BY
	d.deptno,
	d.dname;
--- 3.
-- ansi
SELECT
	d.deptno,
	d.dname,
	e.empno,
	e.ename,
	e.job,
	e.sal
FROM
	emp e
RIGHT OUTER JOIN dept d ON
	(d.deptno = e.deptno)
	-- e에서 없어도 출력
ORDER BY
	deptno ASC,
	ename ASC;
-- Oracle
SELECT
	d.deptno,
	d.dname,
	e.empno,
	e.ename,
	e.job,
	e.sal
FROM
	emp e,
	dept d
WHERE
	d.deptno = e.deptno(+)
	-- d가 기준(main)이 되니까 e에다가 (+)를 붙여야함
ORDER BY
	deptno ASC,
	ename ASC;
-- 전체 조회, 카타시안 곱, 데카르트 연산 
SELECT
	d.deptno,
	d.dname,
	e.empno,
	e.ename,
	e.job,
	e.sal
FROM
	emp e
CROSS JOIN dept d;
---4.
-- ansi
SELECT
	d.deptno,
	d.dname,
	e.EMPNO,
	e.ENAME,
	e.mgr,
	e.sal,
	e.deptno AS dept_no1,
	s.LOSAL,
	s.HISAL,
	s.GRADE,
	e2.empno,
	e2.ename AS mgr_ename
FROM
	emp e
RIGHT OUTER JOIN dept d ON
	(e.deptno = d.deptno)
	-- 조건을 만족하지 않는 operation 출력
LEFT OUTER JOIN emp e2 ON
	(e.mgr = e2.empno)
LEFT OUTER JOIN salgrade s ON
	(e.sal BETWEEN s.losal AND s.hisal)
	-- emp e가 기준이 되어야 함, 그래서 grade, losal, hisal 정보도 같이 나와줘야, 마지막 40번 부서도 나오는 거임
ORDER BY
	deptno ASC,
	e.empno ASC;
-- 
-- Oracle
SELECT
	d.deptno,
	d.dname,
	e.EMPNO,
	e.ENAME,
	e.mgr,
	e.sal,
	e.deptno AS dept_no1,
	s.LOSAL,
	s.HISAL,
	s.GRADE,
	e2.empno,
	e2.ename AS mgr_ename
FROM
	emp e,
	dept d,
	emp e2,
	salgrade s
WHERE
	e.deptno(+) = d.deptno
	-- dept 테이블의 deptno 기준
	AND e.mgr = e2.empno(+)
	-- emp 의 mgr 기준
	AND e.sal BETWEEN s.losal(+) AND s.hisal(+)
	-- emp 의 sal 기준
ORDER BY
	d.deptno ASC,
	e.empno ASC;
