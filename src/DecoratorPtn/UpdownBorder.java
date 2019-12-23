package DecoratorPtn;

public class UpdownBorder extends Border {
    private char decoChar;
    
    protected UpdownBorder(Display display, char ch) {
        super(display);
        this.decoChar = ch;
    }

    @Override
    public int getColums() {
        return display.getColums();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRows() + 1)
            return makeLine(decoChar, display.getColums());
        else
            return display.getRowText(row - 1);
    }

    private String makeLine(char ch, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i ++)
            builder.append(ch);
        return builder.toString();
    }
}
