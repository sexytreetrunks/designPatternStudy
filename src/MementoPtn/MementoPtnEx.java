package MementoPtn;

import MementoPtn.game.Gamer;
import MementoPtn.game.Memento;

public class MementoPtnEx {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();//최초상태 저장
        for (int i = 0; i < 100; i ++) {
            System.out.println("======" + i);
            System.out.println("현재상태: " + gamer);

            gamer.bet();
            System.out.println("소지금은 " + gamer.getMoney() + "원이 됨");

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("증가했으므로 현재상태를 저장하자");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("많이 감소했으므로 이전 상태로 복원하자");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
