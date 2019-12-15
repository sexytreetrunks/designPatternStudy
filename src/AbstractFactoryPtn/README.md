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

