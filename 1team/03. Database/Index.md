## **Database Index**

---

![img](https://github.com/heewooKim/1team/assets/65803251/1ea3615c-2dac-42d4-b900-f5e2aebc3220)



-   데이터베이스 테이블에 저장된 데이터의 검색 속도를 향상시키기 위한 자료구조
-   특정 컬럼에 인덱스를 생성하면 별도 메모리 공간에 정렬된 해당 컬럼의 데이터가 물리적 주소와 함께 저장된다.
-   쿼리 실행 시 옵티마이저가 판단한 인덱스를 타며 데이터의 물리적 주소에 가서 데이터를 가져오는 식으로 동작한다.
-   CREATE/DELETE/UPDATE가 빈번한 속성에 인덱스를 걸면 인덱스의 크기가 비대해져서 데이터베이스 성능이 저하되는 역효과가 발생할 수 있다.

**① 인덱스 사용의 장점**

1.  조건 검색 WHERE 절의 효율성  
    → 데이터들이 정렬되어 있으므로 조건에 맞는 데이터를 빠르게 찾아낼 수 있다.
2.  정렬 ORDER BY 절의 효율성  
    → 데이터들이 정렬되어 있으므로 데이터를 가져오기만 하면 된다.
3.  MIN, MAX의 효율적인 처리  
    → 데이터들이 정렬되어 있으므로 레코드의 시작/ 끝 값 한 건 씩만 가져오면 된다.

**② 인덱스 사용의 단점**

1.  DML에 취약  
    → 검색 위주의 테이블에 인덱스를 생성하는 것이 좋다.
2.  무조건 인덱스 스캔이 좋은 것이 아니다.  
    → 테이블 내 데이터 비율에 따라 선택적으로 인덱스를 적용하는 것이 좋다.
3.  인덱스의 과도한 생성은 좋지 않다.  
    → 인덱스 관리를 위해서는 데이터베이스의 약 10%에 해당하는 저장공간이 필요하므로 최소한의 필수적인 인덱스 생성을 권장한다.

**③ 인덱스 관리**

-   인덱스는 항상 최신 데이터를 정렬된 상태로 유지해야 원하는 값을 빠르게 탐색할 수 있다.
-   인덱스가 적용된 컬럼에 INSERT/UPDATE/DELETE가 수행되면 추가적인 연산이 필요하며 이에 따라 오버헤드가 발생한다.  
    \- INSERT : 새로운 데이터에 대한 인덱스를 추가한다.  
    \- DELETE : 삭제하는 데이터의 인덱스를 사용하지 않는다는 작업을 진행한다.  
    \- UPDATE : 기존의 인덱스를 사용하지 않음 처리하고, 갱신된 데이터에 대해 인덱스를 추가한다.

**④ 인덱스 사용**

-   Oracle

```
// 인덱스 생성
CREATE INDEX [INDEX NAME] ON [TABLE NAME](COLUMN1, COLUMN2, ...);

// 인덱스 조회
SELECT * FROM USER_INDEXES WHERE TABLE_NAME = '[TABLE NAME]';

// 인덱스 삭제
DROP [INDEX NAME];
```

-   PostgreSQL

```
// 인덱스 생성
CREATE INDEX [INDEX NAME] ON [TABLE NAME] USING BTREE(COLUMN1, COLUMN2, ...);

// 인덱스 조회
SELECT * FROM PG_INDEXES WHERE TABLENAME = '[TABLE NAME]';

// 인덱스 삭제
DROP [INDEX NAME];

// 인덱스 타는지 확인 (FULL SCAN / INDEX SCAN 으로 구분한다.)
EXPLAIN ANALYZE
SELECT
	*
FROM
	[TABLE NAME];
```

-   MySQL

```
// 인덱스 생성
CREATE INDEX [INDEX NAME] ON [TABLE NAME](COLUMN1, COLUMN2, ...);

// 인덱스 조회
SHOW INDEX FROM [TABLE NAME];

// 인덱스 삭제
ALTER TABLE [TABLE NAME] DROP INDEX [INDEX NAME];

// 인덱스 타는지 확인 (TYPE = ALL, POSSIBLE KEYS = NULL 인 경우 타지 않는다.)
EXPLAIN
SELECT
	*
FROM
	[TABLE NAME];
```

**⑤ 인덱스를 타지 않는 경우**

```
// 1. 인덱스 컬럼에 함수나 연산자가 사용된 경우
SELECT * FROM TABLE WHERE UPPER(NAME) = 'KIM';
SELECT * FROM TABLE WHERE NUM + 1 = 2;

// 2. LIKE 문에서 와일드카드가 문자열 앞에 위치하는 경우
SELECT * FROM TABLE WHERE NAME LIKE '%KIM';
SELECT * FROM TABLE WHERE NAME LIKE '%KIM%';

// 3. OR 절을 사용하는 경우
SELECT * FROM TABLE WHERE NAME = 'KIM' OR AGE = '20';

// 4. NULL 값을 사용하는 경우
SELECT * FROM TABLE WHERE NAME IS NULL;

// 5. 인덱스 컬럼을 다른 자료형의 컬럼과 비교하는 경우
SELECT * FROM TABLE1 JOIN TABLE2 ON TABLE1.AGE = TABLE2.YEAR;

// 6. IN 연산자 사용 시 IN 절에 포함된 데이터의 비율이 높은 경우
SELECT * FROM TABLE WHERE NAME IN ('KIM', 'LEE', ...);

// 7. 복합 인덱스인 경우 인덱스 순서가 지켜지지 않은 경우 (인덱스 순서 NAME -> AGE)
SELECT * FROM TABLE WHERE AGE = 20 AND NAME = 'KIM'
```

▷ 출처

[https://velog.io/@bagt/DB-Index%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC](https://velog.io/@bagt/DB-Index%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC)

[https://choicode.tistory.com/27](https://choicode.tistory.com/27)