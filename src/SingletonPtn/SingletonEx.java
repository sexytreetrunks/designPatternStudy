package SingletonPtn;

public class SingletonEx extends Thread{
    public SingletonEx(String name) {
        super(name);
    }

    public static void main(String[] args) {
        System.out.println("start.");
        new SingletonEx("A").start();
        new SingletonEx("B").start();
        new SingletonEx("C").start();
        System.out.println("end.");
    }

    @Override
    public void run() {
        //Singleton obj = Singleton.getInstance();
        Singleton obj = Singleton.getInstanceWithThreadSafe();
        System.out.println(getName()+": obj = "+obj);
    }
}
