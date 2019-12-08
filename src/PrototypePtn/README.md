# Prototype pattern

## prototype패턴이란?
새로운 인스턴스를 생성할때 클래스로부터 인스턴스를 생성(`new 클래스이름()`)하는게 아닌 다른 인스턴스를 복사하여 새 인스턴스를 만드는 것  

## Prototype패턴의 구성
- Prototype: 인스턴스를 복사하여 새로운 인스턴스를 만들기위한 메소드(createClone)를 결정. Produect에 해당
- ConcretePrototype: Prototype을 구현한 클래스. MessageBox와 UnderlinePen이 해당
- Client: 인스턴스를 복사하는 메소드(Prototype의 createClone())를 이용하여 새로운 인슽턴스를 만듬. Manager

## 왜 필요함?
1. 종류가 너무 많아서 클래스로 정리할수 없는 경우
예제 프로그램처럼 여러가지 형태의 모형을 만들고자할때 이걸 각각 클래스로 만들면 관리하기 힘들어짐

2. 클래스로부터 인스턴스 생성이 어려운경우
도형에디터 어플리케이션이 해당. 

3. framework와 생성하는 인스턴스를 분리하고싶은 경우
클래스이름의 속박으로부터 fraomework를 분리할수 있음

근데 사실 3개 다 이해 잘 안감. 언제 어떻게 써야할지 잘 안떠오름

## 클래스 이름이 왜 속박임?
소스 내부에 이용할 클래스 이름이 쓰여있으면 그 클래스와 분리해서 재사용할수 없기 때문  
--> .java 소스파일없이 .class 파일만 가지고있더라도 그 클래스를 재사용할수있음  

## java의 cloneable과 clone메소드
- clone(): java.lang.Object에서 정의된 메소드로 인스턴스를 복사하여 반환함. 내부적으론 인스턴스와 같은 크기의 메모리를 확보해서 그 인스턴스의 필드 내용을 복사함  
- Cloneable: clone()메소드를 사용하려는 인스턴스의 클래스는 반드시 Cloneable이 구현되어 있어야함. (안그러면 CloneNotSupportedException나서 꼭 처리해줘야함)  
Cloneable은 내부에 메소드가 없는 인터페이스인데 단지 clone()에 의해 복사될수있다는걸 표시하기위한 인터페이스임. 이런걸 maker interface라고 함

