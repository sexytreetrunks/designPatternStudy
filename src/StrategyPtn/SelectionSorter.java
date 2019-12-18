package StrategyPtn;

public class SelectionSorter implements Sorter {

    @Override
    public void sort(Comparable[] data) {
        // 맨처음 '인덱스'부터 시작하여 해당 인덱스에 들어갈 수를 찾아 넣음 
        for (int i = 0; i < data.length - 1; i ++) {
            int min = i;
            for (int j = i + 1; j < data.length; j ++) {
                if (data[min].compareTo(data[j]) > 0)
                    min = j;
            }
            Comparable tmp = data[i];
            data[i] = data[min];
            data[min] = tmp;
        }
    }

}
