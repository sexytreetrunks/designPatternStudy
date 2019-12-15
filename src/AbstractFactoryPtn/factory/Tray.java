package AbstractFactoryPtn.factory;

import java.util.ArrayList;

public abstract class Tray extends Item {
    /*
     * 복수의 Link나 Tray를 모아서 합친것을 표시한 클래스
     */
    protected ArrayList<Item> tray = new ArrayList<>();
    /* protected vs private
     * protected: 하위클래스에서 쓰기편함. 
     * private: Tray의 하위클래스(ListTray, TableTray)가 상위클래스에 의존하지 않음 (상위클래스의 필드를 직접 사용하는건 의존성이 큼)
     *          하지만 상위필드를 쓰기위한 getter,setter를 구현해서 사용해야함. 하지만 번거롭더라도 private을 이용하여 상위클래스간 의존성을 없애는게 훨씬 바람직
     */

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }
}
