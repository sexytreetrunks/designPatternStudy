package AbstractFactoryPtn.factory;

public abstract class Item {
    /*
     * Link와 Tray를 동일하게 취급하기위해 사용되는 클래스
     * Link와 Tray는 이 클래스르 extends해서 구현하게됨
     */
    protected String caption;
    public Item(String caption) {
        this.caption = caption;
    }
    public abstract String makeHTML();
}
