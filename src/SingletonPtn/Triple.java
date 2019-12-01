package SingletonPtn;

public class Triple {
    private static final int INSTANCE_MAX = 3;
    private int id;
    private static Triple[] instances = new Triple[INSTANCE_MAX];//책에선 배열생성시 인스턴스를 모두 초기화시켜놓음
    private Triple(int id) {
        System.out.println("인스턴스 생성");
    }
    
    public static Triple getInstance(int id) {
        if(id >= INSTANCE_MAX || id < 0)
            return null;
        Triple instance = instances[id];
        if(instance == null)
            instance = new Triple(id);
        return instance;
    }
}
