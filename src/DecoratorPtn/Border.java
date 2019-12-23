package DecoratorPtn;

public abstract class Border extends Display {
    /*
     * display를 필드로 사용하는데 display를 상속하는 이유?
     * -> 장식(display를 상속한 border)과 내용물(display필드)이 동일한 메소드를 가짐으로써 인터페이스 적으로 장식과 내용물을 동일시할수 있음
     */
    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}
