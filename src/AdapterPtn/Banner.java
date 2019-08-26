package AdapterPtn;

public class Banner {//Adaptee(이미 준비되어있는 메소드를 가지고있는 쪽)
    private String str;
    public Banner(String str) {
        this.str = str;
    }
    public void showWithParen() {
        System.out.println("(" +str + ")");
    }
    
    public void showWithAster() {
        System.out.println("*" + str +"*");
    }
}
