package StrategyPtn;

import java.util.Random;

public class WinningStrategy implements Strategy{
    /* 직전 승부에서 이길경우 다음승부에 같은손을 보냄. 
     * 직전 승부에서 질경우 랜덤으로 다음손을 결정
     */
    private Random random;
    private boolean won = false;
    private Hand prevHand;
    
    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (won) {
            return prevHand;
        } else {
            prevHand = Hand.getHand(random.nextInt(3));
            return prevHand;
        }
    }

    @Override
    public void study(boolean win) {
        won = win;
    }

}
