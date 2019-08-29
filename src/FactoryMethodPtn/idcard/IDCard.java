package FactoryMethodPtn.idcard;

import FactoryMethodPtn.framework.Product;

public class IDCard extends Product{
    String owner;
    
    //construct의 접근생성자를 default로 하여 동일 패키지에서만 접근 가능하게 함. 즉 IDCardFactory만 접근 가능하도록 함
    /*public */IDCard(String owner) {
        System.out.println(owner+"의 카드를 만듬니다");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner+"의 카드를 사용합니다");
    }

    public String getOwner() {
        return owner;
    }
}
