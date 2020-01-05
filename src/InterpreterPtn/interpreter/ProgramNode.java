package InterpreterPtn.interpreter;

public class ProgramNode extends Node {
    private CommandListNode commandList;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandList = new CommandListNode();
        commandList.parse(context);
    }

    @Override
    public String toString() {
        return "[ program " + commandList.toString() + " ]";
    }

    @Override
    public void execute() throws ExecuteException {
        commandList.execute();
    }

}
