package BuilderPtn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameBuilder extends Builder implements ActionListener {
    private JFrame frame = new JFrame();
    private Box box = new Box(BoxLayout.Y_AXIS);

    @Override
    protected void buildTitle(String title) {
        frame.setTitle(title);
    }

    @Override
    protected void buildString(String str) {
        box.add(new JLabel(str));
    }

    @Override
    protected void buildItems(String[] items) {
        Box innerBox = new Box(BoxLayout.X_AXIS);
        for (String item : items) {
            JButton button = new JButton(item);
            button.addActionListener(this);
            innerBox.add(button);
        }
        box.add(innerBox);
    }

    @Override
    protected void buildDone() {
        frame.getContentPane().add(box);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public JFrame getResult() {
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

}
