# Abstract Factory pattern

## abstract factory패턴이란?
abstract factory를 직역하면 추상적인 공장이라는 뜻. 우리가 일반적으로 알고있는 구체적인 제품을 만드는 공장이 아님. 추상적인 부품을 이용하여 추상적인 제품을 만드는 공장임. 구체적으로 말하자면 abstract factory가 abstract나 interface형태의 제품을 만들고 외부에선 이를 구현한 하위클래스가 아닌 이 추상클래스만 가지고 사용하도록 하는것임.  
templete method패턴과 builder패턴에서 추상적인 메소드를 이용하여 프로그래밍을 했다면, 여기선 인터페이스만을 사용해서 프로그래밍(부품 조립, 제품완성)을 하고 이렇게 만들어진 추상클래스 혹은 인터페이스를 사용함. 그리고 **하위클래스는 얘가 하는 행동을 구체화시킬뿐 전체 프로그래밍 동작에 관여하지않음**.  

## abstract factory패턴의 구성
- AbstractProduct: AbstractFactory 역할에 의해 만들어지는 추상적인 부품이나 제품의 인터페이스. Link, Tray, Page클래스가 이에 해당됨
- AbstractFactory: AbstractProduct를 만들어내기 위한 인터페이스. Factory클래스가 이에 해당됨
- Client: AbstractFactory와 AbstractProduct만을 사용하여 주어진 역할을 실행함. client는 구체적인 제품,부품,공장(ListFactory, TableFactory)에 대해선 모름
- ConcreteProduct
- ConcreteFactory

## abstract factory의 특징
abstract factory패턴에서 새로운 구체적인 공장을 만드는건 간단함. 그냥 factory패키지의 인터페이스들을 구현하기만 하면됨. 또한 이를사용하는 client또한 수정할필요가없음  
하지만 기존의 factory에 새로운 부품을 추가하는건 매우 어려움. 해당 부품에 대응되는 각 concreteProduct를 생성해야하기 때문임. 이는 이미 만들어진 concreteFactory가 많을수록 수정해야할 코드가 더 많아짐.  

# 잠깐 샛길로 

## private vs protected

상위클래스에서 필드를 정의할때 하위클래스에서 편하게 사용하기위해 protected로 설정하는 경우가 있음. 근데 이건 못된습관임.   
protected로 필드를 설정하게되면 하위클래스에서 필드에 직접 접근하게 되고 이는 상위클래스-하위클래스간 의존성을 강화함  
따라서 번거롭게 엑세스용 메서드를 만들더라도 private으로 설정하는게 바람직함  

## java에서 인스턴스를 만드는 방법
1. new 생성자 이용해서 만들기  
`Something obj = new Something();`  
- 가장 일반적인 방법.

2. clone 이용하기
Prototype패턴에 나온 clone매소드를 이용하면 이미 존재하는 인스턴스를 이용하여 새로운 인스턴스를 만들수있음  

```java
class Something{

    public Something createClone() {
        Something obj = null;
        try {
            obj = (Something) this.clone();
        } catch(ClassNotSupportedException e) {
            // error handling
        }
        return obj;
    }
}
```
3. newInstance 이용하기
java.lang.Class에 있는 newInstance 메소드를 이용하면 클래스명으로 인스턴스를 만들수있음  

> 주의!)
Class.newInstance() 는 java9 이상부턴 deprecated됨. 따라서 newInstace사용시 getDeclaredConstructor()를 이용해야함  

```java
try {
    Something obj = Something.class.getDeclaredConstructor().newInstance();
} catch (InstantiationException e1) {
    // error handling
} catch (IllegalAccessException e2) {
    // error handling
} catch (InvocationTargetException e3) {
    // error handling
}
```

기존의 newInstance()는 기본생성자만 가져올수있었음. 하지만 이보다 더 중요한 단점은 newInstance를 사용하는 코드에서 exception 체크를 우회하는 위험성을 갖고있다는거임. 
즉 Class#newInstance 로 불러오는 생성자 내에서 exception이 발생할경우 이를 사용하는 코드는 이에대한 exception 체크 및 핸들링을 할수가 없음. 따라서 exception은 발생하지만 어떠한 exception도 나타나지않는 기이한 현상이 발생함. [여기 나온 답변에 자세히 설명되어있음](https://stackoverflow.com/questions/195321/why-is-class-newinstance-evil#answer-53014482)  

Class#getDeclaredConstractor 를 이용해서 newInstance를 사용하게되면 위와같은 상황의 exception을 InvocationTargetException 을 통해 캐치할수있음. 따라서 java9 미만 버전이더라도 getDeclaredConstrctor를 이용해서 newInstance를 사용하는것을 권장함.  