package StrategyPtn;

public class StrategyPtnEx {
    public static void main(String[] args) {
        String[] data = {
              "Dumpty","Bowman","Carroll","Carrofl", "Elfland","Alice", "Elfland", "Zoxo"  
        };
        SortAndPrint sap = new SortAndPrint(data, new SelectionSorter());
        sap.execute();
        
        
        /*Random randomSeed = new Random(System.currentTimeMillis());
        int seed1 = randomSeed.nextInt(1000);
        int seed2 = randomSeed.nextInt(1000);
        
        Player player1 = new Player("하나", new ProbStrategy(seed1));
        Player player2 = new Player("두리", new WinningStrategy(seed2));
        for (int i=0;i<10000;i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if(nextHand1.isStrongerThan(nextHand2)) {
                //System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (nextHand1.isWeakerThan(nextHand2)) {
                //System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                //System.out.println("Even.");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result.........");
        System.out.println(player1.toString());
        System.out.println(player2.toString());*/
    }

}
