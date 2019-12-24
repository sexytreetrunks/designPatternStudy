package MediatorPtn;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ColleagueTextField extends JTextField implements DocumentListener, Colleague {
    private Mediator mediator;

    public ColleagueTextField(String caption, int columns) {
        super(caption, columns);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.WHITE : Color.LIGHT_GRAY);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        mediator.colleagueChanged();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        mediator.colleagueChanged();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        mediator.colleagueChanged();
    }
}
