package MementoPtn.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

//gamer의 상태를 표현하는 클래스.
public class Memento implements Serializable {
    /* Memento클래스에는 public이 없음 
     * --> 동일한 패키지에서만 사용할수 있도록 하기위해
     */
    int money;
    ArrayList<String> fruits;
    private int number;

    Memento(int meney) { //wide interface
        this.money = meney;
        this.fruits = new ArrayList<>();
        this.number = new Random().nextInt();
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

    int getNumber() {
        /* number필드를 private으로 설정하고 getter는 default로 하여
         * memento내부에서만 값을 변경하고, 같은패키지인 gamer에서만 값을 가져올수있도록 함
         */
        return number;
    }

    @Override
    public String toString() {
        return "Memento [money=" + money + ", fruits=" + fruits + "]";
    }
}
