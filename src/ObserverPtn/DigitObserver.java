package ObserverPtn;

public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver: " + generator.getNumber());
        try {
            Thread.sleep(100);//표시되는 모습이 잘 보이도록 속도를 늦춤
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
