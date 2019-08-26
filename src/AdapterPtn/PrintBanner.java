package AdapterPtn;

//상속을이용한 adapter패턴 : Banner클래스(기존에 있던거)를 상속하여 Print인터페이스(필요한거)를 구현
public class PrintBanner extends Banner implements Print{//adapter
    public PrintBanner(String str) {
        super(str);
    }

    @Override
    public void printWeak() {
        super.showWithParen();
    }

    @Override
    public void printStrong() {
        super.showWithAster();
    }
}
