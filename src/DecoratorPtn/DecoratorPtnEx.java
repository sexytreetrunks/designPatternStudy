package DecoratorPtn;

public class DecoratorPtnEx {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("hello, world");
        Display b2 = new UpdownBorder(b1, '#');
        Display b3 = new SideBorder(b1,'*');
        b1.show();
        b2.show();
        b3.show();
        Display b4 = new FullBorder(
                          new UpdownBorder(
                                  new SideBorder(
                                          new UpdownBorder(
                                                  new SideBorder(new StringDisplay("안녕하세용"), '*')
                                          ,'=')
                                  , '|')
                          , '/')
                     );
        b4.show();
        
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("좋은 아침임다");
        md.add("안녕하세여");
        md.add("안녕히 주무세요. 내일만나요");
        
        Display md1 = new SideBorder(md, '#');
        md1.show();
        Display md2 = new FullBorder(md);
        md2.show();
    }
}
