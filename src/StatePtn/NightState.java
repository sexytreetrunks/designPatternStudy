package StatePtn;

public class NightState implements State {
    private static NightState singleton = new NightState();

    private NightState() {}

    public static NightState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (LunchState.isLunch(hour)) {
            context.changeState(LunchState.getInstance());
        } else if (DayState.isDay(hour)) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상: 야간금고 사용!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야간)");
        context.changeState(EmergencyState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야간통화 녹음");
    }

    public String toString() {
        return "[야간]";
    }

    public static boolean isNight(int hour) {
        if (hour < 8 || 21 <= hour)
            return true;
        else
            return false;
    }
}
