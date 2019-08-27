package TemplateMethodPtn;

public abstract class AbstractDisplay {
    //템플릿메소드를 final로 지정하여 하위클래스에서 변경(오버라이딩)하지 못하도록함
    public final void display() {//템플릿메소드.
        open();
        for(int i=0;i<5;i++)
            print();
        close();
    }
    
    //상속관계인 클래스만 사용할수있도록함
    protected abstract void open();
    protected abstract void print();
    protected abstract void close();
}
