# Adapter 패턴

## Adpater 패턴이란?
**이미 제공되어있는것**을 그대로 사용할수 없을때 **필요한 형태**로 바꾸어 사용하기 위한 패턴
adapter패턴에는 다음과 같은 종류가 있음  
- 클래스에 의한 Adapter패턴(상속을 사용)
- 인스턴스에 의한 Adapter패턴(위임을 사용)

#### 상속을 사용한 adapter패턴
Banner, Print, PrintBanner 참조  
Banner가 이미 제공되어있는 기능을 가지고있는 클래스를 담당. 필요한 형태는 Print라는 **인터페이스**로 구현. 어뎁터패턴을 구현한 PrintBanner가 두개이상의 클래스를 상속받을수 없기에 필요한 형태를 가진 Print는 인터페이스로 구현하여 PrintBanner가 구현할수있도록 함  

#### 위임(인스턴스)를 사용한 adapter패턴
Banner, Print2, PrintBanner2 참조  
여기서도 Banner역할은 똑같은데 Print2는 **추상클래스**로 구현. 그리고 어뎁터인 PrintBanner2를 구현할때 Print2를 상속받고 Banner는 멤버변수로 만들어 사용  

> 여기서 주의할점은 adapter패턴을 구현한뒤 사용할땐 Print, Print2를 이용해야한다는점임. 어뎁터를 구현한 PrintBanner, PrintBanner2는 인스턴스를 생성할때만 사용되고 구현된 메소드를 사용하는건 Print,Print2를 통해서 해야함. 아래는 예시  
```java
PrintBanner pb = new PrintBanner("example");// --> X. 잘못된 사용. PrintBanner는 기존에있는 코드를 필요한형태로 구현한 놈일뿐 실제로 사용되는, 필요로하는 놈이 아님
Print p = new PrintBanner("example");// --> O. 올바른 사용. Print인터페이스자체가 목적(실제 사용하려는놈)이고 PrintBanner는 이를 위해 구현한것일 뿐임. 또한 이렇게 사용하면 나중에 새로 다르게 구현된 어뎁터 클래스를 사용하더라도 Print를 이용한 코드는 소스 변경이 이루어지지않음
p.printWeak();
p.printStrong();
```

## adapter패턴의 구성
- Target : 지금 필요한 메소드를 가지고있음: Print인터페이스, Print2클래스
- Client: Target을 사용해서 일하는 역할. main메소드를 가진 AdapterEx가 해당. 
- Adaptee: 이미 준비되어있는(제공되어있는) 메소드를 가지고있는 역할: Banner클래스
- Adapter: Adaptee역할의 메소드를 사용하여 Target의 역할을 만족시키기 위한 역할. 즉 Adaptee를 이용하여 Target을 구현한 클래스가 됨

## 왜 Adapter패턴을 쓰는거임? 걍 새로 짜면안됨?
1. 재사용
인생은 그렇게 호락호락하지 않기에 항상 새로짜는 경우만 있는건 아님. 만약 타겟과 유사한 기능을 가진 구현체가 있다면, 그리고 그게 충분한 테스트를 거치고 최근까지도 사용되어 왔다면 그걸 부품으로 **재사용**하는게 효율적일수있음. 또한 충분히 검증된 부품을 재사용할경우 버그가 발생했을때 조사하기가 쉬워짐(해당 부품을 사용한부분은 버그가 없다는게 확인되므로)

2. 버전 호환성
소프트웨어를 버전 업할 때 구 버전과의 호환성이 문제가 됨. adapter패턴을 이용하면 구버전과 신버전을 공존시키고 유지보수를 편하게 할수있음  
ex) 신버전만 유지보수하고싶을때 신버전을 adaptee역할로 하고 구버전을 target으로 하는거

*adapter패턴은 기존의 소스(Adaptee)를 전혀 수정하지않고 목적한 인터페이스(Target)에 맞추는 것임!* 
