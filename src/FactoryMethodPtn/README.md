# Factory Method

## Factory Method패턴이란?
인스턴스를 생성을 Templete method패턴으로 구현한게 factory method패턴임  
인스턴스를 만드는 방법을 상위클래스에서 결정하지만 구체적인 클래스 이름은 하위클래스에서 결정하도록 하는 패턴  

## Factory Method패턴의 구성
- Product: 이 패턴에서 생성되는 인스턴스가 가져야할 인터페이스(API). framework에 해당
- Creator: Product를 생성하는 역할을하는 추상클래스이고 이것도 framework에 해당. 어떤 인스턴스를 생성하는가는 추상메소드에서 구현하도록하여 *구체적인 클래스 이름에대한 속박에서 상위클래스를 자유롭게 만듬*
- ConcreteProduct: 구체적인 제품 구현((추상메소드 구현)
- ConcreteCreator: 구체적인 제품을 만드는(인스턴스를 생성하는) 공장

## Framework와 구체적인 내용
Factory method패턴은 '추상적인 골격(framework)'과 '구체적인 내용'을 구현하는게 분리되어있음  
만약 idcard가 아닌 TV제품과 TV제품을 만드는 공장을 만든다고 생각해보셈.  
기존의 framework패키지를 이용하여 TV클래스와 TVFactory를 만든다 하더라도 framework를 수정하지 않아도 됨. *즉 framework패키지는 idcard패키지(혹은 TV패키지)에 의존하고있지 않음.*   

## factory의 추상메소드(createProduct()) 구현방법
Factory의 createProduct()는 실제로 인스턴스를 생성하는 중요한 부분이지만 구현은 하위클래스에서 해야함. 하위클래스에서 인스턴스를 구현하지 않았을때를 대비한 처리가 상위클래스에서 필요함

1. 추상메소드로 하기
추상메소드로 해놓으면 하위클래스에서 구현이 강제가 되기때문에 구현여부를 컴파일할때 체크할수있음
2. 디폴트 구현 준비해두기
디폴트로 Product인스턴스를 리턴하게 하는방법. 하지만 Product가 추상클래스기때문에 요건 안됨
3. 에러 이용하기
디폴트 구현내용을 에러로 처리해두면 하위클래스에서 구현하지 않았을때 에러가 발생함. 아래는 예시

```java
class Factory {
    public Product createProduct(String owner) {
        throw new FactoryMethodRuntimeException();//요 exception은 사용자가 별도로 만들어야함
    }
}
```

