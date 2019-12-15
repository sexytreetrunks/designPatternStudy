package AbstractFactoryPtn;

import AbstractFactoryPtn.factory.*;

public class AbstractFactoryEx {
    /* 주의할점: 
     *  1. AbstractFactoryEx는 factory패키지의 클래스만 사용하고있기때문에 컴파일할때 listFactory/ListFactory.java 도 함께 컴파일해야함 (cmd창으로 컴파일해야함)
     *    - 근데 책에서 나온것처럼 그냥 ListFactory.java만 컴파일하면 안되고 관련 클래스들은 다 같이 컴파일해야함. listFactory랑 factory패키지안에있는 자바파일 다 컴파일해야함
     *  2. 컴파일한 클래스를 실행할땐 프로젝트소스의 루트경로(패키지명/src)에서 컴파일해야함
     *  3. 만약 컴파일이 안된다면 환경변수에있는 CLASSPATH에 ;.; 추가하기 (이거 추가 안하면 매번 컴파일할때마다 컴파일옵션 -classpath 넣어서 컴파일해야함
     *  
     * ex) main함수가있는 경로(패키지명/src/AbstractFactoryPtn)에서 컴파일 실행 (인코딩관련 에러나면 아래처럼 인코딩 옵션 넣어주기)
     *     > javac .\AbstractFactoryEx.java \factory\*.java .\linklistFactory\*.java -encoding UTF-8
     *     프로젝트소스 루트경로(패키지명/src)에서 다음명령어 실행
     *     > java AbstractFactoryPtn.AbstractFactoryEx AbstractFactoryPtn.linklistFactory.ListFactory
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java " + AbstractFactoryEx.class.getSimpleName() +" class.name.of.ConcreateFactory");
            System.exit(0);
        }
        
        Factory factory = Factory.getFactory(args[0]); //구체적인 클래스이름도 하드코딩하지말고 파라미터값으로 가져오도록하기

        //이렇게 샘플 데이터를 넣는것도 그냥 넣지말고 소분류 -> 중분류 -> 대분류 순으로 생성해서 넣으면 코드가 눈에 잘들어옴
        
        Link centerNews = factory.createLink("중앙일보", "www.joins.com");
        Link chosumNews = factory.createLink("조선일보", "www.chosun.com");

        Link yahoo = factory.createLink("Yahoo!", "www.yahoo.com");
        Link yahooKorea = factory.createLink("Yahoo!Korea", "www.yahoo.co.kr");
        Link excite = factory.createLink("Excite", "www.excite.com");
        Link google = factory.createLink("Google", "www.google.com");

        
        Tray news = factory.createTray("신문");
        news.add(centerNews);
        news.add(chosumNews);

        Tray searchSiteYahoo = factory.createTray("Yahoo!");
        searchSiteYahoo.add(yahoo);
        searchSiteYahoo.add(yahooKorea);
        
        Tray searchSite = factory.createTray("검색엔진");
        searchSite.add(searchSiteYahoo);
        searchSite.add(excite);
        searchSite.add(google);
        
        Page page = factory.createPage("LinkPage", "영진닷컴");
        page.add(news);
        page.add(searchSite);
        page.output();
    }
}
