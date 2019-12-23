package VisitorPtn;

import java.util.ArrayList;
import java.util.Iterator;

public class FileFoundVisitor extends Visitor{
    private String keyword;
    private ArrayList<File> foundFiles = new ArrayList<>();
    
    public FileFoundVisitor(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(keyword))
            foundFiles.add(file);
    }

    @Override
    public void visit(Directory directory) {
        Iterator iter = directory.iterator();
        while (iter.hasNext()) {
            Entry entry = (Entry) iter.next();
            entry.accept(this);
        }
    }

    public Iterator getFoundFiles() {
        return foundFiles.iterator();
    }
}
