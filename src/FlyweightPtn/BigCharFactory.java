package FlyweightPtn;

import java.util.HashMap;

public class BigCharFactory {
    private static BigCharFactory singleton = new BigCharFactory();
    private HashMap<Character, BigChar> pool = new HashMap<>();
    
    private BigCharFactory() {}
    
    public static BigCharFactory getInstance() {
        return singleton;
    }
    
    public synchronized BigChar getBigChar(char charName) {
        /* getBigChar는 BigChar의 생성자를 사용하는 메소드.
         * BigChar의 생성자는 파일을 읽는 IO동작을 하므로 시간이 걸리는 동작.
         * 따라서 synchronized 처리를 하지 않으면 다중스레드환경에서 다음과 같은 상황이 벌어질수있음.
         * 1) 스레드1에서 bc가 null인걸 확인하고 new BigChar(char1) 실행
         * 2) new BigChar()에서 파일을 읽고있는 동안 스레드2가 getBigChar를 수행
         * 3) 아직 스레드1에서 해당 char의 BigChar인스턴스가 생성되지않았으므로 스레드2에서 bc값이 null
         * 4) 스레드2도 new BigChar(char1)실행 
         */
        
        BigChar bc = pool.get(charName);
        if (bc== null) {
            bc = new BigChar(charName);
            pool.put(charName, bc);
        }
        return bc;
    }
}
