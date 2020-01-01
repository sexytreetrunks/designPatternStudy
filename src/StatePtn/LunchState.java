package StatePtn;

public class LunchState implements State {
    private static LunchState singleton = new LunchState();

    private LunchState() {}

    public static LunchState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (DayState.isDay(hour))
            context.changeState(DayState.getInstance());
        else if (NightState.isNight(hour))
            context.changeState(NightState.getInstance());
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상: 점심시간 금고 사용");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(점심)");
        context.changeState(EmergencyState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("점심통화 녹음");
    }

    public String toString() {
        return "[점심]";
    }

    public static boolean isLunch(int hour) {
        if (12 <= hour && hour < 13)
            return true;
        else
            return false;
    }
}
