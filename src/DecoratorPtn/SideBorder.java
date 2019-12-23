package DecoratorPtn;

public class SideBorder extends Border{
    private char borderChar;
    public SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }
    @Override
    public int getColums() {
        return 1 + display.getColums() + 1;
    }
    @Override
    public int getRows() {
        return display.getRows();
    }
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
