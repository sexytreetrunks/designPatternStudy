package AbstractFactoryPtn.linklistFactory;

import AbstractFactoryPtn.factory.Link;

public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
        /* caption과 url필드를 초기화하기 위해선 Link의 생성자가 필요함.
         * 생성자는 override할수없으므로 Link의 생성자에 맞는 ListLink의 생성자를 만들어주고 super로 상위클래스의 생성자를 호출해야함
         */
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
