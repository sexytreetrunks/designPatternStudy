package FactoryMethodPtn.framework;

public abstract class Factory {//제품을 만드는 공장
    //final 사용해서 하위클래스에서 변경못하도록 하는거 잊지마셈
    public final Product create(String owner) {//제품을 만드는 역할을 하는 메소드
        Product p = createProduct(owner);//createProduct로 제품을 만들어서
        registerProduct(p);//registerProduct에 제품을 등록
        return p;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
