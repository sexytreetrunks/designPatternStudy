package StrategyPtn;

import java.util.Random;

public class ProbStrategy implements Strategy{
    /* 다음손은 언제나 랜덤으로 결정하나 과거 승패의 이력에 따라 손을 낼 확률을 바꿈  
     * history에 담긴 값(승패 이력을 저장한 배열)에 따라 다음에 낸 손의 확률을 계산
     */

    private Random random;
    private int prevHandValue = 0;
    private int currHandValue = 0;
    private int[][] history = { //history[이전에낸손][다음에낼손] 을 의미. 해당 배열에 담긴 값이 클수록 이길확률이 큼
            {1,1,1},
            {1,1,1},
            {1,1,1}
    };
    
    public ProbStrategy(int seed) {
        random = new Random(seed);
    }
    

    @Override
    public Hand nextHand() { 
        // history[currHandValue] 행에 있는 값들을 더한뒤 각 행의 값에 따라 확률을 배분
        int bet = random.nextInt(getSum(currHandValue));
        int handvalue;
        if (bet < history[currHandValue][0]) {
            handvalue = 0;
        } else if (bet < history[currHandValue][1]) {
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        return Hand.getHand(handvalue);
    }

    @Override
    public void study(boolean win) {
        // 이겼을경우 이전에 낸값-현재값 일때 확률을 증가, 졌을경우 이전값-현재값을 제외한 부분에 확률을 증가
        if (win) {
            history[prevHandValue][currHandValue] ++;
        } else {
            history[prevHandValue][(currHandValue + 1) % 3] ++;
            history[prevHandValue][(currHandValue + 2) % 3] ++;
        }
    }

    private int getSum(int handValue) {
        int sum = 0;
        for (int i = 0; i < 2; i ++)
            sum += history[handValue][i];
        return sum;
    }
}
