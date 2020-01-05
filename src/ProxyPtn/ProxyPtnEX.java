package ProxyPtn;

public class ProxyPtnEX {
    public static void main(String[] args) {
        Printable printer = new PrintProxy("Printer");
        printer.setPrinterName("Alice");
        System.out.println("현재 " + printer.getPrintName() + " 입니다.");
        printer.setPrinterName("Bob");
        System.out.println("현재 " + printer.getPrintName() + " 입니다.");
        printer.print("Hello, world");
    }
}
