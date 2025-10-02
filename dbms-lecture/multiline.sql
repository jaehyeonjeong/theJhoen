-- 다중행 함수
SELECT
	sum(sal)
FROM
	emp;
-- 여러개 행을 연산해서 하나의 결과를 도출
-- 행(row, record, tuple로도 불림)과 열(column) 연산 

SELECT
	*
FROM
	emp;
-- 이건 출력할 수 없음. 즉 단일 행은 다중 행이랑 같이 쓸 수 없다.
SELECT
	ename,
	sum(sal)
FROM
	emp;
-- 오류
-- 다중행 함수 나열 : sum, count, max, min, avg
-- sum
SELECT
	sum(DISTINCT sal),
	sum(ALL sal),
	sum(sal)
FROM
	emp;

-- count
SELECT
--	count(ename)
	count(*) AS count01,-- *은 모든 데이터
	count(ALL comm) AS count02, -- null은 카운트에서 제외되기 때문에 기대값과 다를 수 있다. 
	-- all 키워드를 넣어도 null을 표시하지 못하는건 마찬가지이다.
	count(mgr) AS count03 -- 2번 과 마찬가지
FROM
	emp;

-- count
SELECT
--	count(ename)
	count(DISTINCT sal) AS count01,-- *은 모든 데이터
	count(ALL sal) AS count02, -- null은 카운트에서 제외되기 때문에 기대값과 다를 수 있다. 
	-- all 키워드를 넣어도 null을 표시하지 못하는건 마찬가지이다.
	count(sal) AS count03 -- 2번 과 마찬가지
FROM
	emp;

-- max
SELECT
	max(sal) AS count01, 
	min(sal) AS count02  
FROM
	emp
WHERE deptno = 20;	-- 조건을 달아서 해당되는 번호의 사람만 출력하는게 가능

-- 날짜에도 사용할 수 있음
SELECT 
	max(hiredate) AS late,
	min(hiredate) AS OLD
FROM emp;

-- 서브 쿼리를 사용하면 단일 행도 출력
SELECT 
	ename,
	hiredate
FROM emp
WHERE hiredate = (SELECT max(hiredate) FROM emp);

-- 평균 
SELECT trunc(avg(DISTINCT sal)) FROM emp;
SELECT floor(avg(/*ALL*/ sal)) FROM emp;

-- 10번 부서 평균
-- 20번 부서 평균
SELECT 10 AS "deptno", floor(avg(sal)) FROM emp WHERE deptno = 10
UNION ALL 
SELECT 20, floor(avg(sal)) FROM emp WHERE deptno = 20
UNION ALL
SELECT 30, floor(avg(sal)) FROM emp WHERE deptno = 30;

-- union을 사용하면 각각 다온 다중행 결과를 나열 할 수 있음

-- 다중행 함수를 열로 묶어서 출력 group by
SELECT floor(avg(sal)) AS "average sal", deptno FROM emp
GROUP BY deptno
ORDER BY "average sal" desc;


SELECT deptno, job, avg(sal) AS avg, count(mgr) AS mgrcount
FROM emp
WHERE sal >= 2000 -- 1순위
GROUP BY deptno, job -- 단일 행들이 Group by에 들어감 
ORDER BY deptno, avg DESC;

SELECT deptno, job, avg(sal) AS avg, count(mgr) AS mgrcount
FROM emp
GROUP BY deptno, job -- 단일 행들이 Group by에 들어감 
ORDER BY deptno, avg DESC;

-- having 절  순서 : 1. select, 2. where, 3. group by, 4. Having, 5. order by
-- 순서 판단 중요함
SELECT deptno, job, avg(sal) AS avg, count(mgr) AS mgrcount
FROM emp
--WHERE sal <= 3000
GROUP BY deptno, job -- 단일 행들이 Group by에 들어감 
HAVING avg(sal) >= 2000 -- 큰 특징은 group by 후에 다중행도 추가 할 수 있다.
ORDER BY deptno, avg DESC;


--- quiz
--- 0.
-- depton 만 단일행이므로 group by 시킴
--SELECT deptno, floor(avg(sal)) AS avgsal, max(sal) AS maxsal, min(sal) AS minsal, count(deptno) AS cnt --내가 한거
SELECT deptno, floor(avg(sal)) AS avgsal, max(sal) AS maxsal, min(sal) AS minsal, count(*) AS cnt, sum(sal) AS sum_sal
FROM emp
GROUP BY deptno;

---1.
SELECT job, count(job) AS cnt
FROM emp
GROUP BY job
HAVING count(job) >= 3; -- group by를 사용하고 조건을 제시할 경우 반드시 having 절을 사용해야함
-- 즉, where 절에서는 그룹 함수의 조건은 처리 되지 않는다.

---2.
SELECT to_char(HIREDATE , 'yyyy') AS hire_year, deptno, count(*) AS cnt
FROM emp
GROUP BY to_char(HIREDATE , 'yyyy'), deptno
ORDER BY hire_year; -- order by 에서는 alias를 사용해도 됨.
-- Group by도 형식에 맞는 그룹을 만들어 줘야함.


---3.
SELECT nvl2(comm, 'o', 'x') AS exist_comm, count(*) AS cnt 
FROM emp
GROUP BY nvl2(comm, 'o', 'x');