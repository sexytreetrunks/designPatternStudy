package TemplateMethodPtn;

public class StringDisplay extends AbstractDisplay{
    private String str;
    private int width;
    
    public StringDisplay(String str) {
        this.str = str;
        //this.width = str.length();
        this.width = str.getBytes().length; //영어가 아닌 문자열의 너비에도 맞춰서 출력하려면 byte단위로 문자열길이를 계산해야함. 참고로 이클립스 콘솔에선 한글너비가 작아서 너비가 안맞춰짐
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close() {
        printLine();
    }
    
    private void printLine() {//중복되는 코드는 메소드로 빼주세용
        System.out.print("+");
        for(int i=0;i<width;i++)
            System.out.print("-");
        System.out.println("+");
    }
}
