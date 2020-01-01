package FlyweightPtn;

public class FlyweightPtnEx {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("put digits for args");
            System.out.println("Usage: java Main 1212");
            System.exit(0);
        }
        System.out.println("메모리 공유 X");
        BigString bigStr = new BigString(args[0], false);
        //bigStr.print();
        printUsedMem();
        
        bigStr = null;        
        Runtime.getRuntime().gc();
        
        System.out.println("메모리 공유 O");
        bigStr = new BigString(args[0], true);
        //bigStr.print();
        printUsedMem();
    }
    
    public static void printUsedMem() {
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("사용 메모리 = " + used);
    }
}
