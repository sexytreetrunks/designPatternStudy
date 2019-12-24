package MediatorPtn;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;

public class LoginFrame extends JFrame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(4, 2));
        createColleague();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        pack();
    }

    @Override
    public void createColleague() {
        ButtonGroup group = new ButtonGroup();
        checkGuest = new ColleagueCheckbox("Guest", true);
        checkLogin = new ColleagueCheckbox("Login", false);
        group.add(checkGuest);
        group.add(checkLogin);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.getDocument().addDocumentListener(textUser);
        textPass.getDocument().addDocumentListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.isSelected()) { //guest모드 일경우 text를 disable시킴
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    private void userpassChanged() {
        if (textUser.getText().length() >= 4 && textPass.getText().length() >= 4) {//user명 입력을 해야 password창이 활성화되도록
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {//password를 입력해야 ok버튼이 활성화되도록
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

}
