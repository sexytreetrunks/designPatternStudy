package InterpreterPtn.interpreter;

public class PrimitiveCommandNode extends Node {
    private String name;
    private Executor m_executor;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        m_executor = context.createExecuter(name);
    }
    
    public String toString() {
        return name;
    }

    @Override
    public void execute() throws ExecuteException {
        if (m_executor == null)
            throw new ExecuteException(name +" is not defined");
        else 
            m_executor.execute();
    }
}
