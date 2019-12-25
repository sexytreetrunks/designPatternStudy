package MementoPtn.game;

import java.util.ArrayList;

public class Memento {//gamer의 상태를 표현하는 클래스.
    /* Memento클래스에는 public이 없음 
     * --> 동일한 패키지에서만 사용할수 있도록 하기위해
     */
    int money;
    ArrayList<String> fruits;
    
    Memento(int meney) { //wide interface
        this.money = meney;
        this.fruits = new ArrayList<>();
    }
    
    public int getMoney() { //narrow interface
        return money;
    }
    
    void addFruit(String fruit) { //wide interface
        fruits.add(fruit);
    }
    
    ArrayList<String> getFruits() { //wide interface
        return fruits;
    }

    @Override
    public String toString() {
        return "Memento [money=" + money + ", fruits=" + fruits + "]";
    }
}
