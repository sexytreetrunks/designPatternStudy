package ProxyPtn;

public class PrintProxy implements Printable {
    private String name;
    private Printable real;
    private String className;
    
    public PrintProxy(String className) {
        this.className = className;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        //PrintProxy와 Printer의 name이 둘다 같은 값으로 지정되는걸 보장하기위해 synchronized사용
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        //Printer의 객체를 생성하는 작업이 시간이 걸리는 작업이기 때문에 멀티스레드환경에서 중복 객체생성을 방지하기 위함
        if (real == null) {
            try {
                //AbstractFactory처럼 사용할 realSubject도 부품처럼 사용할수있음. 단 eclipse에서 말고 직접 javac로 컴파일하여 돌릴것
                real = (Printer) Class.forName(className).newInstance();
                real.setPrinterName(name);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
