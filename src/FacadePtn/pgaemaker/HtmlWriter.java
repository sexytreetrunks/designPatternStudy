package FacadePtn.pgaemaker;

import java.io.IOException;
import java.io.Writer;

//HtmlWriter와 Database클래스는  default 클래스로 설정함으로써 PageMaker만 패키지 외부에서 사용할수 있도록함
class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>");
    }

    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
    }

    public void link(String href, String caption) throws IOException {
        writer.write("<a href=\"");
        writer.write(href);
        writer.write("\">");
        writer.write(caption);
        writer.write("</a>");
        writer.write("<br>");
    }

    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto:" + mailaddr, username);
    }

    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }
}
