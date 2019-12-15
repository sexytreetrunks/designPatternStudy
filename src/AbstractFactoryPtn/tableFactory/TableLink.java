package AbstractFactoryPtn.tableFactory;

import AbstractFactoryPtn.factory.Link;

public class TableLink extends Link{

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<a href=\"")
                .append(url)
                .append("\">")
                .append(caption)
                .append("</a>");
        return builder.toString();
    }

}
