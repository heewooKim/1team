## **JOIN**

---

-   여러 개의 릴레이션을 사용하여 새로운 릴레이션을 만드는 과정

**① EQUI JOIN**

-   조인 대상의 두 테이블에서 특정 컬럼을 선택하여 동일한 컬럼 값을 가지는 데이터를 조회한다.

```
SELECT * FROM A, B WHERE A.C = B.C;
```

**② INNER JOIN**

-   조인 대상의 두 테이블에 특정 컬럼 값을 가지는 데이터가 모두 존재하는 데이터를 조회한다.

```
SELECT * FROM A
INNER JOIN B ON B.C = A.C;
```

**③ INTERSECT**

-   두 테이블에서 공통된 데이터를 조회한다.

```
SELECT C FROM A
INTERSECT
SELECT C FROM B;
```

**④ OUTER JOIN**

-   **LEFT OUTER JOIN** : 두 테이블에서 동일한 데이터를 조회하며 왼쪽 테이블에만 존재하는 데이터도 포함한다.

```
SELECT * FROM A
LEFT OUTER JOIN B ON B.C = A.C;
```

-   **RIGHT OUTER JOIN** : 두 테이블에서 동일한 데이터를 조회하며 오른쪽 테이블에만 존재하는 데이터도 포함한다.

```
SELECT * FROM A
RIGHT OUTER JOIN B ON B.C = A.C;
```

**⑤ CROSS JOIN**

-   두 테이블을 하나로 조인한다.
-   A 테이블이 2행, B 테이블이 4행의 데이터를 가지는 경우 결과 데이터로 총 8개의 행이 조회된다.

```
SELECT * FROM A CROSS JOIN B;
```

**⑥ UNION**

-   두 테이블을 하나로 합친다.
-   두 테이블의 컬럼 수, 데이터 형식이 모두 일치해야 한다.
-   UNION : 두 테이블을 하나로 합치면서 중복된 데이터는 제외하며 정렬을 유발한다.

```
SELECT * FROM A
UNION ALL
SELECT * FROM B;
```

-   UNION ALL : 두 테이블을 하나로 합치면서 중복된 데이터를 제외하지 않으며 정렬도 유발하지 않는다.

```
SELECT * FROM A
UNION
SELECT * FROM B;
```

**⑦ MINUS**

-   먼저 선언된 테이블에는 존재하며 뒤에 선언된 테이블에 존재하지 않는 데이터를 조회한다.

```
SELECT * FROM A
MINUS
SELECT * FROM B;
```