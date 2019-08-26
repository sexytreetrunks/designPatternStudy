package AdapterPtn;

public class AdapterEx {//Client
    public static void main(String[] args) {
        //주의: PrintBanner가 아닌 Print인터페이스를 써야함 - PrintBanner는 어뎁터역할을 하는 구현체일뿐, 실제로 사용하는건 Print여야함
        //이렇게 하면 나중에 PrintBanner가 아니라 다르게 구현한 어뎁터 클래스를 사용하더라도 main은 코드 변경이 이루어지지않음
        //PrintBanner pb = new PrintBanner("example"); --> X
        Print p = new PrintBanner("example"); // --> O
        p.printWeak();
        p.printStrong();
        
        
        Print2 p2 = new PrintBanner2("example2");
        p2.printWeak();
        p2.printStrong();
    }
}
