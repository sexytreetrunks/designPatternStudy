package SingletonPtn;

public class ThreadSafeSingleTon {
    private static ThreadSafeSingleTon m_instance;
    
    private ThreadSafeSingleTon() {
        System.out.println("instance created.");
    }
    
    public synchronized static ThreadSafeSingleTon getInstance() {
        if (m_instance == null) { //멀티스레드환경에서 다수의 인스턴스가 생성되는걸 방지하기위해 synchronized를 사용함(thread-safe 방식)
            m_instance = new ThreadSafeSingleTon();
        }
        return m_instance;
    }
}
