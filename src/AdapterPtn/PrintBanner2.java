package AdapterPtn;

//banner를 인스턴스롤 사용하는 adapter패턴에서는 인터페이스가 아닌 추상클래스로 Print2(target)를 만든뒤 타겟을 만족시키는 PrintBanner2(adapter)를 구현함
//따라서 main에서 사용시엔 Print2를 사용하고 구현체인 PrintBanner는 인스턴스 만들때만 사용되는거
public class PrintBanner2 extends Print2{
    private Banner banner;
    public PrintBanner2(String str) {
        banner = new Banner(str);
    }
    
    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
