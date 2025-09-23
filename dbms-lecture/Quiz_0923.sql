--1
SELECT * FROM emp WHERE ename Like '%S';

--2
SELECT empno, ename, job, sal, deptno FROM emp WHERE deptno = 30 AND job ='SALESMAN';

-- 3-1
SELECT empno, ename, job, sal, deptno FROM emp 
WHERE sal > 2000 
AND deptno IN(20, 30);
SELECT empno, ename, job, sal, deptno FROM emp 
WHERE sal > 2000 
AND (deptno = 20 OR deptno = 30);
-- 3-2
SELECT empno, ename, job, sal, deptno FROM emp 
WHERE sal > 2000
INTERSECT 
SELECT empno, ename, job, sal, deptno FROM emp 
WHERE deptno IN(20, 30)
ORDER BY deptno ASC, sal DESC;	-- order by는 제일 나중에

-- union으로 하는 다른 방법
SELECT empno, ename, job, sal, deptno FROM emp 
WHERE deptno = 20 AND sal > 2000
UNION 
SELECT empno, ename, job, sal, deptno FROM emp 
WHERE deptno = 30 AND sal > 2000;


-- 4
SELECT * FROM emp WHERE sal < 2000 OR sal > 3000 ORDER BY sal desc;
SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000; -- 만약 쓴다면
-- Between은 >= AND <= 가 붙으니 유의하여야 함.

-- 5
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 30 AND
ename LIKE '%E%' AND sal NOT BETWEEN 1000 AND 2000;

--6
SELECT * FROM emp WHERE JOB = 'CLERK' OR JOB = 'MANAGER'
INTERSECT 
SELECT * FROM emp WHERE ename NOT LIKE '_L%';

SELECT * FROM emp WHERE JOB = 'CLERK' OR JOB = 'MANAGER' AND ename NOT LIKE '_L%'