package CommandPtn;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import CommandPtn.command.Command;
import CommandPtn.command.MacroCommand;
import CommandPtn.drawer.ColorCommand;
import CommandPtn.drawer.DrawCanvas;
import CommandPtn.drawer.DrawCommand;

public class CommandPtnEx extends JFrame implements ActionListener, ItemListener {
    private MacroCommand history;
    private DrawCanvas m_canvas;
    private JButton clear_button;
    private JButton undo_button;
    private Checkbox red_checkbox;
    private Checkbox blue_checkbox;
    private Checkbox green_checkbox;

    public CommandPtnEx(String title) {
        super("title");

        history = new MacroCommand();
        m_canvas = new DrawCanvas(400, 400, history);
        clear_button = new JButton("clear");
        undo_button = new JButton("undo");

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clear_button);
        buttonBox.add(undo_button);
        
        CheckboxGroup group = new CheckboxGroup();
        red_checkbox = new Checkbox("red", group, true);
        blue_checkbox = new Checkbox("blue", group, false);
        green_checkbox = new Checkbox("green", group, false);
        
        Box checkboxBox = new Box(BoxLayout.X_AXIS);
        checkboxBox.add(red_checkbox);
        checkboxBox.add(blue_checkbox);
        checkboxBox.add(green_checkbox);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(checkboxBox);
        mainBox.add(m_canvas);

        getContentPane().add(mainBox);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        m_canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                Command c = new DrawCommand(p, m_canvas);
                history.append(c);
                c.execute();
            }
        });
        
        clear_button.addActionListener(this);
        undo_button.addActionListener(this);
        red_checkbox.addItemListener(this);
        blue_checkbox.addItemListener(this);
        green_checkbox.addItemListener(this);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear_button) {
            history.clear();
            m_canvas.init();
            m_canvas.repaint();
        } else if(e.getSource() == undo_button) {
            history.undo();
            m_canvas.repaint();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == red_checkbox) {
            Command c = new ColorCommand(m_canvas, Color.RED);
            history.append(c);
            c.execute();
        } else if (e.getSource() == blue_checkbox) {
            Command c = new ColorCommand(m_canvas, Color.BLUE);
            history.append(c);
            c.execute();
        } else if (e.getSource() == green_checkbox) {
            Command c = new ColorCommand(m_canvas, Color.GREEN);
            history.append(c);
            c.execute();
        }
    }

    public static void main(String[] args) {
        new CommandPtnEx("");
    }

}
