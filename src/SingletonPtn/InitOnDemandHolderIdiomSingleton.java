package SingletonPtn;

public class InitOnDemandHolderIdiomSingleton {
    private InitOnDemandHolderIdiomSingleton() {}
    
    private static class Holder {
        //InitOnDemandHolderIdiomSingleton클래스안에는  Holder클래스를 사용하는 변수가없기때문에 
        //InitOnDemandHolderIdiomSingleton 클래스를 로드하더라도 Holder클래스가 로드되지않음
        private static final InitOnDemandHolderIdiomSingleton instance = new InitOnDemandHolderIdiomSingleton();
    }
    
    public static InitOnDemandHolderIdiomSingleton getInstance() {
        return Holder.instance;//최초 getInstance 호출시 Holder클래스가 참조되고 그때 instance를 생성하게됨. instance는 final이므로 하나의 인스턴스만 가지는걸 보장함
    }
    //따라서 멀티스레드에서 성능저하를 일으킬수있는 synchronized없이 thread-safe를 보장하면서 싱글톤을 구현. 가장 보편적으로 쓰는 싱글톤 구현방법이라함
}
