package MediatorPtn;

public interface Colleague {
    /* setMediator는 각 concreteColleague의 mediator필드에 대한 setter역할을 수행. 그렇다면 인터페이스에 필드로 넣어서 구현하면안됨?
     * --> ㄴㄴ. 인터페이스는 필드를 넣을수없음. 추상클래스라면 가능하지만, 상속은 하나의 클래스만 가능하기 때문에 인터페이스로 하는게 적절
     */
    public abstract void setMediator(Mediator mediator);
    public abstract void setColleagueEnabled(boolean enabled);
}
