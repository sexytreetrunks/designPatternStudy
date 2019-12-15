package AbstractFactoryPtn.linklistFactory;

import AbstractFactoryPtn.factory.Item;
import AbstractFactoryPtn.factory.Tray;

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<li>\n")
                .append(caption)
                .append("\n</li>");
        builder.append("<ul>\n");
        for (Item item : tray) {
            builder.append(item.makeHTML());
        }
        builder.append("</ul>\n");
        return builder.toString();
    }

}
