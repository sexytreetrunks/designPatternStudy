package StrategyPtn;

public class SortAndPrint {
    private Comparable[] data;
    private Sorter sorter;
    
    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }
    
    public void execute() {
        print();
        sorter.sort(data);
        print();
    }
    
    private void print() {
        for(Comparable c:data) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }
}
