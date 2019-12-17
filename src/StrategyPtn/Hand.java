package StrategyPtn;

public class Hand {
    public static final int HANDVALUE_ROCK = 0;
    public static final int HANDVALUE_SISSER = 1;
    public static final int HANDVALUE_PAPER = 2;

    public static final Hand[] hand = {
            new Hand(HANDVALUE_ROCK),
            new Hand(HANDVALUE_SISSER),
            new Hand(HANDVALUE_PAPER)
    };

    private static final String[] name = {
            "가위", "바위", "보"
    };

    private int handvalue;

    private Hand(int handvalue) {
        this.handvalue = handvalue;
    }

    public static Hand getHand(int handvalue) {
        return hand[handvalue];
    }

    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) {
        if (this == h) //인스턴스가 3개만 만들어지기 떄문에 굳이 value값을 비교하지않아도 인스턴스로 비교해도됨
            return 0;
        else if ((this.handvalue + 1) % 3 == h.handvalue)
            return 1;
        else
            return -1;
    }
    
    public String toString() {
        return name[handvalue];
    }
}
