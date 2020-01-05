package CommandPtn.drawer;

import java.awt.Point;

import CommandPtn.command.Command;

public class DrawCommand implements Command{
    private Point position;
    private Drawable m_drawable;

    public DrawCommand(Point position, Drawable m_drawable) {
        this.position = position;
        this.m_drawable = m_drawable;
    }
    
    @Override
    public void execute() {
        m_drawable.draw(position.x, position.y);
    }
}
