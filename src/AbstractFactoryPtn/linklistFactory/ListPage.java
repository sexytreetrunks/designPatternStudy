package AbstractFactoryPtn.linklistFactory;

import AbstractFactoryPtn.factory.Item;
import AbstractFactoryPtn.factory.Page;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

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
