package CommandPtn.drawer;

import java.awt.Color;

import CommandPtn.command.Command;

public class ColorCommand implements Command {
    private Color m_color;
    private Drawable m_drawable;
    
    public ColorCommand(Drawable drawable) {
        this.m_drawable = drawable;
    }
    
    public ColorCommand(Drawable drawable, Color color) {
        this.m_drawable = drawable;
        this.m_color = color;
    }
    
    public void setColor(Color color) {
        this.m_color = color;
    }

    @Override
    public void execute() {
        m_drawable.setColor(m_color);
    }

}
