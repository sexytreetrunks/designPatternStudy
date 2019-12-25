# Memento pattern

## Memento패턴이란?
인스턴스의 상태를 저장하고 복원하기 위해 사용되는 패턴. 이 패턴을 사용하면 **undo(실행취소), redo(재실행), history(작업 이력의 작성), snapshot(현재 상태 저장)** 등을 실행할수있음.  

## memento패턴의 구성
- Originator: 자신의 현재상태를 저장하고 복원하기위해 memento를 이용. Gamer클래스가 담당
- Memento: originator의 내부 정보를 정리함. memento는 다음 두종류의 인터페이스를 가짐 
    + wide interface: 객체의 상태를 원래대로 되돌리기위해 필요한 정보를 모두 얻을수있는 인터페이스. 이 인터페이스는 memento역할의 내부상태를 모두 들어내기 때문에 originator만 사용 가능하도록 해야함
    + narrow interface: 외부의 caretaker에게 보여주기위한 인터페이스. 현재상태를 저장/복원하기위해 사용되는 최소한의 정보만 노출.

    위의 두개의 메소드를 구별해서 사용해야 캡슐화를 파괴하지않고 인스턴스 정보를 다룰수있음. 

- CareTaker: originator를 다루고 originator의 상태를 저장/복원하는 일을 함. 이때 Memento역할의 클래스를 한 블랙박스로써 통째로 저장해둘수는 있지만 memento의 내부 값을 변화시키는건 허용되지않고, 제한된 정보만 볼수있음. Memento역할은 caretaker에 대해 정보은폐를 수행하고 있음

## memento패턴과 java의 엑세스제어
예제프로그램에선 Memento가 originator(Gamer클래스)에게만 보이기위해 엑세스제어(public,protected,default,private)를 사용함.  
java의 엑세스제어를 이용하면 해당 필드, 메소드가 보이는 범위를 지정할수가 있음. 또한 이렇게 엑세스제어를 설정한 필드와 메소드를 허용되지않은 클래스에서 사용하게될경우 컴파일에러가 일어남. 이렇듯 엑세스제어는 캡슐화와 정보은닉을 구현하는데 아주 좋은 java의 기능임.

## CareTaker역할과 Originator역할을 분리하는 이유
caretaker는 **어느 시점**에서 스냅샷을 찍을지 결정하고, **언제** undo할지를 결정. originator는 memento역할을 만드는 일과 memento를 이용하여 자신의 상태를 되돌리는 일을 수행(memento를 통해 상태값을 직접 다루는 역할)

이렇게 역할분담을 해두면 undo뿐만아니라 redo, history, snapshot 등의 기능을 구현하도록 변경해도 originator의 역할을 변경할 필요가 없음

