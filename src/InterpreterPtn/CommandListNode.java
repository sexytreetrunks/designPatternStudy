package InterpreterPtn;

import java.util.ArrayList;

public class CommandListNode extends Node {
    private ArrayList<CommandNode> nodeList = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw (new ParseException("Missing end"));
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                CommandNode commandNode = new CommandNode();
                commandNode.parse(context);
                nodeList.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return nodeList.toString();
    }

}
