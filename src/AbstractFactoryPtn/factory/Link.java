package AbstractFactoryPtn.factory;

public abstract class Link extends Item {
    /*
     * html의 하이퍼링크를 추상적으로 표현한 클래스
     */
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
