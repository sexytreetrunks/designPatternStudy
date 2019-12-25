package ObserverPtn;

import java.util.ArrayList;

public abstract class NumberGenerator {//수를 생성하는 클래스
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers)
            o.update(this);
    }

    //구체적인 기능은 하위클래스에서 작성하도록 함(subclass responsibility)
    public abstract int getNumber();

    public abstract void execute();
}
