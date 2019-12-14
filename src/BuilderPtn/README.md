# Builder pattern

## Builder 패턴이란?
어떠한 구조를 가진 인스턴스를 만들기위해(build) 각 부분을 만들어내는 메소드를 호출하여 해당 인스턴스를 만들어내는 패턴형식

## builder패턴의 구성
- Builder: 인스턴스를 생성하기위한 인터페이스를 결정. Builder안에는 인스턴스의 각 부분을 만들기위한 메소드(makeTitle, makeString 등등..)가 있음  
- ConcreteBuilder: Builder를 구현한 클래스. 여기서 각 부분을 만드는 메소드들을 구현하고 최종결과물을 얻기위한 메소드(getResult)를 만듬  
- Director: Builder 인스턴스를 사용해서 인스턴스를 생성. 단 여기서 ConcreteBuilder에 의존하지않음(ConcreteBuilder 클래스를 사용하지않고 Builder의 메소드만 이용하여 인스턴스 생성)
- Client: Builder패턴을 이용하는 역할. Director를 이용하여 인스턴스를 만들고, ConcreteBuilder의 getResult로 최종결과물을 가져옴

## builder패턴이 주는 교훈
builder패턴의 예제코드를 보면 소스의 주요 골격에 해당하는 Client와 Director가 인스턴스를 만드는 동작(ConcreateBuilder의 메소드들)과 독립적으로 돌아가는걸 알수있음.  
쉽게 설명하자면 Client(BuilderEx)는 인스턴스를 만들기위해 Director.construct()만 알면되고, Director는 Builder의 하위메소드(TextBuilder, HTMLBuiler)를 알필요가 없음.  
이렇게 핵심동작을 수행하는 메소드에 대해 다른 클래스들이 적게 알수록 쉽게 교체할수있음(=교환가능성이 높음). 교환가능성이 높을수록 변화에 적응하기 쉬운 코드임. 이는 클래스 설계시 반드시 염두해두어야함  

