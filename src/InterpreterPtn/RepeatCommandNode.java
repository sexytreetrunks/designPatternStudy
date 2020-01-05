package InterpreterPtn;

public class RepeatCommandNode extends CommandNode {
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
}
