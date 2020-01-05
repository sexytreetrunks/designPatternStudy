package InterpreterPtn.turtle;

public class DirectionExecutor extends TurtleExecutor {
    private int relative_direction;

    public DirectionExecutor(TurtleCanvas canvas, int relative_direction) {
        super(canvas);
        this.relative_direction = relative_direction;
    }

    @Override
    public void execute() {
        canvas.setRelativeDirection(relative_direction);
    }

}
