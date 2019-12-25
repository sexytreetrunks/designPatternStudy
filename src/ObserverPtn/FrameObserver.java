package ObserverPtn;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FrameObserver extends JFrame implements Observer, ActionListener {
    private GraphText textGraph = new GraphText();
    private GraphCanvas canvasGraph = new GraphCanvas();
    private JButton buttonCancel = new JButton("close");

    public FrameObserver() {
        super("frame observer");
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);
        textGraph.setEditable(false);
        canvasGraph.setSize(500, 500);
        add(textGraph, BorderLayout.NORTH);
        add(canvasGraph, BorderLayout.CENTER);
        add(buttonCancel, BorderLayout.SOUTH);
        buttonCancel.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void update(NumberGenerator generator) {
        textGraph.update(generator);
        canvasGraph.update(generator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Program exit.");
        System.exit(0);
    }

    class GraphText extends JTextField implements Observer {
        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber();
            StringBuilder builder = new StringBuilder();
            builder.append(number + ":");
            for (int i = 0; i < number; i ++)
                builder.append('*');
            setText(builder.toString());
        }
    }

    class GraphCanvas extends Canvas implements Observer {
        private int number;

        @Override
        public void update(NumberGenerator generator) {
            number = generator.getNumber();
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            g.setColor(Color.WHITE);
            g.fillArc(0, 0, width, height, 0, 360);
            g.setColor(Color.RED);
            g.fillArc(0, 0, width, height, 90, -number * 360 / 50);
        }

    }
}
