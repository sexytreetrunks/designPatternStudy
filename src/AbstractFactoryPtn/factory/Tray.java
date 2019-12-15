package AbstractFactoryPtn.factory;

import java.util.ArrayList;

public abstract class Tray extends Item {
    /*
     * 복수의 Link나 Tray를 모아서 합친것을 표시한 클래스
     */
    protected ArrayList<Item> tray = new ArrayList<>();
    /* 하위클래스에서 편하게 사용할수있도록 protected로 지정. 
     * private로하면 항상 getter로 불러와서 사용하게되어 불편하겟지만 캡슐화는 지켜지겠지
     */

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }
}
