package StatePtn;

public class EmergencyState implements State {
    /* 이사양의 문제점:
     * 언제 normal state(day,night,lunch)로 돌아가는지에대한 명확한 사양이 없음
     * 따라서 시간이 바뀌면 emergencystate에 충분히 머무르지 못한채 바로 다른 state로 넘어가게됨
     */
    private static EmergencyState singleton = new EmergencyState();
    
    private EmergencyState() {}
    
    public static EmergencyState getInstance() {
        return singleton;
    }
    
    @Override
    public void doClock(Context context, int hour) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상: 비상상태");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(비상사태)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("비상통화(비상사태)");
    }

}
