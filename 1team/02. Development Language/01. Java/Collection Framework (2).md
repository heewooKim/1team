### **Java Collection Framework (2)**

-   데이터를 저장하는 자료구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현해놓은 것
-   개발자가 인스턴스화하여 사용한다.

![Java Collection Framework](https://github.com/heewooKim/1team/assets/65803251/01b499f3-666f-40ba-a4d5-6d6ee6a72fd1)

**5\. Set Interface**

-   데이터의 중복을 허용하지 않고 순서를 유지하지 않는 데이터의 집합 리스트
-   get(index) 메소드가 존재하지 않으므로 Iterator로 요소를 하나씩 불러온다.

**① HashSet Class**

-   가장 빠른 임의 검색 속도를 가진다.
-   추가/삭제/검색/접근성이 모두 뛰어나다.
-   순서가 없다.

```
Set<Integer> hashSet = new HashSet<>();

hashSet.add(1);
hashSet.add(2);
hashSet.add(5);

System.out.println("result : " + hashSet + ", size : " + hashSet.size());

Iterator<Integer> iterator = hashSet.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next() + " ");
}
```

**② LinkedHashSet Class**

-   순서를 가진다.
-   추가된 순서 또는 최근에 접근한 순서대로 요소에 접근할 수 있다.

```
Set<String> linkedHashSet = new LinkedHashSet<>();

linkedHashSet.add("망고");
linkedHashSet.add("사과");
linkedHashSet.add("수박");

System.out.println("result : " + linkedHashSet + ", size : " + linkedHashSet.size());

Iterator<String> iterator = linkedHashSet.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next() + " ");
}
```

**③ TreeSet Class**

-   이진 검색 트리 구조 형태로 데이터를 저장한다.
-   중복을 허용하지 않고 순서를 가지지 않는다.
-   데이터를 정렬하여 저장한다.
-   정렬, 검색, 범위 검색에 높은 성능을 가진다.

```
Set<Integer> treeSetInteger = new TreeSet<>();

treeSetInteger.add(5);
treeSetInteger.add(1);
treeSetInteger.add(15);
treeSetInteger.add(12);

System.out.println(treeSetInteger);

Set<String> treeSetString = new TreeSet<>();

treeSetString.add("망고");
treeSetString.add("키위");
treeSetString.add("수박");
treeSetString.add("복숭아");

System.out.println(treeSetString);
```

**④ EnumSet Abstract Class**

-   Enum Class와 함께 동작하는 Set Collection이다.
-   중복되지 않는 상수 그룹을 나타내는데 사용한다.
-   산술 비트 연산을 사용하여 구현되므로 HashSet보다 훨씬 빠르며 적은 메모리를 사용한다.
-   Enum 타입의 요소값만 저장할 수 있고 모든 요소들은 동일한 Enum 객체에 소속되어야 한다.
-   EnumSet 추상 클래스를 상속한 RegularEnumSet 또는 JumboEnumSet 객체를 사용한다.

```
enum Day {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

EnumSet<Day> enumSet = EnumSet.allOf(Day.class);

for (Day day : enumSet) {
    System.out.println(day);
}

System.out.println(enumSet);
```

**6\. Map Interface**

-   키와 값의 쌍으로 이루어진 데이터의 집합
-   값은 중복이 가능하며 키는 고유해야 한다.
-   순서가 유지되지 않는다.
-   값은 중복이 허용되므로 Collection 타입으로 반환하고 키는 중복이 허용되지 않으므로 Set 타입으로 반환한다.

**① Map.Entry Interface**

-   Map 인터페이스의 내부 인터페이스
-   Key-Value 쌍의 Node 내부 클래스가 구현하고 있다.
-   Map 자료구조를 보다 객체지향적으로 설계하도록 유도하기 위한 것이다.

```
Map<String, Integer> hashMap = new HashMap<>();

hashMap.put("one", 1);
hashMap.put("two", 2);
hashMap.put("five", 5);

Set<Map.Entry<String, Integer>> mapEntry = hashMap.entrySet();

System.out.println(mapEntry);

for (Map.Entry<String, Integer> map : mapEntry) {
    System.out.printf("{ %s : %d } ", map.getKey(), map.getValue());
}
```

**② HashMap Class**

-   중복을 허용하지 않고 순서를 보장하지 않는다.
-   키와 값으로 null이 허용된다.
-   추가/삭제/검색/접근성이 뛰어나다.
-   비동기로 작동하기 때문에 멀티쓰레드 환경에서는 어울리지 않는다. (대신 ConcurrentHashMap 사용)

```
Map<String, Integer> hashMap = new HashMap<>();

hashMap.put("Kim", 1);
hashMap.put("Lee", 2);
hashMap.put("Park", 3);

for (String key : hashMap.keySet()) {
    System.out.println("key : " + key + ", value : " + hashMap.get(key));
}
```

**③ LinkedHashMap Class**

-   HashMap을 상속하며 데이터의 순서를 보장하는 데에서 차이점이 있다.

```
//  [2] HashMap Class

Map<String, Integer> hashMap = new HashMap<>();

hashMap.put("Kim", 1);
hashMap.put("Lee", 2);
hashMap.put("Park", 3);

for (String key : hashMap.keySet()) {
    System.out.println("key : " + key + ", value : " + hashMap.get(key));
}

//  [3] LinkedHashMap Class

Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

linkedHashMap.put("Kim", 1);
linkedHashMap.put("Lee", 2);
linkedHashMap.put("Park", 3);

for (String key : linkedHashMap.keySet()) {
    System.out.println("key : " + key + ", value : " + linkedHashMap.get(key));
}
```

**④ TreeMap Class**

-   이진 검색 트리 구조 형태로 키와 값의 쌍으로 이루어진 데이터를 저장
-   SortedMap 인터페이스를 구현하여 Key 값을 기준으로 정렬된다.
-   정렬된 순서로 데이터를 저장하므로 빠른 검색(특히 범위 검색)이 가능하다.
-   데이터를 저장하는 동시에 정렬을 행하므로 저장 시간이 다소 오래 걸린다.
-   정렬 순서는 숫자 - 알파벳 대문자 - 알파벳 소문자 - 한글 순이다.

```
Map<String, Integer> treeMap = new TreeMap<>();

treeMap.put("김", 1);
treeMap.put("Lee", 2);
treeMap.put("박", 3);
treeMap.put("choi", 4);
treeMap.put("5", 5);

for (String key : treeMap.keySet()) {
    System.out.println("key : " + key + ", value : " + treeMap.get(key));
}
```

**⑤ HashTable Class**

-   Key를 특정 해시 함수를 통해 해싱한 후 그 결과를 배열의 인덱스로 사용하여 Value를 찾는 방식으로 동작한다.
-   HashMap보다는 느리지만 동기화가 지원된다.

```
Map<String, Integer> hashtable = new Hashtable<>();

hashtable.put("Kim", 1);
hashtable.put("Lee", 2);
hashtable.put("Park", 3);

for (String key : hashtable.keySet()) {
    System.out.println("key : " + key + ", value : " + hashtable.get(key));
}
```

**⑥ Properties Class**

-   Properties(String, String) 형태로 저장하는 단순화된 Key-Value 컬렉션
-   주로 애플리케이션 환경 설정과 관련된 속성 파일인 .properties 를 설정하는데 사용된다.

```
// 1. properties 파일에 property 저장하기
        
Properties properties1 = new Properties();

properties1.put("Title", "Hello World");

Path propertiesFile = Paths.get("setting.properties");

try (Writer propertiesWriter = Files.newBufferedWriter(propertiesFile)) {
    properties1.store(propertiesWriter, "Property File");
} catch (IOException e) {
    System.out.println("IOException Occured");
}

// 2. properties 파일로부터 property 값 가져오기

FileInputStream inputStream = null;
try {
    inputStream = new FileInputStream("setting.properties");
} catch (FileNotFoundException e) {
    System.out.println("FileNotFoundException Occured");
}

Properties properties2 = new Properties();
try {
    properties2.load(inputStream);
} catch (IOException e) {
    System.out.println("IOException Occured");
}

System.out.println(properties2);

System.out.println(properties2.getProperty("Title"));
```

▷ 출처

[https://inpa.tistory.com/entry/JCF-%F0%9F%A7%B1-Collections-Framework-%EC%A2%85%EB%A5%98-%EC%B4%9D%EC%A0%95%EB%A6%AC](https://inpa.tistory.com/entry/JCF-%F0%9F%A7%B1-Collections-Framework-%EC%A2%85%EB%A5%98-%EC%B4%9D%EC%A0%95%EB%A6%AC)

[https://ittrue.tistory.com/153](https://ittrue.tistory.com/153)