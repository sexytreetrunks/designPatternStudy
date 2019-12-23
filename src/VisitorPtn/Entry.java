package VisitorPtn;

import java.util.Iterator;

public abstract class Entry implements Element {//Entry클래스를 Visitor패턴에 적용하기위해 Element를 구현
    protected Entry parent;
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    
    public String toString() {
        return getName() +" {" + getSize() + "} ";
    }
    
    public Iterator iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }
}
