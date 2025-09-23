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
SELECT * FROM emp WHERE deptno in(10, 30);	-- in은 or 조건 모음이다. 
SELECT * FROM emp WHERE deptno = 10 OR deptno = 30;
SELECT * FROM emp WHERE job NOT IN ('MANAGER', 'SALESMAN', 'CLERK'); -- in 앞에다가 not을 붙이면 해당되지 않는 데이터를 검색
-- quiz sal이 2000 이상 3000 이하
SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;
-- 위 아래 모두 같은 결과를 보인다. 2000이상 3000이하인 수 
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE sal <= 2000 OR sal >= 3000;
SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000; -- not 을 사용해서 해당 범위에 속하지 않는 데이터들을 출력
-- 중요 S로 시작하는 단어 like, % : 어떤게 와도 상관없음
SELECT * FROM emp WHERE ename LIKE 'S%'; -- % 키워드와 Like를 동시에 쓰면 자바의 startWith랑 같은 방식으로 적용이된다.
SELECT * FROM emp WHERE ename LIKE '%ER';	-- %가 앞에 와도 er로 끝나는 데이터를 출력한다.
SELECT * FROM emp WHERE ename LIKE '%AR%';	-- 양 끝 %사이에 'AR'이 포함된 데이터들을 출력한다.
-- 이름 중에 M과 I가 동시에 존재하는 사원 검색 M이 먼저 나와야 함(맨 앞글자가 아니라 포함되어 있는 단어들 중에서 앞 글자)
SELECT * FROM emp WHERE ename LIKE '%M%I%';	-- 양 끝 %사이에 'AR'이 포함된 데이터들을 출력한다.
-- 이름이 5글자 이것도 LIKE를 쓰네 ㄷㄷ
SELECT * FROM emp WHERE ename LIKE '_____';	-- 5글자인 이름을 출력하는 경우? _ 를 사용해서 자리수를 나타낸다
SELECT * FROM emp WHERE ename LIKE '____S'; -- 5글자 이면서 끝자리가 S인 경우
SELECT * FROM emp WHERE ename LIKE 'A_L__'; -- 이런식으로 지정한 자리수에 찾고자하는 문자들을 넣어 출력할 수 있음

-- 이름중에 2번째 글자가 L인 경우
SELECT * FROM emp WHERE ename LIKE '_L%'; 
-- 3번째가 L인 경우
SELECT * FROM emp WHERE ename LIKE '__L%'; 

-- 이름이 N으로 끝나는 사람, 이름의 3번째 글자가 A인 사람, 이름중에 A로 시작하는 사람
SELECT * FROM emp WHERE ename LIKE '%N'; 	-- 1
SELECT * FROM emp WHERE ename LIKE '__A%'; 	-- 2
SELECT * FROM emp WHERE ename LIKE 'A%'; 	-- 3

-- null 비교
SELECT ename, comm FROM emp ;
SELECT ename, comm FROM emp WHERE comm = null; -- NULL은 = 비교가 안된다.
SELECT ename, comm FROM emp WHERE comm is null; -- NULL은 is키워드로 찾을 수 있다.
SELECT ename, comm FROM emp WHERE comm is NOT null; -- null이 아닌 값을 찾을 수 있다.

-- null은 비교 연산으로 처리가 불가능하다. 함수로 처리가 가능 nvl(), nvl2()로 처리해야 한다.
SELECT ename, comm FROM emp WHERE comm  > null; 


-- 집합 연산자 

-- union은 합집합
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10
union
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 20;


-- union은 합집합
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10
union
SELECT empno, ename, sal FROM emp WHERE deptno = 20; -- 연산할 컬럼들이 일치해야 집합 연산을 할 수 있다. 


-- union은 합집합 만약 조건이 같으면 중복은 제외된다.
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10 -- 컬럼 열의 순서가 같으면 중복을 제거한다.
union
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10;

-- union all 은 순서가 같아도 두 테이블을 모두 출력한다.
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10 
UNION ALL 
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10; 

-- minus 차 집합 : 전체 조건 중에 deptno 10번을 제외한 나머지 조건
SELECT empno, ename, sal, deptno FROM emp 
MINUS 
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10; 

-- intersect 교 집합 : 전체 조건 중에 deptno 10번에 해당되는 데이터들만 출력
SELECT empno, ename, sal, deptno FROM emp 
INTERSECT  
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10;

SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10; -- 하나의 테이블에서는 이것만 써도 됨.

SELECT * FROM emp;
