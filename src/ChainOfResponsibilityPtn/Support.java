package ChainOfResponsibilityPtn;

public abstract class Support {
    private String name;
    private Support next; //떠넘길곳이 지정된 필드

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        // resolve로 해결하지 못하면 다음사람에게 떠넘기기. 떠넘기기할 사람이 없으면 fail
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
        /*
        //위의 코드를 재귀문이 아닌 반복문으로하면 아래와 같음
        for (Support obj = this; true; obj = obj.next) {
            if (obj.resolve(trouble)) {
                obj.done(trouble);
                break;
            } else if (obj.next == null) {
                obj.fail(trouble);
                break;
            }
        }
        */
    }

    public String toString() {
        return "[" + name + "]";
    }

    /* resolve는 support 내부에서만 쓰이는 함수이지만 하위클래스에서 구현해야하는 메소드 이므로
     * protected로 지정하여 하위클래스에서 구현하고 외부에선 호출될수없도록함
     */
    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
