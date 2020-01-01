package FlyweightPtn;

public class BigString {
    private BigChar[] bigchars;

    public BigString(String str) {
        initShared(str);
    }

    public BigString(String str, boolean shared) {
        if (shared) {
            //this(str);//이거 안됨. 자기 자신의 생성자를 다른 생성자에서 호출하려면 반드시 첫줄에 호출해야함(위에 다른 statement가 있으면안됨)
            initShared(str);
        } else {
            initNotShared(str);
        }
    }

    private void initShared(String str) {
        bigchars = new BigChar[str.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i ++) {
            bigchars[i] = factory.getBigChar(str.charAt(i));
        }
    }

    private void initNotShared(String str) {
        bigchars = new BigChar[str.length()];
        for (int i = 0; i < bigchars.length; i ++) {
            bigchars[i] = new BigChar(str.charAt(i));
        }
    }

    public void print() {
        for (int i = 0; i < bigchars.length; i ++) {
            bigchars[i].print();
        }
    }
}
