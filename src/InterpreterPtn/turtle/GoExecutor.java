package InterpreterPtn.turtle;

import InterpreterPtn.interpreter.ExecuteException;

public class GoExecutor extends TurtleExecutor {

    public GoExecutor(TurtleCanvas canvas) {
        super(canvas);
    }

    @Override
    public void execute() throws ExecuteException {
        canvas.go(TurtleCanvas.UNIT_LENGTH);
    }
}
