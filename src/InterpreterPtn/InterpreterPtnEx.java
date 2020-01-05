package InterpreterPtn;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import InterpreterPtn.interpreter.InterpreterFacade;
import InterpreterPtn.turtle.TurtleCanvas;

public class InterpreterPtnEx extends JFrame implements ActionListener {
    private TurtleCanvas canvas;
    private InterpreterFacade facade;
    private JTextField inputTextField;
    private JButton inputButton;
    
    public InterpreterPtnEx(String title) {
        super(title);
        
        canvas = new TurtleCanvas(400, 400);
        facade = new InterpreterFacade(canvas);
        inputTextField = new JTextField();
        inputButton = new JButton("show");
        
        canvas.setExecutor(facade);
        
        inputButton.addActionListener(this);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        Box box = new Box(BoxLayout.X_AXIS);
        box.add(inputTextField);
        box.add(inputButton);
        
        setLayout(new BorderLayout());
        add(box, BorderLayout.NORTH);
        add(canvas, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new InterpreterPtnEx("Interpreter pattern sample");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputButton) {
            String input = inputTextField.getText();
            if (input != null) {
                System.out.println("programText = "+input);
                facade.parse(input);
                canvas.repaint();
            }
        }
    }
}
