# observer pattern

## observer패턴이란?
observer는 '관찰자'라는 뜻을 가짐. observer패턴은 관찰대상의 상태가 변하면 관찰자에게 알려줌. observer패턴은 상태변화에 따른 처리를 기술할때 효과적인 패턴임.

## observer패턴의 구성
- Subject: 관찰되는 대상. subject는 observer를 등록하는 메소드와 삭제하는 메소드를 가지고 있음. 또 현재의 상태를 리턴하는 메소드도 갖고 있음. NumberGenerator가 해당
- ConcreteSubject: subject를 구체적으로 표현한 클래스. 자신의 상태가 변화하면 등록된 observer에 알림
- observer: subject로 부터 상태가 변했다고 전달받는 역할을 함. 이를 위한 메소드가 update임
- concreteObserver: 구체적인 observer. update메소드가 호출되면 subject의 현재상태를 취득하여 어떠한 동작을 수행.

## observer패턴 사용시 주의사항

### observer의 순서
예제 프로그램에서 NumberGenerator#notifyObservers()를 호출시 observer들의 update가 observer등록순으로 호출되는것을 볼수있음. 여기선 순서대로 호출해도 문제가 없지만 일반적으로 observer 클래스를 설계할 때에는 update메소드가 호출되는 순서가 변해도 문제가 일어나지 않도록 해야함  

### observer의 행위가 subject에 영향을 미칠때
일반적으로 observer는 subject에대해 상태변화를 알림을 **받기만**하지만(subject에서 observer의 메소드 호출) , 어떤 경우에선 반대로 observer가 subject 값을 변화시켜야 할떄도 있음. 이 경우 조심해서 설계하지 않으면 메소드 호출이 무한루프될 가능성이 있음. (ex - 안드로이드에서 two-way databinding을 사용할때) 

ex) subject의 상태가 변화--> observer에게 전달(observer의 메소드 호출) --> observer가 subject의 메소드 호출 --> 이것에 의해 subject의 상태가 변화 --> observer에게 전달 --> .... 

이를 방지하기 위해 **observer에게 현재 subject로부터 전달받고 있는중인지 아닌지를 나타내는 플래그 변수**를 갖도록 하는것이 좋음.

### observer의 갱신을 위해 필요한 정보
observer패턴을 사용하는 subject의 특성에 따라 observer#update에 적절한 정보를 넘겨주는게 좋음.

1. Case1. observer에게 subject를 넘겨줌
예제 프로그램에서 사용한 형태. 이렇게 하면 observer는 subject로부터 필요에 따라 값을 꺼내쓸수있음


```java
abstract class Observer {
    public abstract void update(NumberGenerator generator);
}
```

2. Case2. subject와 갱신정보를 넘겨줌
갱신정보를 함께 넘겨주면 subject역할로부터 정보를 얻는 시간을 줄일수있음


```java
abstract class Observer {
    public abstract void update(NumberGenerator generator, int number);
}
```

3. Case3. 갱신정보만 넘겨줌
이렇게하면 간단하고 동작도 되지만, 만약 observer가 복수의 subject를 관찰해야하는 경우에는 부적절함. 어떤 subject가 갱신되어 정보를 넘겨주는지 알수없기 때문


```java
abstract class Observer {
    public abstract void update(int number);
}
```

## publish-subscribe 패턴
observer는 subject로부터 능동적으로 값을 얻어오는 것이 아닌 전달되는것을 수동적으로 기다리고 있음. 이 때문에 publish-subscribe패턴이라고도 함  

## mvc와 observer패턴
MVC의 model과 view의 관계는 observer패턴의 subject와 observer 관계에 대응함. 

## java.util.Observer 인터페이스
java.util에 있는 Observer인터페이스와 Observable클래스는 observer패턴의 일종임. Observer인터페이스는 다음과 같은 인터페이스를 가지고있음  

```java
public void update(Observable obj, Object arg) // Case2와 유사한 형태(Subject와 갱신정보를 넘겨줌)
```

여기서 subject에 해당하는 Observable은 클래스이기 때문에(단일상속) subject역할의 클래스가 Observer를 사용하려면 Observable만 상속을 해서 사용해야하는 단점이 있음
