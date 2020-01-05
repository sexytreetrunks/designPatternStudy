package InterpreterPtn.interpreter;

public class InterpreterFacade implements Executor {
    private ExecuterFactory m_factory;
    private Context m_context;
    private Node programNode;

    public InterpreterFacade(ExecuterFactory factory) {
        this.m_factory = factory;
    }

    public boolean parse(String text) {
        boolean ok = true;
        m_context = new Context(text);
        m_context.setExecutorFactory(m_factory);
        programNode = new ProgramNode();
        try {
            programNode.parse(m_context);
            System.out.println(programNode.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @Override
    public void execute() throws ExecuteException{
        try {
            if (programNode == null) return;

            programNode.execute();
            
        } catch (ExecuteException e) {
            e.printStackTrace();
        }
    }
}
