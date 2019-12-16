# Bridge pattern

## bridge패턴이란?
클래스 계층(상위, 하위클래스로 나눠지는 계층을 뜻함)은 두가지 역할이 있음 
- 기능의 클래스 계층: 기존 클래스에 새로운 기능을 추가하고싶을때 기존 클래스를 extend한 하위클래스를 생성함으로써 생긴 클래스 계층  
    + 상위클래스: 기본적인 기능을 가진 클래스
    + 하위클래스: 상위클래스에 있는 기능 + 새로운 기능이 추가된 클래스
- 구현의 클래스 계층: templete method패턴, abstract builder패턴처럼 상위클래스에선 추상메소드로 인터페이스를 규정하고, 하위클래스에서 이를 구현하도록하여 클래스 계층이 생김. 
    + 상위클래스: 추상메소드에 의해 인터페이스를 규정
    + 하위클래스: 상위클래스에서 규정된 인터페이스를 구현

하위클래스를 만들땐 위의 두개중 어떤 의도를 가지고 만들건지 확인해야함. 만약 위 두가지 의도가 하나의 계층에 혼재하게 되면 클래스의 계층과 구현이 복잡해지게됨. 따라서 기능의 클래스계층과 구현의 클래스 계층을 두개의 독립된 클래스 계층으로 분리할 필요가 있음. 이렇게 분리된 두 계층을 이어주는 역할을 하는게 bridge패턴임  

## bridge패턴의 구성
- Abstraction: 기능의 클래스계층의 최상위 클래스. Implementor를 필드로 가지고, Implementor의 메소드를 이용하여 기본적인 기능만 기술되어있음. Display클래스가 해당
- RefinedAbstraction: Abstraction에 기능을 추가한 역할. CountDisplay가 이에 해당
- Implementor: 구현의 클래스 계층의 최상위 클래스. Abstractor역할의 인터페이스를 구현하기위한 메소드를 규정. DisplayImpl가 이에 해당
- ConcreteImplementor: Implementor를 구현한 클래스. StringDisplayImpl가 해당.

이렇게 기능의 클래스계층인 display와 구현의 클래스계층인 DisplayImpl를 연결하기 위해 DisplayImpl를 Display의 필드로 사용하고있음  

## 왜 필요함?
- 분리하면 확장이 편해지니까. 새 클래스를 만들어서 기능추가를 하더라도 구현클래스계층은 수정할 필요가 없음. 즉 기능의 클래스계층과 구현의 클래스계층을 독립적으로 확장시킬수 있음. 

## 상속은 견고한 연결이고 위임은 느슨한 연결이다
상속은 클래스를 확장하기 위해 편리한 방법이지만 클래스간의 연결을 강하게 고정시킴.  

```java
class SomethingGood extends Something {
    ...
}
```
Something클래스에서 무언가를 수정하면 SomethingGood은 이에 맞춰 소스코드를 고쳐쓰지않는이상 바꿀수없는 견고한 연결이 됨. 
따라서 기능이나 디자인 수정이 자주 일어나는 프로그램이라면 상속보단 위임을 사용해야함.  

```java
class Something {
    SomethingImpl impl;

    public method1() {
        impl.implMethod();
    }
}
```
Something클래스는 SomethingImpl형 필드를 가지고 있어서 자신의 메소드를 구현할때 SomethingImpl의 메소드로 떠넘기고 있음. 이것을 위임이라고 함.  

