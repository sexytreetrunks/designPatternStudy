package BridgePtn;

import java.util.Random;

public class RandomDisplay extends CountDisplay {

    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    /*    public void randomDisplay(int bound) {
        if (bound <= 0) return;
        
        Random random = new Random(System.currentTimeMillis());
        int times = random.nextInt(bound);
    
        open();
        for (int i = 0; i < times; i ++)
            print();
        close();
    }*/
    
    public void randomDisplay(int bound) { //답지에선 CountDisplay를 상속받아 구현된 multiDisplay를 사용
        if (bound <= 0) return;
        
        Random random = new Random(System.currentTimeMillis());
        multiDisplay(random.nextInt(bound));
    }

}
