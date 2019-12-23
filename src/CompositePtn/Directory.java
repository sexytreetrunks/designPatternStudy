package CompositePtn;

import java.util.ArrayList;

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
        int size = 0;
        for (Entry entry : directorys) {
            size += entry.getSize();
        }
        return size;
    }

    public Entry add(Entry entry) {
        entry.parent = this;
        directorys.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directorys) {
            entry.printList(prefix);
        }
    }
}
