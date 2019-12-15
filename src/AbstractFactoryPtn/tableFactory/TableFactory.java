package AbstractFactoryPtn.tableFactory;

import AbstractFactoryPtn.factory.Factory;
import AbstractFactoryPtn.factory.Link;
import AbstractFactoryPtn.factory.Page;
import AbstractFactoryPtn.factory.Tray;

public class TableFactory extends Factory{

    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        // TODO Auto-generated method stub
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        // TODO Auto-generated method stub
        return new TablePage(title, author);
    }

}
