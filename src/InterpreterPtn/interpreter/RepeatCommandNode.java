package InterpreterPtn.interpreter;

public class RepeatCommandNode extends Node {
    private int number;
    private CommandListNode nodeList;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        nodeList = new CommandListNode();
        nodeList.parse(context);
    }

    @Override
    public String toString() {
        return "[ repeat " + number + " " + nodeList + " ]";
    }

    @Override
    public void execute() throws ExecuteException {
        for (int i = 0; i < number; i ++) {
            nodeList.execute();
        }
    }
}
