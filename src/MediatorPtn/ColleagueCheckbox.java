package MediatorPtn;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class ColleagueCheckbox extends JCheckBox implements ItemListener, Colleague {
    private Mediator mediator;
    public ColleagueCheckbox(String caption, boolean state) {
        super(caption, state);
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();//체크박스 상태가 바뀌면 mediator에게 통지
    }
    
}
