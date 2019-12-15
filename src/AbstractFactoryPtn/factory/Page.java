package AbstractFactoryPtn.factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Page {
    /*
     * html페이지 전체를 추상적으로 표현한 클래스
     * Link와 Tray가 추상적인 부품이라면 Page는 이를 이용하여만든 추상적인 제품에 해당됨
     */
    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<>();
    
    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public void add(Item item) {
        content.add(item);
    }
    
    public void output() {
        // 제목을 기초로 파일명을 결정하고 makeHTML의 메소드를 사용해서 자신의 HTML의 내용을 파일에 기술
        String filename = title +".html";
        File file = new File(filename);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(filename + "을 작성했습니다.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public abstract String makeHTML();
}
