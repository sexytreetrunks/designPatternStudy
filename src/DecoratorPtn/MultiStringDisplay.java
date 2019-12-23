package DecoratorPtn;

import java.util.ArrayList;

public class MultiStringDisplay extends Display {
    private ArrayList<String> strings = new ArrayList<>();
    private int maxLength = 0;

    @Override
    public int getColums() {
        return maxLength;
    }

    @Override
    public int getRows() {
        return strings.size();
    }

    @Override
    public String getRowText(int row) {
        StringBuilder builder = new StringBuilder();
        String str = strings.get(row);
        int spaceLen = maxLength - str.getBytes().length;
        builder.append(str);
        for (int i = 0; i < spaceLen; i ++)
            builder.append(' ');
        return builder.toString();
    }

    public void add(String string) {
        strings.add(string);
        int len = string.getBytes().length;
        if (len > maxLength)
            maxLength = len;
    }
}
