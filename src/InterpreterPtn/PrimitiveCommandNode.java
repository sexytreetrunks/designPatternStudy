package InterpreterPtn;

public class PrimitiveCommandNode extends CommandNode {
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if (!isValid(name)) {
            throw new ParseException(name + " is undefined.");
        }
    }
    
    private boolean isValid(String str) {
        if ("go".equals(str) || "right".equals(str) || "left".equals(str)) {
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        return name;
    }
}
