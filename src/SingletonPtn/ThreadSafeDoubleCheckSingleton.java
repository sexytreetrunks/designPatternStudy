package SingletonPtn;

public class ThreadSafeDoubleCheckSingleton {
    private static ThreadSafeDoubleCheckSingleton m_instance;
    
    private ThreadSafeDoubleCheckSingleton() {
        System.out.println("instance created.");
    }
    
    public static ThreadSafeDoubleCheckSingleton getInstance() {
        if (m_instance == null) {
            synchronized (ThreadSafeDoubleCheckSingleton.class) {
                //새 인스턴스를 만들때만 synchronized 블럭에 진입하도록하여 다수의스레드가 동시에 접근하였을때 성능이 저하되는것을 완화
                if (m_instance == null) {
                    m_instance = new ThreadSafeDoubleCheckSingleton();                
                }
            }
        }
        return m_instance;
    }
}
