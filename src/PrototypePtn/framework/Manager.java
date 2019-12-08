package PrototypePtn.framework;

import java.util.HashMap;

public class Manager {
    /* 
     * 중요포인트: Product를 사용하는 Manager클래스에는 Product를 구현한 MessageBox와 Underline클래스가 전혀 나오지않음
     * 그 이유: 소스안에 클래스 이름을 쓰면 그 클래스와 밀접한 의존관계가 생기기 때문 -> Manager클래스를 독립적으로 수정할수없게됨
     */
    private HashMap<String, Product> showcase = new HashMap<>();
    
    public void register(String name, Product p) {
        showcase.put(name, p);
    }
    public Product create(String protoname) {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}
