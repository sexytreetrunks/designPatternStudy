package FactoryMethodPtn;

import FactoryMethodPtn.framework.Factory;
import FactoryMethodPtn.framework.Product;
import FactoryMethodPtn.idcard.IDCardFactory;

public class FactoryMtdEx {
    public static void main(String[] args) {
        Factory f = new IDCardFactory();
        Product card1 = f.create("영희");
        card1.use();
        Product card2 = f.create("철쑤");
        card2.use();
        Product card3 = f.create("말숙");
        card3.use();
    }
}
