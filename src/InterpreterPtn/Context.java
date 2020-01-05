package InterpreterPtn;

import java.util.StringTokenizer;

public class Context {
    private StringTokenizer tokenizer;
    private String currToken;

    public Context(String input) {
        tokenizer = new StringTokenizer(input, " ");
        nextToken();
    }

    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currToken = tokenizer.nextToken();
        } else {
            currToken = null;
        }
        return currToken;
    }

    public String currentToken() {
        return currToken;
    }

    public void skipToken(String token) throws ParseException {
        if (token == null || !token.equals(currToken))
            throw new ParseException("Warning: " + token + " is expected, but " + currToken + " is found.");
        
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }
}
