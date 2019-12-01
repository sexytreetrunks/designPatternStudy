package SingletonPtn;

public class Singleton {
    private static Singleton singleton = null;
    private Singleton() {
        System.out.println("인스턴스 생성");
        try {
            Thread.sleep(1000);//복수의 인스턴스가 생성되는지 확인하기위해 실행속도를 늦춤
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //Thread safe하지 않은 싱글톤 구현
    public static Singleton getInstance() { 
        if(singleton==null) //이 if문이 실행되는 시점에 다른 스레드가 실행되어 이 if문을 실행할경우 복수의 인스턴스가 생성될수있음
            singleton = new Singleton();
        return singleton;
    }
    //synchronized를 이용하여 thread safe 보장
    public static synchronized Singleton getInstanceWithThreadSafe() {
        if(singleton==null)
            singleton = new Singleton();
        return singleton;
    }
}
