package AbstractFactoryPtn.linklistFactory;

import AbstractFactoryPtn.factory.Link;

public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<li><a href=\"")
                .append(url)
                .append("\">")
                .append(caption)
                .append("</a></li>\n");
        return builder.toString();
    }

}
