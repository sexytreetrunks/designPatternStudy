package ObserverPtn;

public class ObserverPtnEx {
    public static void main(String[] args) {
        NumberGenerator gen = new RandomNumberGenerator();
        Observer o1 = new DigitObserver();
        Observer o2 = new GraphObserver();
        Observer o3 = new FrameObserver();
        gen.addObserver(o1);
        gen.addObserver(o2);
        gen.addObserver(o3);
        gen.execute();
    }
}
