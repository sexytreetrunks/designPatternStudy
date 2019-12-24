package ChainOfResponsibilityPtn;

public class NoSupport extends Support{

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // 항상 false를 리턴하여 아무 문제도 처리하지않음을 나타냄.
        return false;
    }
    
}
