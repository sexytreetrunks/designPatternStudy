package FactoryMethodPtn.framework;

public abstract class Product {//제품을 나타내는 클래스
    /* constructor는 추상클래스가 될수없다 -->추상메소드는 하위클래스에게 구현을 강제하도록 하는것
        만약 constructor인 Product메소드를 하위클래스가 구현하도록 강제한다면 IDCard클래스가 Product란 이름의 constructor를 구현해야함
    constructor는 클래스이름과 동일해야하기에 앞뒤가 안맞는 상황이 됨
    */
    //public abstract Product(String name); 
    public abstract void use();//제품을 무엇이든 use할수있는(사용할수있는) 것으로 규정함
}
