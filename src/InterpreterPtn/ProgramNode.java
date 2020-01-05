package InterpreterPtn;

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

}
