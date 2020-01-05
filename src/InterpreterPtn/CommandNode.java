package InterpreterPtn;

public class CommandNode extends Node{
    private CommandNode m_node;

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
}
