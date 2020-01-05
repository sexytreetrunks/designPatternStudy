package InterpreterPtn.interpreter;

public class CommandNode extends Node{
    private Node m_node;

    @Override
    public void parse(Context context) throws ParseException {
        if ("repeat".equals(context.currentToken())) {
            m_node = new RepeatCommandNode();
            m_node.parse(context);
        } else {
            m_node = new PrimitiveCommandNode();
            m_node.parse(context);
        }
    }

    @Override
    public String toString() {
        return m_node.toString();
    }

    @Override
    public void execute() throws ExecuteException {
        m_node.execute();
    }
}
