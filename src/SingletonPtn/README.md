# Singleton Pattern

## Singleton패턴이란? 
인스턴스가 한개밖에 존재하지 않는 것을 보증하는 패턴

## singleton클래스의 구현
싱글톤패턴을 구현한 클래스인 싱글톤클래스만 구현하면됨  
싱글톤 클래스는 인스턴스 초기화가 한번만 이루어지고, 해당 인스턴스를 반환하는 메소드가 존재함. 이 메소드는 *항상 동일한 인스턴스를 반환해야함*

```java
public Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){} //생성자를 private로 하여 외부에서 생성자 호출을 금지함
    public static Singleton getInstance() {//이 메소드를 통해 인스턴스반환
        return instance;
    }
}
```

## 왜 필요함?
복수의 인스턴스가 생겼을때 뜻하지 않은 버그를 방지하기 위해  
가장 대표적인 예시가 DAO임. DB에 대한 엑세스는 빈번하게 자주일어나고 복수의 인스턴스를 만들어서 DB에 접근할경우 뜻하지 않은 버그를 초래할수있음. 따라서 보통 DAO를 싱글톤패턴으로 구현함

## 더 나은 싱글톤 구현하기

### thread-safe singleton
위에 예시로 넣은 싱글톤패턴은 멀티스레드에선 복수의 인스턴스를 생성할수있음  
따라서 thread-safe한 싱글톤을 구현하려면  

```java
public class ThreadSafeSingleTon {
    private static ThreadSafeSingleTon m_instance;
    
    private ThreadSafeSingleTon() {
        System.out.println("instance created.");
    }
    
    public synchronized static ThreadSafeSingleTon getInstance() {
        if (m_instance == null) { //멀티스레드환경에서 다수의 인스턴스가 생성되는걸 방지하기위해 synchronized를 사용함
            m_instance = new ThreadSafeSingleTon();
        }
        return m_instance;
    }
}
```

### thread safe & double check singleton
하지만 저렇게 메소드에 synchronized를 걸게되면 다수의 스레드가 getinstance 메소드에 접근했을때 성능저하가 발생할수있음 (한번에 하나의 스레드만 해당 함수에 접근 가능하기 때문에) 따라서 찐으로 인스턴스를 생성할때에만 synchronized 블럭에 진입하도록 해야함  
```java
public class ThreadSafeDoubleCheckSingleton {
    private static ThreadSafeDoubleCheckSingleton m_instance;
    
    private ThreadSafeDoubleCheckSingleton() {
        System.out.println("instance created.");
    }
    
    public static ThreadSafeDoubleCheckSingleton getInstance() {
        if (m_instance == null) {
            synchronized (ThreadSafeDoubleCheckSingleton.class) {
                //새 인스턴스를 만들때만 synchronized 블럭에 진입하도록하여 성능이 저하되는것을 완화
                if (m_instance == null) {
                    m_instance = new ThreadSafeDoubleCheckSingleton();                
                }
            }
        }
        return m_instance;
    }
}
```

### init on demend holder idiom
이 방식은 synchroinzed 없이 thread-safe를 보장하는 싱글톤 구현방법으로써 jvm이 클래스를 로드하는 매커니즘을 이용한 방법임  

```java
public class InitOnDemandHolderIdiomSingleton {
    private InitOnDemandHolderIdiomSingleton() {}
    
    private static class Holder {
        //InitOnDemandHolderIdiomSingleton클래스안에는 Holder클래스를 사용하는 변수가없기때문에 
        //InitOnDemandHolderIdiomSingleton 클래스를 로드하더라도 Holder클래스가 로드되지않음
        private static final InitOnDemandHolderIdiomSingleton instance = new InitOnDemandHolderIdiomSingleton();
    }
    
    public static InitOnDemandHolderIdiomSingleton getInstance() {
        return Holder.instance;//최초 getInstance 호출시 Holder클래스가 참조되고 그때 instance를 생성하게됨. instance는 final이므로 하나의 인스턴스만 가지는걸 보장함
    }
    //따라서 멀티스레드에서 성능저하를 일으킬수있는 synchronized없이 thread-safe를 보장하면서 싱글톤을 구현. 가장 보편적으로 쓰는 싱글톤 구현방법이라함
}
```
