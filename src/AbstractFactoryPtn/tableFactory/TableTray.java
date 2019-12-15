package AbstractFactoryPtn.tableFactory;

import AbstractFactoryPtn.factory.Item;
import AbstractFactoryPtn.factory.Tray;

public class TableTray extends Tray{

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<table width=\"100%\" border=\"1\">\n")
                .append("<tr><td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + tray.size() + "\">")
                .append("<b>" + caption + "</b>")
                .append("</td></tr>");
        builder.append("<tr>");
        for(Item item:tray) {
            builder.append("<td>");
            builder.append(item.makeHTML());
            builder.append("</td>\n");
        }
        builder.append("</tr></table>");
        return builder.toString();
    }
}
