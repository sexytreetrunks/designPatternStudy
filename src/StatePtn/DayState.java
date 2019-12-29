package StatePtn;

public class DayState implements State{
    //상태가 변화할때마다 새로 인스턴스를 만들게되면 메모리와 시간이 낭비되므로 싱글톤으로 구현
    private static DayState singleton = new DayState();
    
    private DayState() {}
    
    public static DayState getInstance() {
        return singleton;
    }
    

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 8 || 21 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고사용 주간");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반통화(주간)");
    }
    
    public String toString() {
        return "[주간]";
    }
}
