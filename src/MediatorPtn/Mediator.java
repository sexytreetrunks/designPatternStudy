package MediatorPtn;

public interface Mediator {
    public abstract void createColleague();
    public abstract void colleagueChanged();//colleague에서 호출되는 메소드. colleague필드의 상태가 변할때 이 메소드가 호출됨
}
