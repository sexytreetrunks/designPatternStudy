package AbstractFactoryPtn.factory;

public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(classname + " 클래스가 발견되지 않았습니다.");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return factory;
    }
    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
    public Page createYahooPage() {
        String yahoo = "Yahoo!";
        
        Link link = createLink(yahoo, "www.yahoo.com");
        
        Page page = createPage(yahoo,yahoo);
        page.add(link);
        
        return page;
    }
}
