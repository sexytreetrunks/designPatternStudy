package InterpreterPtn.turtle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import InterpreterPtn.interpreter.Executor;
import InterpreterPtn.interpreter.ExecuteException;
import InterpreterPtn.interpreter.ExecuterFactory;

public class TurtleCanvas extends Canvas implements ExecuterFactory {
    final static int UNIT_LENGTH = 30; //움직일때 단위 길이
    final static int DIRECTION_UP = 0;
    final static int DIRECTION_RIGHT = 3;
    final static int DIRECTION_DOWN = 6;
    final static int DIRECTION_LEFT = 9;
    final static int RELATIVE_DIRECTION_RIGHT = 3;//현재방향을 기준으로 오른쪽
    final static int RELATIVE_DIRECTION_LEFT = -3;//현재방향을 기준으로 왼쪽
    final static int RADIUS = 3;

    private int direction = 0;
    private Point position;
    private Executor m_executor;

    public TurtleCanvas(int width, int height) {
        setSize(width, height);
        init();
    }

    private void init() {
        Dimension size = getSize();
        position = new Point(size.width / 2, size.height / 2);
        direction = 0;
        setForeground(Color.red);
        setBackground(Color.white);
        Graphics g = getGraphics();
        if (g != null) {
            g.clearRect(0, 0, size.width, size.height);
        }
    }

    public void setExecutor(Executor executor) {
        m_executor = executor;
    }

    void setRelativeDirection(int relativeDirection) {
        setDirection(direction + relativeDirection);
    }

    void setDirection(int direction) {
        if (direction < 0) {
            direction = 12 - (-direction) % 12;
        } else {
            direction = direction % 12;
        }
        this.direction = direction;
    }

    void go(int length) {
        int new_x = position.x;
        int new_y = position.y;

        switch (direction) {
            case DIRECTION_UP:
                new_y += length;
                break;
            case DIRECTION_RIGHT:
                new_x += length;
                break;
            case DIRECTION_DOWN:
                new_y -= length;
                break;
            case DIRECTION_LEFT:
                new_x -= length;
                break;
        }

        Graphics g = getGraphics();
        if (g != null) {
            g.drawLine(position.x, position.y, new_x, new_y);//선 그리기
            g.fillOval(new_x - RADIUS, new_y - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1); //점 그리기
        }
        position.x = new_x;
        position.y = new_y;
    }

    @Override
    public void paint(Graphics g) {
        init();
        if (m_executor != null) {
            try {
                m_executor.execute();
            } catch (ExecuteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Executor createExecuter(String name) {
        if ("go".equals(name)) {
            return new GoExecutor(this);
        } else if ("right".equals(name)) {
            return new DirectionExecutor(this, RELATIVE_DIRECTION_RIGHT);
        } else if ("left".equals(name)) {
            return new DirectionExecutor(this, RELATIVE_DIRECTION_LEFT);
        } else {
            return null;
        }
    }

}
