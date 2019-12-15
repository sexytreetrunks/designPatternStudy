package AbstractFactoryPtn.linklistFactory;

import AbstractFactoryPtn.factory.Item;
import AbstractFactoryPtn.factory.Page;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    /*
     * Page와 Tray의 하위클래스를 보면 구현이 거의 비슷한걸 볼수있음. 그렇다면 Page를 Tray의 하위클래스로 해서 사용하는건 어떨까?
     * --> 댓츠 nono. 왜냐면 Page는 Tray에 add할수 없기때문임.
     *     Tray의 하위클래스로 Page를 설정하게되면 Page도 Item의 하위클래스가 되기때문에 tray를 통해서 add할수있음
     *     그러나 Page는 html의 시작과끝 골격을 만드는 역할을 하기때문에 tray안에 들어가게되면 html문법에 어긋나게됨
     *     만약 그래도 이 둘을 엮고싶다면 makeHTML를 가진 인터페이스를 만들어서 그 둘이 implement하도록 하는게 적절. 아래는 예시
     *     
     *     public interface HTMLable {
     *          public abstract String makeHTML();
     *     }
     *     
     *     이렇게 만든 인터페이스를 Item과 Page클래스가 implement하게하면됨
     */
    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head><title>")
                .append(title)
                .append("</title></head>\n")
                .append("<body>\n<h1>")
                .append(title)
                .append("</h1>\n<ul>\n");
        for (Item item : content) {
            builder.append(item.makeHTML());
        }
        builder.append("</ul>\n");
        builder.append("<hr><address>")
                .append(author)
                .append("</address></body></html>");
        return builder.toString();
    }

}
