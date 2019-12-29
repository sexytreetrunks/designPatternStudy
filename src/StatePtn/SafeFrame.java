package StatePtn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SafeFrame extends JFrame implements Context, ActionListener {
    // SafeFrame이 JFrame응 상속해야 하기 때문에 Context를 인터페이스로 설정하여 구현
    private JTextField textClock;
    private JTextArea textScreen;
    private JButton btnUse;
    private JButton btnAlarm;
    private JButton btnPhone;
    private JButton btnExit;

    private State state = DayState.getInstance();

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        textClock = new JTextField(60);
        textScreen = new JTextArea(10, 60);
        textScreen.setEditable(false);

        btnUse = new JButton("금고사용");
        btnAlarm = new JButton("비상벨");
        btnPhone = new JButton("일반통화");
        btnExit = new JButton("종료");

        btnUse.addActionListener(this);
        btnAlarm.addActionListener(this);
        btnPhone.addActionListener(this);
        btnExit.addActionListener(this);

        Panel panel = new Panel();
        panel.add(btnUse);
        panel.add(btnAlarm);
        panel.add(btnPhone);
        panel.add(btnExit);

        add(textClock, BorderLayout.NORTH);
        add(textScreen, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        Object btnSrc = e.getSource();
        if (btnSrc == btnUse) {
            state.doUse(this);
        } else if (btnSrc == btnAlarm) {
            state.doAlarm(this);
        } else if (btnSrc == btnPhone) {
            state.doPhone(this);
        } else if (btnSrc == btnExit) {
            System.out.println("종료..");
            System.exit(0);
        }
    }

    @Override
    public void setClock(int hour) {
        StringBuilder clockStr = new StringBuilder();
        clockStr.append("현재 시간은 ");
        if (hour < 10) {
            clockStr.append("0" + hour + ":00");
        } else {
            clockStr.append(hour + ":00");
        }
        System.out.println(clockStr.toString());
        textClock.setText(clockStr.toString());
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state + "에서 " + state + "로 상태가 바뀌었씁니다");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("CALL! " + msg + " \n");
    }

    @Override
    public void recordLog(String log) {
        textScreen.append("record log... " + log + "\n");
    }

}
