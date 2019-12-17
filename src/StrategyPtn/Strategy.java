package StrategyPtn;

public interface Strategy {
    public abstract Hand nextHand(); //다음에 내는 손을 얻기 위한 메소드
    public abstract void study(boolean win); 
    /* 직전에 낸손(nextHand로 낸손)이 이겼는지 졌는지 학습하기위한 메소드. 
     * Strategy 구현체의 내부에 있는 필드를 변화시켜서 nextHand의 반환값을 결정하는 재료로 사용
     */
}
