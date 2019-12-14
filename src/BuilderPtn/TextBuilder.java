package BuilderPtn;

public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer(); 
    /* String 클래스는 문자열 접합시 매번 새로 String객체를 할당(메모리를 할당)하여 문자열을 합치기때문에 
     * String을 이용하면 속도가 훨씬 느림
     * 따라서 기존에 만든 문자열메모리를 계속 사용하고 반환하는 형태인 StringBuilder나 StringBuffer를 사용하는게 좋음
     */
    @Override
    public void buildTitle(String title) {
        buffer.append("=================================\n");
        buffer.append('『' + title + "』\n");
        buffer.append("\n");
    }

    @Override
    public void buildString(String str) {
        buffer.append('▶' + str + "\n");
        buffer.append("\n");
    }

    @Override
    public void buildItems(String[] items) {
        for (String item:items) {
            buffer.append("  ●" + item + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void buildDone() {
        buffer.append("====================================");
    }
    
    public String getResult() {
        return buffer.toString();
    }
}
