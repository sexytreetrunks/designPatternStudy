package ObserverPtn;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int curNum = 0;
    private int start, end, step;

    public IncrementalNumberGenerator(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return curNum;
    }

    @Override
    public void execute() {
        for (int i = start; i <= end; i += step) {
            curNum = i;
            notifyObservers();
        }
    }

}
