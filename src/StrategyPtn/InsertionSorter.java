package StrategyPtn;

public class InsertionSorter implements Sorter {

    @Override
    public void sort(Comparable[] data) {
        //현재값과 이전값~처음값 까지 비교해서 작으면 해당위치로 shift함
        for (int i = 1; i < data.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (data[i].compareTo(data[j]) < 0) {
                    Comparable tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }

}
