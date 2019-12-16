package BridgePtn;

public class NestingCountDisplay extends CountDisplay {

    public NestingCountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void nestCountDisplay(int times, int step) {
        for (int i = 0, count = 0; i < times; i++) {
            multiDisplay(count);
            count = count + step;
        }
    }

}
