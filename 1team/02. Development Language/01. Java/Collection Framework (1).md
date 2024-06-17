### **Java Collection Framework (1)**

-   데이터를 저장하는 자료구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현해놓은 것
-   개발자가 인스턴스화하여 사용한다.

![Java Collection Framework](https://github.com/heewooKim/1team/assets/65803251/01b499f3-666f-40ba-a4d5-6d6ee6a72fd1)

**1\. Iterable Interface**

-   Collection Interface들의 가장 최상위 Interface

**2\. Collection Interface**

-   List, Set, Queue에 상속을 하는 실질적인 최상위 컬렉션  타입
-   업캐스팅으로 다양한 종류의 컬렉션 자료형을 받아 자료 삽입/삭제/탐색 기능을 할 수 있다.

```
Collection<Number> c1 = new ArrayList<>();
c1.add(1);

Collection<Number> c2 = new ArrayList<>();
c2.add(2);
c1.addAll(c2);

Collection<Number> c3 = new ArrayList<>();
c3.add(3);

System.out.println(c1);
System.out.println(c2);
System.out.println(c3);
```

**3\. List Interface**

-   저장 순서가 유지된다.
-   중복 요소 존재가 가능하다.
-   index로 요소에 접근한다.
-   크기가 동적으로 변화한다.
-   요소 사이에 빈 공간을 허용하지 않아 삽입/삭제 시 배열 이동이 일어난다.

**① ArrayList Class**

-   단방향 포인터 구조로 자료에 대해 순차적인 접근이 가능하여 조회가 빠르다.
-   삽입/삭제가 느리지만 순차적인 삽입/삭제의 경우에는 가장 빠르다. 

```
List<String> arrayList = new ArrayList<>();

arrayList.add("Hello");
arrayList.add("World");

System.out.println(arrayList);
System.out.println(arrayList.get(0));

arrayList.set(0, "Hello~");

System.out.println(arrayList);
```

**② LinkedList Class**

-   노드(객체)를 연결하여 리스트처럼 만든 컬렉션
-   데이터 중간 삽입/삭제가 빈번할 경우 빠른 성능을 보인다.
-   임의의 요소에 대한 접근 성능은 좋지 않다.
-   양방향 포인터 구조이다.
-   리스트, 스택, 큐, 트리 등 자료구조의 근간이 된다.

```
List<String> linkedList = new LinkedList<>();

linkedList.add("Hello");
linkedList.add("World");

System.out.println(linkedList);
System.out.println(linkedList.get(0));

linkedList.set(0, "Hello~");

System.out.println(linkedList);
```

**③ Vector Class**

-   ArrayList의 구형 버전으로 잘 쓰이지 않는다.

**④ Stack Class**

-   후입선출(LIFO) 구조
-   Vector Class를 상속하므로 잘 안쓰이며 대신 ArrayDeque Class를 사용한다.

**4\. Queue Interface**

-   선입선출(FIFO) 구조

**① PriorityQueue Class**

-   우선 순위 큐
-   원소에 우선 순위를 부여하여 우선 순위가 높은 순으로 정렬되고 꺼낸다.
-   여러 개의 작업과 시간 제한이 있을 경우 우선 순위대로 수행할 때 쓰인다.  
    ex. 네트워크 제어, 작업 스케줄링
-   저장 객체는 필수적으로 Comparable Interface로 구현해야하는데 compareTo() 메소드 로직에 따라 객체의 우선 순위를 결정하는 식으로 동작되기 때문이다.
-   저장 공간으로 배열을 사용하며, 각 요소를 힙 형태로 저장한다.
-   null 저장이 불가능하다.

```
public class User implements Comparable<User> {

    String name;
    int priority;

    public User(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(User student) {

        if (this.priority < student.priority) {
            return -1;
        } else if (this.priority == student.priority) {
            return 0;
        } else {
            return 1;
        }

    }

    @Override
    public String toString() {

        return "User name : " + name + " priority : " + priority;

    }

}
```

```
Queue<User> priorityQueue = new PriorityQueue<>();

priorityQueue.add(new User("박정민", 1));
priorityQueue.add(new User("고윤정", 5));
priorityQueue.add(new User("이동욱", 2));

System.out.println(priorityQueue);

System.out.println(priorityQueue.peek());

System.out.println(priorityQueue.poll());
System.out.println(priorityQueue.poll());
System.out.println(priorityQueue.poll());
System.out.println(priorityQueue.poll());
```

**4\. Deque(Double-Ended Queue) Interface**

-   양쪽으로 넣고 빼는 것이 가능한 큐
-   스택과 큐를 하나로 합쳐놓은 것이다.

**① ArrayDeque Class**

-   크기에 제한이 없다.
-   null 저장이 불가능하다.

```
Deque<Integer> deque = new ArrayDeque<>();

deque.offerFirst(1);
deque.offerFirst(5);
deque.offerLast(10);
deque.offerLast(2);

System.out.println(deque);

deque.pollFirst();
deque.pollLast();

System.out.println(deque);
```

**② LinkedList Class**

-   List Interface와 Queue Interface를 동시에 상속받고 있으므로 스택/큐 로서 응용이 가능하다.
-   큐 동작과 관련된 메소드를 지원한다.

```
Queue<String> linkedListQueue = new LinkedList<>();

linkedListQueue.offer("Hello");
linkedListQueue.offer("World");

System.out.println(linkedListQueue);

linkedListQueue.poll();

System.out.println(linkedListQueue);
```

▷ 출처

-   [https://inpa.tistory.com/entry/JCF-%F0%9F%A7%B1-Collections-Framework-%EC%A2%85%EB%A5%98-%EC%B4%9D%EC%A0%95%EB%A6%AC](https://inpa.tistory.com/entry/JCF-%F0%9F%A7%B1-Collections-Framework-%EC%A2%85%EB%A5%98-%EC%B4%9D%EC%A0%95%EB%A6%AC)
-   [https://velog.io/@wi\_\_\_s10/Java-Java-collection-framework](https://velog.io/@wi___s10/Java-Java-collection-framework)