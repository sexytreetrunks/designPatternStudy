package StatePtn;

public interface State {
    //금고의 상태를 나타내는 클래스
    /*
     * 아래의 메소드들은 금고의 상태에 따라 처리가 변하는 메소드들
     * --> 즉, state인터페이스는 상태의존 인터페이스들의 집합
     */
    public void doClock(Context context, int hour);
    public void doUse(Context context);
    public void doAlarm(Context context);
    public void doPhone(Context context);
}
