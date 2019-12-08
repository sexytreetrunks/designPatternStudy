package PrototypePtn.framework;

public interface Product extends Cloneable {
    //java.lang 패키지에있는 Cloneable인터페이스. 얘를 상속받아야 clone()메소드(인스턴스를 자동으로 복제해주는 함수)를 사용할수있음
    public abstract void use(String s);
    public abstract Product createClone();
}
