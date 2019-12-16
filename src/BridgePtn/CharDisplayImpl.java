package BridgePtn;

public class CharDisplayImpl extends DisplayImpl{
    private char openChar, decoChar, closeChar;

    public CharDisplayImpl(char openChar, char decoChar, char closeChar) {
        this.openChar = openChar;
        this.decoChar = decoChar;
        this.closeChar = closeChar;
    }

    @Override
    public void rawOpen() {
        System.out.print(openChar);
    }

    @Override
    public void rawPrint() {
        System.out.print(decoChar);
    }

    @Override
    public void rawClose() {
        System.out.println(closeChar);
    }

}
