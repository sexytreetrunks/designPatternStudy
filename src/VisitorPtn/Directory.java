package VisitorPtn;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private ArrayList<Entry> directorys = new ArrayList<>();
    private String name;

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        SizeVisitor v= new SizeVisitor();
        accept(v);
        return v.getSize();
    }

    public Entry add(Entry entry) {
        entry.parent = this;
        directorys.add(entry);
        return this;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    
    @Override
    public Iterator iterator() {
        return directorys.iterator();
    }
}
