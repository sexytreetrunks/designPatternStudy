# Iterator 패턴

## Iterator패턴이란?
먼저 우리가 배열을 사용할때 흔히 사용하는 코드를 보자

```java
int arr[] = new int[3];
for (int i=0;i<arr.length;i++) { //이 i는 arr배열안에있는 내용을 하나씩 검색하는 역할을함
    ...
}
```
위 코드의 루프문 안에 뭐가 들어있든간에 i는 arr배열안에 있는 내용을 하나씩 접근하여 사용할수있게함. 여기서 사용되는 변수 i의 기능을 추상화해서 일반화한것을 **Iterator패턴**이라함  
즉 Iterator패턴은 **배열처럼 어떠한 변수가 모여있는 것들을 순서대로 접근하면서 전체를 검색하는 처리를 실행하기 위한 것**임  

## Iterator패턴의 구성
Iterator패턴은 다음과같은 인터페이스와 클래스로 구성되어있음  
### Aggregate
집합체를 나타내는 인터페이스. Aggregate를 구현한 클래스는 배열이나 list같은 변수 집합체를 가지고있음. 얜 Iterator를 구현한 클래스의 인스턴스를 반환하는 iterator()메소드를 가지는데 이걸통해 집합체의 원소를 순차적으로 접근할거임
### Iterator
집합체(배열이나 리스트) 원소를 하나씩 접근하면서 검색을 실행하는 인터페이스
### ConcreteIterator
Iterator인터페이스를 구현한 클래스. 이 클래스는 순차적으로 접근할 요소(aggregate)와 순차접근을위한 index를 가지고있어야함
### ConcreteAggregate
Aggregate인터페이스를 구현한 클래스. iterator메소드를 통해 ConcreteIterator 인스턴스를 반환함  

## 왜 Iterator패턴을 쓰는거임? 걍 for문 쓰면안됨?
**집합체를 가지고있는 구현부와 해당 집합체에 순차적으로 접근하는 부분을 분리할수 있기때문**

이를 이해하기위해 아래의 코드를 보자

```java
    Iterator<Book> iterator = bookshelf.iterator();
    while(iterator.hasNext()) {
        System.out.println(iterator.next().getName());
    }
```
bookshelf의 내용을 순차적으로 접근하기위해 사용된건 iterator의 메소드들 뿐임. 즉 위코드는 Bookshelf의 구현에 전혀 의존하지 않음. 이는 우리가 Bookshelf의 구현부분을 수정하더라도 Iterator를 사용하는 코드에는 전혀 영향을 끼치지않는다는걸 의미함. 이를 확인하기위해 Bookshelf에있는 books를 배열이 아닌 Vector를 이용해서 구현해보고 메인메소드가 잘 돌아가는지 확인해봄(커밋참조)  

bookshelf의 iterator()메소드를 보면 리턴값이 구현클래스인 BookShelfIterator가 아닌 Iterator인걸 볼수있음. 이역시 코드수정시 영향을 적게하기위함(=코드결합도를 낮추기위함)임을 알수있음  