package InterpreterPtn.turtle;

import InterpreterPtn.interpreter.Executor;

public abstract class TurtleExecutor implements Executor{
    protected TurtleCanvas canvas;

    public TurtleExecutor(TurtleCanvas canvas) {
        this.canvas = canvas;
    }

}
