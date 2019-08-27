package TemplateMethodPtn;

public class TemplateMtdEx {
    public static void main(String[] args) {
        AbstractDisplay dp = new CharDisplay('h');
        dp.display();
        
        dp = new StringDisplay("Hello, World!");
        dp.display();
        
        dp = new StringDisplay("여부제용");
        dp.display();
    }
}
