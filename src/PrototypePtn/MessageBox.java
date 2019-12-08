package PrototypePtn;

import PrototypePtn.framework.Product;

public class MessageBox implements Product {
    private char decoChar; 
    
    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }
    
    @Override
    public void use(String s) {
        int len = s.getBytes().length;
        for (int i = 0; i < len + 4; i ++) {
            System.out.print(decoChar);
        }
        System.out.println();
        System.out.println(decoChar + " " + s + " " + decoChar);
        for (int i = 0; i < len + 4; i ++) {
            System.out.print(decoChar);
        }
        System.out.println();
    }
    

    @Override
    public Product createClone() {
        /* clone() 메소드는 자신의 클래스 혹은 하위클래스에서만 호출할수 있기떄문에
         * 외부에서 호출하기위해선 이렇게 따로 메소드를 만들어줘야함
         */
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) { //Cloneable를 구현하지않은 클래스에서 호출시 CloneNotSupportedException이 남
            e.printStackTrace();
        }
        return p;
    }
}
