# Decorator pattern

## decorator패턴이란?
기본 스펀지케이크에 딸기로 장식(decorate)하면 딸기케익이되고, 크림으로 장식하면 생크림케잌이 되듯이  
객체도 중심이되는 객체에 기능을 하나씩 장식처럼 추가해나가는 디자인패턴을 decorator패턴이라 함  

## decorator패턴의 구성
- Component: 기능 추가시 핵심이 되는 역할, 가장 기본적인 기능틀만 가진 클래스로 인터페이스만 결정함. Display클래스가 해당
- ConcreateComponent: component역할의 인터페이스를 구현하고있는 클래스. StringDisplay가 해당
- Decorator: component역할과 동일한 인터페이스를 가지며 decorator역할이 장식할 되상이되는 component의 역할도 가지고 있음. border클래스가 해당
- ConcreteDecorator: decorator를 구현한 클래스. SideBorder, Fullborder가 해당

## decorator패턴의 특징

### 투과적인 인터페이스
예제에서 Decorator역할을 하는 클래스인 Border를 보면 display를 필드로 가지면서 display를 상속하여 display와 동일한 인터페이스를 가짐. 이를 투과적이라고 함. 이렇게 투과적인 특징때문에 b4처럼 장식을 겹겹이 쌓아놔도 인터페이스는 바뀌지 않음. 또한 composite패턴처럼 재귀적인 구조를 가짐. 즉, 장식이 둘러싸는 내용물이 실제로는 다른 장식이 되는 구조. 이런점에서 composite패턴과 유사하지만 decorator패턴은 **장식을 중복해서 기능을 추가**해나가는거에 주안점을 둠.  

### 내용을 바꾸지않아도 기능을 추가할수있음  
decorator패턴은 장식과 내용물이 공통의 인터페이스를 가짐. 장식을 추가할수록 기능은 계속 추가되지만 인터페이스는 항상 동일함. 즉 내용물을 변경하지않고 기능을 추가할수있음. 이렇게 새 기능을 추가하는데 내용변경이 적게 일어나는 이유는 decorator패턴이 위임을 사용하고 있기 때문. 위임은 클래스사이를 느슨하게 결합함으로써 framework의 소스를 변경하지 않고 객체관계를 변경한 새로운 객체를 만들수있음

### 다양한 기능 추가 but 비슷한 작은클래스의 증가
decorator패턴에선 다양한 기능을 자유롭게 조합해서 새로운 객체를 만들수있음. 하지만 기능이 다양해 질수록 유사한 성질의 작은 클래스가 많이 만들어지는 단점이 있음. 

## decorator패턴의 적용
decorator패턴을 적용한 대표적인 예는 java.io패키지에있는 입출력 클래스들이 있음. 

아래의 코드는 파일에서 데이터를 읽어들이는 인스턴스를 만듬  
```java
Reader reader = new FileReader("datafile.txt");
```

여기에 BufferedReader로 장식하면 데이터를 읽을때 버퍼를 사용
```java
Reader reader = new BufferedReader(new FileReader("datafile.txt"));
```

LineNumberReader로 또 장식하면 행번호를 관리할수있음  
```java
Reader reader = new LineNumberReader(new BufferedReader(new FileReader("datafile.txt")));
```

만약 파일이 아닌 네트워크에서 데이터를 읽도록 변경한다면 이렇게 인자로 넣어주는 객체만 바꾸면됨  
```java
java.net.Socket socket = new Socket(hostname, portnumber);

Reader reader = new LineNumberReader(new BufferedReader(new InputStreamReader(socket.getInputStream())));
```
위코드에서 inputstream을 reader클래스 형태로 사용하기위해 getInputStream()에서 나온 값을 인자로 InputStreamReader객체를 생성. 이는 adapter패턴에 해당됨.

## 여기서 잠깐, 상속의 동일시 vs 위임의 동일시

### 상속의 동일시

서로 상속관계에 있는 두 클래스가 있을때 child의 인스턴스는 parent형의 변수에 그대로 대입할수있음. 
또한 child의 인스턴스는 parent의 메소드를 그대로 호출할수있음
```java
Parent obj = new Child();
obj.parentMethod();
((Child)obj).childMethod(); //child메소드 사용시 형변환이 필요
```

이렇게 상속관계에선 하위클래스는 상위클래스와 동일시하여 사용할수있음  

### 위임의 동일시
위임관계에선 자신과 위임할 곳(내용물)을 동일시할수있음

```java
class Rose{
    Violet obj = ..
    void method() {
        obj.method();
    }
}
```

```java
class Violet {
    void method() {
        ...
    }
}
```
 
 Rose와 violet은 동일한 메소드를 가지고 rose의 메소드의 구현을 violet에 위임하고 있지만 메소드를 자세히 들여다보지 않는이상 둘이 연결되있다는걸 확인하기 힘듬. 하지만 이 둘에게 공통의 추상클래스(혹은 인터페이스)가 있으면 결속이 강해짐

```java
abstract class Flower {
    abstract void method();
}
```

```java
class Rose extends Flower{
    Violet obj = ..
    void method() {
        obj.method();
    }
}
```

```java
class Violet extends Flower{
    void method() {
        ...
    }
}
```