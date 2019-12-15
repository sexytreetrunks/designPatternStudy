package AbstractFactoryPtn.tableFactory;

import AbstractFactoryPtn.factory.Item;
import AbstractFactoryPtn.factory.Page;

public class TablePage extends Page{

    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head><title>")
                .append(title)
                .append("</title></head>\n<body>")
                .append("<h1>"+title+"</h1>\n")
                .append("<table width=\"80%\" border=\"3\">\n");
        for(Item item:content) {
            builder.append(item.makeHTML());
        }
        builder.append("</table>\n")
                .append("<hr><address>")
                .append(author)
                .append("</address></body></html>");
        return builder.toString();
    }

}
