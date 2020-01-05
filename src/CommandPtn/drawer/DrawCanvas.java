package CommandPtn.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import CommandPtn.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {
    private MacroCommand history;
    private Color m_color;
    private int n_radius;

    public DrawCanvas(int width, int height, MacroCommand history) {
        this.setSize(width, height);
        this.setBackground(Color.WHITE);
        this.history = history;
        init();
    }

    @Override
    public void init() {
        m_color = Color.RED;
        n_radius = 6;
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(m_color);
        g.fillOval(x - n_radius, y - n_radius, n_radius * 2, n_radius * 2);
    }

    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    @Override
    public void setColor(Color color) {
        this.m_color = color;
    }
}
