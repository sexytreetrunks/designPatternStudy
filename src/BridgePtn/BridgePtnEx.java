package BridgePtn;

public class BridgePtnEx {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Korea"));
        Display d2 = new Display(new StringDisplayImpl("Hello, World"));

        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe"));
        
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("Hello, Infinite"));
        
        Display d5 = new Display(new TextDisplayImpl("Hello, Treetrunks", "hello"));
        
        NestingCountDisplay d6 = new NestingCountDisplay(new CharDisplayImpl('<', '*', '>'));
        NestingCountDisplay d7 = new NestingCountDisplay(new CharDisplayImpl('|', '#', '-'));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
        d4.randomDisplay(4);
        d5.display();
        d6.nestCountDisplay(4, 1);
        d7.nestCountDisplay(6, 2);
    }
}
