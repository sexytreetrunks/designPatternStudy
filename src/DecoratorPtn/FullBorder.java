package DecoratorPtn;

public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColums() {
        return 1 + display.getColums() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRows() + 1)
            return '+' + makeLine('-', display.getColums()) + '+';
        else
            return '|' + display.getRowText(row - 1) + '|';
    }

    private String makeLine(char ch, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i ++)
            builder.append(ch);
        return builder.toString();
    }
}
